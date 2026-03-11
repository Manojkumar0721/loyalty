package com.reciproci.loyalty.earnrule.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.reciproci.loyalty.earnrule.entity.Store;

public class EarnViewBean {
	private Long earnRuleId;


    private Long programId;
    private String rewarType;
    private Boolean displayOnHomeScreen;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isPerpectual;
    private LocalTime startTime;
    private LocalTime endTime;
    private String pointExpiryIn;
    private String status; 
    private String expiryDate;
    private Integer expiryDays;
    private String ruleImgPath;
    private String actionType;
    private String action;
    private Integer maxOverallAccrual;
    private Integer overallLimitPerCustomer;
    private Integer dailyCustomerLimit;
    private String countryName;
    private Double minimumOrderValue;
    private Boolean excludeDeliveryCost;
    private Boolean excludeTax;
    private String skuFilePath;
    private List<Store> stores;
    private List<EarnRuleLocalesBean> earnRuleLocalesBeans;
    private List<EarnRuleAmountDefBean> earnRuleTransactionAmountDefs;
    private List<EarnRulePointDefBean> earnRuleTransactionPointDefs;
    
	public List<EarnRulePointDefBean> getEarnRuleTransactionPointDefs() {
		return earnRuleTransactionPointDefs;
	}
	public void setEarnRuleTransactionPointDefs(List<EarnRulePointDefBean> earnRuleTransactionPointDefs2) {
		this.earnRuleTransactionPointDefs = earnRuleTransactionPointDefs2;
	}
	public List<EarnRuleAmountDefBean> getEarnRuleTransactionAmountDefs() {
		return earnRuleTransactionAmountDefs;
	}
	public void setEarnRuleTransactionAmountDefs(List<EarnRuleAmountDefBean> earnRuleTransactionAmountDefs) {
		this.earnRuleTransactionAmountDefs = earnRuleTransactionAmountDefs;
	}
	public String getSkuFilePath() {
		return skuFilePath;
	}
	public void setSkuFilePath(String skuFilePath) {
		this.skuFilePath = skuFilePath;
	}
	
	public List<EarnRuleLocalesBean> getEarnRuleLocalesBeans() {
		return earnRuleLocalesBeans;
	}
	public void setEarnRuleLocalesBeans(List<EarnRuleLocalesBean> earnRuleLocalesBeans) {
		this.earnRuleLocalesBeans = earnRuleLocalesBeans;
	}
	public String getRewarType() {
		return rewarType;
	}
	public void setRewarType(String rewarType) {
		this.rewarType = rewarType;
	}
	public Boolean getDisplayOnHomeScreen() {
		return displayOnHomeScreen;
	}
	public void setDisplayOnHomeScreen(Boolean displayOnHomeScreen) {
		this.displayOnHomeScreen = displayOnHomeScreen;
	}
	public Long getEarnRuleId() {
		return earnRuleId;
	}
	public void setEarnRuleId(Long earnRuleId) {
		this.earnRuleId = earnRuleId;
	}
	public Long getProgramId() {
		return programId;
	}
	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Boolean getIsPerpectual() {
		return isPerpectual;
	}
	public void setIsPerpectual(Boolean isPerpectual) {
		this.isPerpectual = isPerpectual;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public String getPointExpiryIn() {
		return pointExpiryIn;
	}
	public void setPointExpiryIn(String pointExpiryIn) {
		this.pointExpiryIn = pointExpiryIn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Integer getExpiryDays() {
		return expiryDays;
	}
	public void setExpiryDays(Integer expiryDays) {
		this.expiryDays = expiryDays;
	}
	public String getRuleImgPath() {
		return ruleImgPath;
	}
	public void setRuleImgPath(String ruleImgPath) {
		this.ruleImgPath = ruleImgPath;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getMaxOverallAccrual() {
		return maxOverallAccrual;
	}
	public void setMaxOverallAccrual(Integer maxOverallAccrual) {
		this.maxOverallAccrual = maxOverallAccrual;
	}
	public Integer getOverallLimitPerCustomer() {
		return overallLimitPerCustomer;
	}
	public void setOverallLimitPerCustomer(Integer overallLimitPerCustomer) {
		this.overallLimitPerCustomer = overallLimitPerCustomer;
	}
	public Integer getDailyCustomerLimit() {
		return dailyCustomerLimit;
	}
	public void setDailyCustomerLimit(Integer dailyCustomerLimit) {
		this.dailyCustomerLimit = dailyCustomerLimit;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Double getMinimumOrderValue() {
		return minimumOrderValue;
	}
	public void setMinimumOrderValue(Double minimumOrderValue) {
		this.minimumOrderValue = minimumOrderValue;
	}
	public Boolean getExcludeDeliveryCost() {
		return excludeDeliveryCost;
	}
	public void setExcludeDeliveryCost(Boolean excludeDeliveryCost) {
		this.excludeDeliveryCost = excludeDeliveryCost;
	}
	public Boolean getExcludeTax() {
		return excludeTax;
	}
	public void setExcludeTax(Boolean excludeTax) {
		this.excludeTax = excludeTax;
	}
	public List<Store> getStores() {
		return stores;
	}
	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
    
} 





