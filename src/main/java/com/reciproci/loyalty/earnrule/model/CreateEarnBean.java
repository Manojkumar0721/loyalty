package com.reciproci.loyalty.earnrule.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CreateEarnBean {

	private Long earnRuleId;

	private Long programId;
	private Long languageId;
	private String rewardType;
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
	private List<Long> storeIds;
	private List<earnRuleTransactionPointDefsBean> earnRuleTransactionPointDefs;
	private List<earnRuleTransactionAmountDefsBean> earnRuleTransactionAmountDefs;
	private List<EarnRuleLocalesBean> earnRuleLocales;

	public String getSkuFilePath() {
		return skuFilePath;
	}

	public void setSkuFilePath(String skuFilePath) {
		this.skuFilePath = skuFilePath;
	}

	public List<EarnRuleLocalesBean> getEarnRuleLocales() {
		return earnRuleLocales;
	}

	public void setEarnRuleLocales(List<EarnRuleLocalesBean> earnRuleLocales) {
		this.earnRuleLocales = earnRuleLocales;
	}

	public List<earnRuleTransactionPointDefsBean> getEarnRuleTransactionPointDefs() {
		return earnRuleTransactionPointDefs;
	}

	public void setEarnRuleTransactionPointDefs(List<earnRuleTransactionPointDefsBean> earnRuleTransactionPointDefs) {
		this.earnRuleTransactionPointDefs = earnRuleTransactionPointDefs;
	}

	public List<earnRuleTransactionAmountDefsBean> getEarnRuleTransactionAmountDefs() {
		return earnRuleTransactionAmountDefs;
	}

	public void setEarnRuleTransactionAmountDefs(List<earnRuleTransactionAmountDefsBean> earnRuleTransactionAmountDefs) {
		this.earnRuleTransactionAmountDefs = earnRuleTransactionAmountDefs;
	}

	public String getRewardType() {
		return rewardType;
	}

	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
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

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public Long getId() {
		return earnRuleId;
	}

	public void setId(Long earnRuleId) {
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

	public List<Long> getStoreIds() {
		return storeIds;
	}

	public void setStoreIds(List<Long> storeIds) {
		this.storeIds = storeIds;
	}

}


