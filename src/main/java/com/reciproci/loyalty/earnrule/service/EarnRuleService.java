package com.reciproci.loyalty.earnrule.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reciproci.loyalty.earnrule.entity.Country;
import com.reciproci.loyalty.earnrule.entity.EarnRule;
import com.reciproci.loyalty.earnrule.entity.EarnRuleLocales;
import com.reciproci.loyalty.earnrule.entity.EarnRuleTransactionAmountDefs;
import com.reciproci.loyalty.earnrule.entity.EarnRuleTransactionPointDefs;
import com.reciproci.loyalty.earnrule.entity.Language;
import com.reciproci.loyalty.earnrule.entity.Store;
import com.reciproci.loyalty.earnrule.model.CreateEarnBean;
import com.reciproci.loyalty.earnrule.model.EarnRuleAmountDefBean;
import com.reciproci.loyalty.earnrule.model.EarnRuleLocalesBean;
import com.reciproci.loyalty.earnrule.model.EarnRulePointDefBean;
import com.reciproci.loyalty.earnrule.model.EarnViewBean;
import com.reciproci.loyalty.earnrule.model.EarnViewRequestBean;
import com.reciproci.loyalty.earnrule.model.GetDetailsBean;
import com.reciproci.loyalty.earnrule.model.TransactionAmountDefs;
import com.reciproci.loyalty.earnrule.model.TransactionPointDef;
import com.reciproci.loyalty.earnrule.model.earnRuleTransactionAmountDefsBean;
import com.reciproci.loyalty.earnrule.model.earnRuleTransactionPointDefsBean;
import com.reciproci.loyalty.earnrule.repository.CountryRepo;
import com.reciproci.loyalty.earnrule.repository.EarnRuleLocaleRepo;
import com.reciproci.loyalty.earnrule.repository.EarnRuleRepo;
import com.reciproci.loyalty.earnrule.repository.EarnRuleTransactionAmount;
import com.reciproci.loyalty.earnrule.repository.EarnRuleTransactionPoint;
import com.reciproci.loyalty.earnrule.repository.LanguageRepo;
import com.reciproci.loyalty.earnrule.repository.StoreRepo;
import com.reciproci.loyalty.program.entity.Program;
import com.reciproci.loyalty.program.repository.ProgramRepository;
import com.reciproci.loyalty.tier.entity.TierConfig;
import com.reciproci.loyalty.tier.repository.TierRepository;

@Service
public class EarnRuleService {
	@Autowired
	private EarnRuleRepo earnRuleRepo;
	@Autowired
	private ProgramRepository programRepo;
	@Autowired
	private CountryRepo countryRepo;
	@Autowired
	private StoreRepo storeRepo;
	@Autowired
	private LanguageRepo languageRepo;
	@Autowired
	private EarnRuleLocaleRepo earnRuleLocaleRepo;
	
	@Autowired
	private EarnRuleTransactionAmount earnRuleTransactionAmount;
	
	@Autowired
	private EarnRuleTransactionPoint earnRuleTransactionPoint;
	
	@Autowired
	private TierRepository tierRepository;
	
