package com.reciproci.loyalty.burnrule.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reciproci.loyalty.burnrule.entity.BurnRule;
import com.reciproci.loyalty.burnrule.entity.BurnRuleLocale;
import com.reciproci.loyalty.burnrule.entity.RewardValue;
import com.reciproci.loyalty.burnrule.exception.BurnRuleAlreadyExistsException;
import com.reciproci.loyalty.burnrule.model.CreateBurnRuleBean;
import com.reciproci.loyalty.burnrule.model.RewardValueBean;
import com.reciproci.loyalty.burnrule.model.RuleLocalBean;
import com.reciproci.loyalty.burnrule.model.ViewBean;
import com.reciproci.loyalty.burnrule.model.ViewProgramBean;
import com.reciproci.loyalty.burnrule.repository.BurnRuleRepository;
import com.reciproci.loyalty.earnrule.entity.Language;
import com.reciproci.loyalty.earnrule.entity.Store;
import com.reciproci.loyalty.earnrule.repository.LanguageRepo;
import com.reciproci.loyalty.earnrule.repository.StoreRepo;
import com.reciproci.loyalty.program.entity.Program;
import com.reciproci.loyalty.program.repository.ProgramRepository;


@Service
public class BurnRuleService {

	private static final Logger log = LoggerFactory.getLogger(BurnRuleService.class);
	
	@Autowired
	private ProgramRepository programRepo;
	
	@Autowired
	private BurnRuleRepository burnRuleRepository;

	@Autowired
	private StoreRepo storeRepo;
	
	@Autowired
	private LanguageRepo laguageRepo;

	
	public void saveBurnRule(CreateBurnRuleBean bean) {
		
		log.info("Attempting to save Burn Rule for Program Id: {}", bean.getProgramId());
	    // 1. Validation: Use the custom exception here
	    if (burnRuleRepository.existsByProgramId(bean.getProgramId())) {
	    	log.warn("Validation faild: Burn Rule already exists for Program ID: {}", bean.getProgramId());
	        throw new BurnRuleAlreadyExistsException("Validation Failed: A Burn Rule already exists for Program ID " 
	                                    + bean.getProgramId() + ". You can only create one rule per program.");
	    }

	    // 2. Fetch the Program
	    Program program = programRepo.findById(bean.getProgramId())
	            .orElseThrow(() -> {
	            	log.error("Program lookup failed: Id {} not found", bean.getProgramId());
	            	return new RuntimeException("Program not found with ID: " + bean.getProgramId());
	            });

	    // 3. Create and Map the BurnRule Entity
	    log.debug("Mapping BurnRule entity for program: {}", program.getProgramName());
	    BurnRule burnRule = new BurnRule();
	    
	    burnRule.setProgram(program);
	    burnRule.setProgramId(bean.getProgramId()); 
	    
	    burnRule.setRewardType(bean.getRewardType());
	    burnRule.setRewardQty(bean.getRewardQty());
	    burnRule.setRewardImagePath(bean.getRewardImagePath());
	    burnRule.setRuleImagepath(bean.getRuleImagepath());
	    burnRule.setStartDate(bean.getStartDate());
	    burnRule.setEndDate(bean.getEndDate());
	    burnRule.setDisplayHomeScreen(bean.isDisplayHomeScreen());
	    burnRule.setExclusive(bean.isExclusive());
	    burnRule.setSkuFilePath(bean.getSkuFilePath());
	    burnRule.setMinimumPoints(bean.getMinimumPoints());
	    burnRule.setExcludeStore(bean.isExcludeStore());
	    burnRule.setExcludeSku(bean.isExcludeSku());
	    burnRule.setFreeProductType(bean.getFreeProductType());
	    
	    
	    
	    List<RewardValue> rewardValues = bean.getRewardValues();
	    List<RewardValue> list = new ArrayList<>();
	    for(RewardValue reward : rewardValues) {
	    	reward.setBurnRule(burnRule);
	    	list.add(reward);
	    }
	    burnRule.setRewardValues(rewardValues);
	    
	    

	    // 4. Handle Many-to-Many Stores
	    if (bean.getStore() != null && !bean.getStore().isEmpty()) {
	    	log.debug("Linking {} stores to Burn Rule", bean.getStore().size());
	        List<Store> allById = storeRepo.findAllById(bean.getStore());
	        burnRule.setStore(allById);
	    }
	    
	    // 5. Handle Language
	    Language lang = laguageRepo.findById(bean.getLanguageId())
	            .orElseThrow(() -> {
	            	log.error("Language ID {} is invalid", bean.getLanguageId());
	            	return new RuntimeException("Language not found");
	            });
	    
	    if (burnRule.getLanguage() == null) {
	        burnRule.setLanguage(new ArrayList<>());
	    }
	    burnRule.getLanguage().add(lang);

	    // 6. Handle One-to-Many Locales
	    if (bean.getRuleLocales() != null) {
	        List<BurnRuleLocale> locales = bean.getRuleLocales().stream().map(localeEntity -> {
	            localeEntity.setBurnRule(burnRule); 
	            return localeEntity;
	        }).collect(Collectors.toList());
	        burnRule.setRuleLocaleList(locales);
	    }
	    
	    try {
	    	// 7. Save to Database
	    	burnRuleRepository.save(burnRule);
			log.info("Successfully saved Burn Rule for Program ID: {}", bean.getProgramId());
		} catch (Exception e) {
			log.error("Failed to persist Burn Rule for Program ID: {}. Error: {}", bean.getProgramId(), e.getMessage());
			throw e;
		}

	}
	
