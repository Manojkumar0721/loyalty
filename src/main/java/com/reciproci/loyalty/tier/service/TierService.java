package com.reciproci.loyalty.tier.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reciproci.loyalty.earnrule.entity.Country;
import com.reciproci.loyalty.earnrule.repository.CountryRepo;
import com.reciproci.loyalty.tier.entity.TierConfig;
import com.reciproci.loyalty.tier.entity.TierRegion;
import com.reciproci.loyalty.tier.exceptions.TierValidationException;
import com.reciproci.loyalty.tier.model.TierBean;
import com.reciproci.loyalty.tier.model.TierLookupBean;
import com.reciproci.loyalty.tier.model.TierRegionBean;
import com.reciproci.loyalty.tier.model.TierRequestWrapperBean;
import com.reciproci.loyalty.tier.repository.TierRegionRepository;
import com.reciproci.loyalty.tier.repository.TierRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TierService {
	
	@Autowired
    private TierRegionRepository tierRegionRepository;
	
	@Autowired
	private TierRepository tierRepository;

    @Autowired
    private CountryRepo countryRepository;

    public void saveTierQualification(TierRequestWrapperBean request) {
        
        for (TierRegionBean regionDto : request.getTierRegionList()) {
            Long countryId = regionDto.getCountryId();
            String countryName = regionDto.getCountryName();

            // 1. THE NEW CONDITION: Check if tiers already exist for this country
            // We use the repository to see if a record with this countryId is already present
            boolean alreadyExists = tierRegionRepository.existsByCountryId(countryId);
            
            if (alreadyExists) {
                throw new TierValidationException(
                    String.format("Configuration Error: Tiers for '%s' (ID: %d) are already configured. " + 
                    "You cannot add new tiers for this country.", countryName, countryId)
                );
            }

            // 2. Logic: Ensure exactly 5 tiers are provided in the current request
            List<TierBean> tiers = regionDto.getTierList();
            if (tiers == null || tiers.size() != 5) {
                throw new TierValidationException(
                    String.format("Validation Failed: Country '%s' must have exactly 5 tiers. Received: %d.", 
                    countryName, (tiers == null ? 0 : tiers.size()))
                );
            }

            // 3. Fetch Country from DB to ensure valid reference
            Country country = countryRepository.findById(countryId)
                .orElseThrow(() -> new TierValidationException("Country ID " + countryId + " not found in database."));

            // 4. Mapping and Saving (Atomic operation)
            TierRegion tierRegion = new TierRegion();
            tierRegion.setCountry(country);
            tierRegion.setTierEngagementDays(regionDto.getTierEngagementDays());
            tierRegion.setCreatedTime(LocalDateTime.now());
            tierRegion.setModifiedTime(LocalDateTime.now());

            List<TierConfig> tierConfigs = tiers.stream().map(tierDto -> {
                TierConfig config = new TierConfig();
                config.setTierName(tierDto.getTierName());
                config.setMinAmount(tierDto.getMinAmount());
                config.setMaxAmount(tierDto.getMaxAmount());
                config.setTierLevel(tierDto.getTierLevel());
                config.setTierImage(tierDto.getTierImage());
                config.setTierRegion(tierRegion); 
                return config;
            }).collect(Collectors.toList());

            tierRegion.setTierList(tierConfigs);
            
            tierRegionRepository.save(tierRegion);
        }
    }
    
    public void updateTierQualification(TierRequestWrapperBean request) {
        if (request.getTierRegionList() == null || request.getTierRegionList().isEmpty()) {
            throw new TierValidationException("Update failed: Request body is empty.");
        }

        for (TierRegionBean regionDto : request.getTierRegionList()) {
            Long countryId = regionDto.getCountryId();
            String countryName = regionDto.getCountryName();

            // 1. Fetch existing record. If it doesn't exist, we cannot update it.
            TierRegion existingRegion = tierRegionRepository.findByCountryId(countryId)
                .orElseThrow(() -> new TierValidationException(
                    String.format("Update Failed: No existing configuration found for '%s' (ID: %d). Please use Save instead.", 
                    countryName, countryId)));

            // 2. STRICT 5-TIER VALIDATION: Same as save method
            List<TierBean> newTiers = regionDto.getTierList();
            int tierCount = (newTiers != null) ? newTiers.size() : 0;
            
            if (tierCount != 5) {
                throw new TierValidationException(
                    String.format("Update Failed: Country '%s' must have exactly 5 tiers. You provided %d.", 
                    countryName, tierCount));
            }

            // 3. Update top-level region details (Audit fields)
            existingRegion.setTierEngagementDays(regionDto.getTierEngagementDays());
            existingRegion.setModifiedTime(LocalDateTime.now());

            // 4. Update the Tiers
            // Note: Clear existing and re-add ensures we always have exactly 5 current configs
            existingRegion.getTierList().clear(); 

            for (TierBean tierDto : newTiers) {
                TierConfig config = new TierConfig();
                config.setTierName(tierDto.getTierName());
                config.setTierImage(tierDto.getTierImage());
                config.setMinAmount(tierDto.getMinAmount());
                config.setMaxAmount(tierDto.getMaxAmount());
                config.setTierLevel(tierDto.getTierLevel());
                config.setTierRegion(existingRegion); // Link to parent
                existingRegion.getTierList().add(config);
            }

            // 5. Save the updated graph
            tierRegionRepository.save(existingRegion);
        }
    }
    
    public List<TierRegionBean> getAllTierQualifications() {
        List<TierRegion> regions = tierRegionRepository.findAll();
        
        // Map Entities back to Beans/DTOs
        return regions.stream().map(this::mapToBean).collect(Collectors.toList());
    }

    // Helper method to convert Entity to Bean
    private TierRegionBean mapToBean(TierRegion entity) {
        TierRegionBean bean = new TierRegionBean();
        bean.setRegionId(entity.getId());
        bean.setCountryId(entity.getCountry().getId());
        bean.setCountryName(entity.getCountry().getCountryName());
        bean.setTierEngagementDays(entity.getTierEngagementDays());
        
        List<TierBean> tierBeans = entity.getTierList().stream().map(t -> {
            TierBean tb = new TierBean();
            tb.setTierId(t.getId());
            tb.setTierName(t.getTierName());
            tb.setTierImage(t.getTierImage());
            tb.setMinAmount(t.getMinAmount());
            tb.setMaxAmount(t.getMaxAmount());
            tb.setTierLevel(t.getTierLevel());
            return tb;
        }).collect(Collectors.toList());
        
        bean.setTierList(tierBeans);
        return bean;
    }

	public List<TierLookupBean> getTierLookupList() {
		List<TierLookupBean> list = new ArrayList<>();
		List<TierConfig> all = tierRepository.findAll();
		for(TierConfig config : all) {
			TierLookupBean bean = new TierLookupBean();
			bean.setTierId(config.getTierLevel());
			bean.setTierName(config.getTierName());
			list.add(bean);
		}
		return list;
	}
    
    

}