	public void create(CreateEarnBean createBean) {
	    EarnRule earnRule = new EarnRule();
	   
	    Program program = programRepo.findById(createBean.getProgramId())
	        .orElseThrow(() -> new RuntimeException("Program not found"));
	    earnRule.setProgram(program);
	    List<EarnRuleTransactionPointDefs> pointsList = new ArrayList<>();
	    for(earnRuleTransactionPointDefsBean points:createBean.getEarnRuleTransactionPointDefs()) {
		   EarnRuleTransactionPointDefs point = new EarnRuleTransactionPointDefs();
		   point.setMarkupType(points.getMarkupType());
		   point.setTierId(points.getTierId());
		   point.setNoOfRewards(points.getNoOfRewards());
		   point.setEarnRule(earnRule);
		   pointsList.add(point);
	    }
	    earnRule.setEarnRuleTransactionPointDefs(pointsList);
	    List<EarnRuleTransactionAmountDefs> ListOfAmount = new ArrayList<>();
	    for(earnRuleTransactionAmountDefsBean amountbean:createBean.getEarnRuleTransactionAmountDefs()) {
	    	EarnRuleTransactionAmountDefs amount = new EarnRuleTransactionAmountDefs();
	    	amount.setTierId(amountbean.getTierId());
	    	amount.setSpendAmount(amountbean.getSpendAmount());
	    	amount.setMarkupType(amountbean.getMarkupType());
	    	amount.setIsAllowMultiple(amountbean.getIsAllowMultiple());
	    	amount.setEarnRule(earnRule);
	    	ListOfAmount.add(amount);
	    }
	    earnRule.setEarnRuleTransactionAmountDefs(ListOfAmount);
	    earnRule.setSkuFilePath(createBean.getSkuFilePath());
		earnRule.setStartDate(createBean.getStartDate());
		earnRule.setEndDate(createBean.getEndDate());
		earnRule.setIsPerpectual(createBean.getIsPerpectual());
		earnRule.setStartTime(createBean.getStartTime());
		earnRule.setEndTime(createBean.getEndTime());
		earnRule.setPointExpiryIn(createBean.getPointExpiryIn());
		earnRule.setStatus(createBean.getActionType());
		earnRule.setExpiryDate(createBean.getExpiryDate());
		earnRule.setExpiryDays(createBean.getExpiryDays());
		earnRule.setRuleImgPath(createBean.getRuleImgPath());
		earnRule.setActionType(createBean.getActionType());
		earnRule.setAction(createBean.getAction());
		earnRule.setMaxOverallAccrual(createBean.getMaxOverallAccrual());
		earnRule.setOverallLimitPerCustomer(createBean.getOverallLimitPerCustomer());
		earnRule.setDailyCustomerLimit(createBean.getDailyCustomerLimit());
		earnRule.setRewardType(createBean.getRewardType());
		
		
		Country country = countryRepo.findByCountryName(createBean.getCountryName());
		earnRule.setCountry(country);
		earnRule.setCountryName(createBean.getCountryName());
		
		earnRule.setMinimumOrderValue(createBean.getMinimumOrderValue());
		earnRule.setExcludeDeliveryCost(createBean.getExcludeDeliveryCost());
		earnRule.setExcludeTax(createBean.getExcludeTax());
		earnRule.setDisplayOnHomeScreen(createBean.getDisplayOnHomeScreen());
	    List<com.reciproci.loyalty.earnrule.entity.EarnRuleLocales> listOfLocales = new ArrayList<>();
		for(EarnRuleLocalesBean earnLocal : createBean.getEarnRuleLocales()) {
			com.reciproci.loyalty.earnrule.entity.EarnRuleLocales earnRuleLocales = new com.reciproci.loyalty.earnrule.entity.EarnRuleLocales();
			earnRuleLocales.setLanguageId(earnLocal.getLanguageId());
			earnRuleLocales.setButtonLabel(earnLocal.getButtonLabel());
			earnRuleLocales.setRuleName(earnLocal.getRuleName());
			earnRuleLocales.setTermsAndCondition(earnLocal.getTermsAndCondition());
			Language language = languageRepo.findById(earnLocal.getLanguageId())
			        .orElseThrow(() -> new RuntimeException("Language not found"));
			    if (earnRule.getLanguages() == null) {
			        earnRule.setLanguages(new ArrayList<>());
			    }
			earnRule.getLanguages().add(language);
			earnRuleLocales.setEarnRule(earnRule);
			listOfLocales.add(earnRuleLocales);
		}
		earnRule.setEarnRuleLocales(listOfLocales);
	    if (createBean.getStoreIds() != null) {
	        List<Store> storeList = storeRepo.findAllById(createBean.getStoreIds());
	        earnRule.setStores(storeList);
	    }
	    program.getEarnRules().add(earnRule);
	   
	    earnRuleRepo.save(earnRule);
	}
	public EarnViewBean view(EarnViewRequestBean createBean) {
	    // 1. Safe fetch for EarnRule
	    EarnRule earnRule = earnRuleRepo.findById(createBean.getEarnRuleId())
	            .orElseThrow(() -> new RuntimeException("Earn Rule not found for ID: " + createBean.getEarnRuleId()));

	    EarnViewBean earnViewBean = new EarnViewBean();
	    earnViewBean.setEarnRuleId(earnRule.getId());
	    earnViewBean.setProgramId(earnRule.getProgramId());
	    earnViewBean.setStartDate(earnRule.getStartDate());
	    earnViewBean.setEndDate(earnRule.getEndDate());
	    earnViewBean.setIsPerpectual(earnRule.getIsPerpectual());
	    earnViewBean.setSkuFilePath(earnRule.getSkuFilePath());
	    earnViewBean.setStartTime(earnRule.getStartTime());
	    earnViewBean.setEndTime(earnRule.getEndTime());
	    earnViewBean.setPointExpiryIn(earnRule.getPointExpiryIn());
	    earnViewBean.setExpiryDate(earnRule.getExpiryDate());
	    earnViewBean.setExpiryDays(earnRule.getExpiryDays());
	    earnViewBean.setStatus(earnRule.getStatus());
	    earnViewBean.setRuleImgPath(earnRule.getRuleImgPath());
	    earnViewBean.setActionType(earnRule.getActionType());
	    earnViewBean.setAction(earnRule.getAction());
	    earnViewBean.setMaxOverallAccrual(earnRule.getMaxOverallAccrual());
	    earnViewBean.setOverallLimitPerCustomer(earnRule.getOverallLimitPerCustomer());
	    earnViewBean.setDailyCustomerLimit(earnRule.getDailyCustomerLimit());
	    earnViewBean.setCountryName(earnRule.getCountryName());
	    earnViewBean.setMinimumOrderValue(earnRule.getMinimumOrderValue());
	    earnViewBean.setExcludeDeliveryCost(earnRule.getExcludeDeliveryCost());
	    earnViewBean.setExcludeTax(earnRule.getExcludeTax());
	    earnViewBean.setStores(earnRule.getStores());
	    earnViewBean.setRewarType(earnRule.getRewardType());
	    earnViewBean.setDisplayOnHomeScreen(earnRule.getDisplayOnHomeScreen());

	    // 2. Handle Locales Safely
	    List<EarnRuleLocalesBean> list = new ArrayList<>();
	    List<EarnRuleLocales> locales = earnRuleLocaleRepo.findByEarnRuleId(earnRule.getId());
	    for (EarnRuleLocales local : locales) {
	        EarnRuleLocalesBean earnRuleLocalesBean = new EarnRuleLocalesBean();
	        earnRuleLocalesBean.setLanguageId(local.getLanguageId());
	        
	        // Use orElse(null) or a default to prevent RuntimeException if language is missing
	        languageRepo.findById(local.getLanguageId()).ifPresent(language -> {
	            earnRuleLocalesBean.setLanguageName(language.getLanguageName());
	            earnRuleLocalesBean.setLanguageCode(language.getLanguageCode());
	            earnRuleLocalesBean.setLanguageDirection(language.getLanguageDirection());
	        });
	        
	        earnRuleLocalesBean.setRuleName(local.getRuleName());
	        earnRuleLocalesBean.setTermsAndCondition(local.getTermsAndCondition());
	        list.add(earnRuleLocalesBean);
	    }
	    earnViewBean.setEarnRuleLocalesBeans(list);

	    // 3. Handle Tier Grouping Safely (Fixed the specific crash point)
	    List<EarnRuleTransactionPointDefs> allDefs = earnRuleTransactionPoint.findByEarnRuleId(earnRule.getId());
	    Map<Long, List<EarnRuleTransactionPointDefs>> groupedByTier = allDefs.stream()
	            .collect(Collectors.groupingBy(EarnRuleTransactionPointDefs::getTierId));

	    List<EarnRulePointDefBean> listOF = groupedByTier.entrySet().stream()
	            .map(entry -> {
	                EarnRulePointDefBean bean = new EarnRulePointDefBean();
	                bean.setTierId(entry.getKey());
	                
	                // FIX: Use .orElse(null) or handle the empty case instead of .orElseThrow()
	                tierRepository.findById(entry.getKey()).ifPresentOrElse(
	                    tier -> bean.setTierName(tier.getTierName()),
	                    () -> bean.setTierName("Unknown Tier") 
	                );

	                List<TransactionPointDef> listOfPointDefs = entry.getValue().stream()
	                        .map(def -> {
	                            TransactionPointDef pointDef = new TransactionPointDef();
	                            pointDef.setMarkupType(def.getMarkupType());
	                            pointDef.setNoOfRewards(def.getNoOfRewards());
	                            return pointDef;
	                        })
	                        .collect(Collectors.toList());

	                bean.setTransactionPointDefs(listOfPointDefs);
	                return bean;
	            })
	            .collect(Collectors.toList());
	    earnViewBean.setEarnRuleTransactionPointDefs(listOF);

	    // 4. Handle Amount Definitions
	    List<EarnRuleTransactionAmountDefs> all = earnRuleTransactionAmount.findByEarnRuleId(earnRule.getId());
	    all.sort(Comparator.comparing(EarnRuleTransactionAmountDefs::getTierId));
	    
	    List<TierConfig> allTiers = tierRepository.findAllById(
	            all.stream().map(EarnRuleTransactionAmountDefs::getTierId).collect(Collectors.toList())
	    );

	    List<EarnRuleAmountDefBean> listOf = new ArrayList<>();
	    EarnRuleAmountDefBean currentBean = null;
	    Long lastTierId = null;
	    
	    // Fetch country once outside the loop for performance
	    Country country = countryRepo.findByCountryName(earnRule.getCountryName());

	    for (EarnRuleTransactionAmountDefs def : all) {
	        if (lastTierId == null || !lastTierId.equals(def.getTierId())) {
	            currentBean = new EarnRuleAmountDefBean();
	            currentBean.setTierId(def.getTierId());
	            currentBean.setTransactionAmountDefs(new ArrayList<>());

	            String tierName = allTiers.stream()
	                    .filter(t -> t.getId().equals(def.getTierId()))
	                    .findFirst()
	                    .map(TierConfig::getTierName)
	                    .orElse("Unknown Tier");

	            currentBean.setTierName(tierName);
	            listOf.add(currentBean);
	            lastTierId = def.getTierId();
	        }

	        TransactionAmountDefs amountDef = new TransactionAmountDefs();
	        amountDef.setSpendAmount(def.getSpendAmount());
	        amountDef.setAllowMultiple(def.getIsAllowMultiple());
	        
	        if (country != null) {
	            amountDef.setCountryId(country.getId());
	            amountDef.setCountryName(country.getCountryName());
	            amountDef.setCountryCode(country.getCountryCode());
	            amountDef.setCurrencyCode(country.getCurrencyCode());
	        }
	        
	        currentBean.getTransactionAmountDefs().add(amountDef);
	    }
	    earnViewBean.setEarnRuleTransactionAmountDefs(listOf);

	    return earnViewBean;
	}