	public void update(CreateBurnRuleBean bean) {
		
		log.info("Strarting to Update Burn Rule for Program ID: {}", bean.getProgramId());
		
		BurnRule existingRule = burnRuleRepository.findById(bean.getProgramId())
	            .orElseThrow(() -> {
	            	log.error("Update failed: No Existing Burn Rule found for Program ID: {}",bean.getProgramId());
	            	return new RuntimeException("No Burn Rule found for Program ID: " + bean.getProgramId());
	            });
		
		log.debug("Updating basic fields for Program ID: {}", bean.getProgramId());

	    // 2. Update Basic Fields on the existing object
	    existingRule.setRewardType(bean.getRewardType());
	    existingRule.setRewardQty(bean.getRewardQty());
	    existingRule.setRewardImagePath(bean.getRewardImagePath());
	    existingRule.setRuleImagepath(bean.getRuleImagepath());
	    existingRule.setStartDate(bean.getStartDate());
	    existingRule.setEndDate(bean.getEndDate());
	    existingRule.setDisplayHomeScreen(bean.isDisplayHomeScreen());
	    existingRule.setExclusive(bean.isExclusive());
	    existingRule.setSkuFilePath(bean.getSkuFilePath());
	    existingRule.setMinimumPoints(bean.getMinimumPoints());
	    existingRule.setExcludeStore(bean.isExcludeStore());
	    existingRule.setExcludeSku(bean.isExcludeSku());
	    existingRule.setFreeProductType(bean.getFreeProductType());
	    
	    
	    if(bean.getRewardValues() != null) {
	    	log.debug("Processing {} reward value entries for update", bean.getRewardValues().size());
	    	
	    	Map<Long, RewardValue> reward = existingRule.getRewardValues().stream()
	    			.collect(Collectors.toMap(RewardValue :: getTierId, t -> t));
	    	
	    	List<RewardValue> updatedRewardValues = new ArrayList<>();
	    	existingRule.getRewardValues().clear();
	    	
	    	for(RewardValue rewardValue : bean.getRewardValues()) {
	    		RewardValue foundValue = reward.get(rewardValue.getTierId());
	    		log.trace("Creating new RewardValue for Tier ID: {}",rewardValue.getTierId());
	    		if(foundValue == null) {
	    			foundValue = new RewardValue();
	    			foundValue.setBurnRule(existingRule);
	    		}
	    		foundValue.setRegionId(rewardValue.getRegionId());
	    		foundValue.setTierId(rewardValue.getTierId());
	    		foundValue.setRewardValue(rewardValue.getRewardValue());
	    		updatedRewardValues.add(foundValue);
	    	}
	    	
	    	existingRule.getRewardValues().clear();
	    	existingRule.getRewardValues().addAll(updatedRewardValues);
	    }
	    

	    // 3. Update Stores (Many-to-Many)
	    if (bean.getStore() != null) {
	    	log.debug("Updating store associations. New Store count: {}", bean.getStore().size());
	        List<Store> updatedStores = storeRepo.findAllById(bean.getStore());
	        existingRule.setStore(updatedStores);
	    }

	    // 4. Update Languages
	    Language lang = laguageRepo.findById(bean.getLanguageId())
	            .orElseThrow(() -> {
	            	log.error("Language update failed: ID {} not found",bean.getLanguageId());
	            	return new RuntimeException("Language not found");
	            });
	    
	    // Clear and add to prevent duplicates in the ManyToMany join table
	    existingRule.getLanguage().clear(); 
	    existingRule.getLanguage().add(lang);

	    
	    if(bean.getRuleLocales()!=null) {
	    	log.debug("Syncing {} locales for Program ID: {}", bean.getRuleLocales().size(), bean.getProgramId());
	    	Map<Long, BurnRuleLocale> existingMap =  existingRule.getRuleLocaleList().stream()
	    	.collect(Collectors.toMap(BurnRuleLocale ::getId, t-> t));
	    	
	    	List<BurnRuleLocale> listOfLocales = new ArrayList<>();
	    	existingRule.getRuleLocaleList().clear();
	    	for(BurnRuleLocale local : bean.getRuleLocales()) {
	    		BurnRuleLocale locale = existingMap.get(local.getId());
	    		if(locale == null) {
	    			locale = new BurnRuleLocale();
	    			locale.setBurnRule(existingRule);
	    		}
	    		locale.setDescription(local.getDescription());
	    		locale.setRuleName(local.getRuleName());
	    		locale.setTermsAndConditions(local.getTermsAndConditions());
	    		listOfLocales.add(locale);
	    	}
	    	existingRule.getRuleLocaleList().clear();
	    	existingRule.getRuleLocaleList().addAll(listOfLocales);
	    }
	    
	    try {
	    	// 6. Save (JPA will perform an UPDATE because the 'existingRule' has an ID)
	    	burnRuleRepository.save(existingRule);
			log.info("Successfully updated Burn Rule for Program ID: {}",bean.getProgramId());
		} catch (Exception e) {
			log.error("Database error while updating Burn Rule for Program ID: {}. Error: {}",
					bean.getProgramId(), e.getMessage());
			throw e;
		}

	}
	
	public ViewBean viewBurnRule(Map<String, Long> request) {
	    Long burnRuleId = request.get("burnRuleId");
	    
	    log.info("Fetching Burn Rule details for ID: {}", burnRuleId);
	    
	    // 1. Fetch the Entity
	    BurnRule burnRule = burnRuleRepository.findById(burnRuleId)
	            .orElseThrow(() -> {
	            	log.error("Read Failed: Burn Rule ID {} does not exist in the database", burnRuleId);
	            	return new RuntimeException("Burn Rule not found for ID; " + burnRuleId);
	            });

	    // 2. Map Entity to ViewBean
	    log.debug("Mapping BurnRule entity to viewBean for ID: {}", burnRuleId);
	    ViewBean viewBean = new ViewBean();
	    viewBean.setBurnRuleId(burnRule.getId());
	    viewBean.setProgramId(burnRule.getProgramId());
	    viewBean.setRuleImagePath(burnRule.getRuleImagepath());
	    viewBean.setRewardType(burnRule.getRewardType());
	    viewBean.setRewardQty(burnRule.getRewardQty());
	    viewBean.setRewardImagePath(burnRule.getRewardImagePath());
	    viewBean.setSkuFilePath(burnRule.getSkuFilePath());
	    viewBean.setMinimumPoints(burnRule.getMinimumPoints());
	    viewBean.setExcludeSku(burnRule.isExcludeSku());
	    viewBean.setExcludeStore(burnRule.isExcludeStore());
	    viewBean.setDisplayHomeScreen(burnRule.isDisplayHomeScreen());
	    viewBean.setExclusive(burnRule.isExclusive());
	    
	    log.trace("Mapping {} RewardValue entries", burnRule.getRewardValues().size());
	    List<RewardValueBean> arrayList = new ArrayList<>();
	    for(RewardValue reward : burnRule.getRewardValues()) {
	    	RewardValueBean rewardValueBean = new RewardValueBean();
	    	rewardValueBean.setRegionId(reward.getRegionId());
	    	rewardValueBean.setTierid(reward.getTierId());
	    	rewardValueBean.setRewardValue(reward.getRewardValue());
	    	arrayList.add(rewardValueBean);
	    }
	    viewBean.setRewardValues(arrayList);

	    // 3. Map Store List
	    if (burnRule.getStore() != null) {
	    	log.debug("Found {} associated stores for Burn Rule {}", burnRule.getStore().size(), burnRuleId);
	        viewBean.setStoreList(burnRule.getStore());
	    }

	    // 4. Map Locales to RuleLocalBean
	    if (burnRule.getRuleLocaleList() != null) {
	    	log.debug("Mapping {} locales for Burn Rule {}", burnRule.getRuleLocaleList().size(), burnRuleId);
	        List<RuleLocalBean> localeBeans = burnRule.getRuleLocaleList().stream().map(locale -> {
	            RuleLocalBean localBean = new RuleLocalBean();
	            localBean.setRuleName(locale.getRuleName());
	            localBean.setDescription(locale.getDescription());
	            localBean.setTermsAndConditions(locale.getTermsAndConditions());
	            return localBean;
	        }).collect(Collectors.toList());
	        viewBean.setRuleLocalList(localeBeans);
	    }
	    log.info("Successfully retrieved ViewBean for Burn Rule ID: {}", burnRuleId);
	    return viewBean;
	}
	