	public List<GetDetailsBean> viewEarnRuleOnProgramId(Long programId) {
	    List<EarnRule> byProgramId = earnRuleRepo.findByProgramId(programId);
	    List<GetDetailsBean> arrayList = new ArrayList<>();
	    for(EarnRule earnRule : byProgramId) {
	    	List<EarnRuleLocales> byEarnRuleId = earnRuleLocaleRepo.findByEarnRuleId(earnRule.getId());
	    	for(EarnRuleLocales local:byEarnRuleId) {
	    		Language language = languageRepo.findById(local.getLanguageId()).orElseThrow();
	    		arrayList.add(mapToBean(earnRule,local,language));
	    	}
	    }
	    return arrayList;
	}
	private GetDetailsBean mapToBean(EarnRule earnRule, EarnRuleLocales local, Language language) {
	    GetDetailsBean bean = new GetDetailsBean();
	    bean.setProgramId(earnRule.getProgramId());
	    bean.setEarnRuleId(earnRule.getId());
	    bean.setRewardType(earnRule.getRewardType());
	    bean.setRuleName(local.getRuleName());
	    bean.setAction(earnRule.getAction());
	    bean.setActionType(earnRule.getActionType());
	    bean.setStartDate(earnRule.getStartDate());
	    bean.setEndDate(earnRule.getEndDate());
	    bean.setCountryName(earnRule.getCountryName());
	    bean.setStatus(earnRule.getStatus());
	    bean.setRewardType(earnRule.getRewardType());
	    bean.setMaxOverallAccrual(earnRule.getMaxOverallAccrual());
	    bean.setOverallLimitCustomer(earnRule.getOverallLimitPerCustomer());
	    bean.setDailylLimitCustomer(earnRule.getDailyCustomerLimit());
	    if (language != null) {
	        bean.setLanguageName(language.getLanguageName());
	        bean.setLanguageDirection(language.getLanguageDirection());
	    }
	    return bean;
	}
	
	
	public void update(CreateEarnBean bean) {
	    EarnRule existing = earnRuleRepo.findById(bean.getEarnRuleId())
	            .orElseThrow(() -> new RuntimeException("Rule not found with ID: " + bean.getEarnRuleId()));
	   
	    Program program = programRepo.findById(bean.getProgramId())
	            .orElseThrow(() -> new RuntimeException("Program not found"));
	    existing.setProgramId(bean.getProgramId());
	    existing.setSkuFilePath(bean.getSkuFilePath());
	    existing.setStartDate(bean.getStartDate());
	    existing.setEndDate(bean.getEndDate());
	    existing.setIsPerpectual(bean.getIsPerpectual());
	    existing.setStartTime(bean.getStartTime());
	    existing.setEndTime(bean.getEndTime());
	    existing.setPointExpiryIn(bean.getPointExpiryIn());
	    existing.setExpiryDate(bean.getExpiryDate());
	    existing.setExpiryDays(bean.getExpiryDays());
	    existing.setStatus(bean.getStatus());
	    existing.setRuleImgPath(bean.getRuleImgPath());
	    existing.setActionType(bean.getActionType());
	    existing.setAction(bean.getAction());
	    existing.setRewardType(bean.getRewardType());
	    existing.setMaxOverallAccrual(bean.getMaxOverallAccrual());
	    existing.setOverallLimitPerCustomer(bean.getOverallLimitPerCustomer());
	    existing.setDailyCustomerLimit(bean.getDailyCustomerLimit());
	    existing.setMinimumOrderValue(bean.getMinimumOrderValue());
	    existing.setExcludeDeliveryCost(bean.getExcludeDeliveryCost());
	    existing.setExcludeTax(bean.getExcludeTax());
	    existing.setDisplayOnHomeScreen(bean.getDisplayOnHomeScreen());
	    Country country = countryRepo.findByCountryName(bean.getCountryName());
	    existing.setCountry(country);
	    existing.setCountryName(bean.getCountryName());
	    List<Store> stores = storeRepo.findAllById(bean.getStoreIds());
	    existing.setStores(new ArrayList<>(stores));
	    if (bean.getEarnRuleLocales() != null) {
	        // 1. Create a Map of existing locales for quick lookup by Language ID (or PK ID)
	        Map<Long, EarnRuleLocales> existingLocalesMap = existing.getEarnRuleLocales().stream()
	                .collect(Collectors.toMap(EarnRuleLocales::getLanguageId, l -> l));
	        List<EarnRuleLocales> updatedLocales = new ArrayList<>();
	        existing.getLanguages().clear(); // If you want to refresh the language list
	        for (EarnRuleLocalesBean localeBean : bean.getEarnRuleLocales()) {
	            // 2. Check if we already have this locale
	            EarnRuleLocales locale = existingLocalesMap.get(localeBean.getLanguageId());
	           
	            if (locale == null) {
	                // It's new
	                locale = new EarnRuleLocales();
	                locale.setEarnRule(existing);
	            }
	            // 3. Update fields
	            locale.setLanguageId(localeBean.getLanguageId());
	            locale.setButtonLabel(localeBean.getButtonLabel());
	            locale.setRuleName(localeBean.getRuleName());
	            locale.setTermsAndCondition(localeBean.getTermsAndCondition());
	           
	            updatedLocales.add(locale);
	            // Handle Language association
	            Language language = languageRepo.findById(localeBean.getLanguageId())
	                    .orElseThrow(() -> new RuntimeException("Language not found"));
	            existing.getLanguages().add(language);
	        }
	        // 4. Update the collection (Orphan removal will handle deletions if configured)
	        existing.getEarnRuleLocales().clear();
	        existing.getEarnRuleLocales().addAll(updatedLocales);
	    }
	    if (bean.getEarnRuleTransactionPointDefs() != null) {
	        // Map existing records by Tier ID for lookup
	        Map<Long, EarnRuleTransactionPointDefs> existingPointsMap = existing.getEarnRuleTransactionPointDefs()
	                .stream()
	                .collect(Collectors.toMap(EarnRuleTransactionPointDefs::getTierId, p -> p, (p1, p2) -> p1));
	        List<EarnRuleTransactionPointDefs> updatedPointsList = new ArrayList<>();
	        for (earnRuleTransactionPointDefsBean pointsBean : bean.getEarnRuleTransactionPointDefs()) {
	            // Find existing or create new
	            EarnRuleTransactionPointDefs point = existingPointsMap.get(pointsBean.getTierId());
	           
	            if (point == null) {
	                point = new EarnRuleTransactionPointDefs();
	                point.setEarnRule(existing);
	            }
	            // Update fields
	            point.setMarkupType(pointsBean.getMarkupType());
	            point.setTierId(pointsBean.getTierId());
	            point.setNoOfRewards(pointsBean.getNoOfRewards());
	           
	            updatedPointsList.add(point);
	        }
	        // Refresh the collection
	        existing.getEarnRuleTransactionPointDefs().clear();
	        existing.getEarnRuleTransactionPointDefs().addAll(updatedPointsList);
	    }
	    if (bean.getEarnRuleTransactionAmountDefs() != null) {
	        // Map existing records by Tier ID
	        Map<Long, EarnRuleTransactionAmountDefs> existingAmountMap = existing.getEarnRuleTransactionAmountDefs()
	                .stream()
	                .collect(Collectors.toMap(EarnRuleTransactionAmountDefs::getTierId, a -> a, (a1, a2) -> a1));
	        List<EarnRuleTransactionAmountDefs> updatedAmountList = new ArrayList<>();
	        for (earnRuleTransactionAmountDefsBean amountBean : bean.getEarnRuleTransactionAmountDefs()) {
	            // Find existing or create new
	            EarnRuleTransactionAmountDefs amount = existingAmountMap.get(amountBean.getTierId());
	            if (amount == null) {
	                amount = new EarnRuleTransactionAmountDefs();
	                amount.setEarnRule(existing);
	            }
	            // Update fields
	            amount.setTierId(amountBean.getTierId());
	            amount.setSpendAmount(amountBean.getSpendAmount());
	            amount.setMarkupType(amountBean.getMarkupType());
	            amount.setIsAllowMultiple(amountBean.getIsAllowMultiple());
	            updatedAmountList.add(amount);
	        }
	        // Refresh the collection
	        existing.getEarnRuleTransactionAmountDefs().clear();
	        existing.getEarnRuleTransactionAmountDefs().addAll(updatedAmountList);
	    }
	    earnRuleRepo.save(existing);
	}
}
	