	public ViewProgramBean getProgramDetails(Map<String, Object> request) {
	    // 1. Extract and convert ID from request body
	    Object idObj = request.get("burnRuleId");
	    Long burnRuleId = Long.valueOf(idObj.toString());
	    
	    log.info("Fetching Burn Rule Details for ID: {}", burnRuleId);

	    // 2. Fetch the Entity
	    BurnRule burnRule = burnRuleRepository.findById(burnRuleId)
	            .orElseThrow(() -> new RuntimeException("Burn Rule not found for ID: " + burnRuleId));
	    Program program =  programRepo.findById(burnRule.getProgramId()).orElseThrow();
	    // 3. Map Entity to ViewProgramBean
	    ViewProgramBean bean = new ViewProgramBean();
	    bean.setBurnRuleId(burnRule.getId());
	    bean.setRuleName(program.getProgramName());
	    bean.setRewardType(burnRule.getRewardType());
	    bean.setRedeemQty(burnRule.getRewardQty());
	    bean.setStartDate(burnRule.getStartDate());
	    bean.setEndDate(burnRule.getEndDate());
	    
	    // Mapping redeemType (using rewardType as a fallback if not explicitly stored)
	    bean.setRedeemType(burnRule.getRewardType());

	    // 4. Extract Rule Name from the first available locale
	    if (burnRule.getRuleLocaleList() != null && !burnRule.getRuleLocaleList().isEmpty()) {
	        bean.setRuleName(burnRule.getRuleLocaleList().get(0).getRuleName());
	    } else {
	        bean.setRuleName("N/A");
	    }

	    return bean;
	}

}
