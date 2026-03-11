package com.reciproci.loyalty.burnrule.model;

import java.util.List;

import com.reciproci.loyalty.earnrule.entity.Store;

public class ViewBean {

	private Long burnRuleId;
	private Long programId;
	private String ruleImagePath;
	private String rewardType;
	private String rewardQty;
	private String rewardImagePath;
	private String skuFilePath;
	private List<Store> storeList;
	private List<RuleLocalBean> ruleLocalList;
	private Integer minimumPoints;
	private String freeProductType;
	private boolean excludeSku;
	private boolean excludeStore;
	private boolean isDisplayHomeScreen;
	private boolean isExclusive;
	private List<RewardValueBean> rewardValues;



	public List<RewardValueBean> getRewardValues() {
		return rewardValues;
	}

	public void setRewardValues(List<RewardValueBean> rewardValues) {
		this.rewardValues = rewardValues;
	}

	public Long getBurnRuleId() {
		return burnRuleId;
	}

	public Long getProgramId() {
		return programId;
	}

	public String getRuleImagePath() {
		return ruleImagePath;
	}

	public String getRewardType() {
		return rewardType;
	}

	public String getRewardQty() {
		return rewardQty;
	}

	public String getRewardImagePath() {
		return rewardImagePath;
	}

	public String getSkuFilePath() {
		return skuFilePath;
	}

	public List<Store> getStoreList() {
		return storeList;
	}

	public List<RuleLocalBean> getRuleLocalList() {
		return ruleLocalList;
	}

	public Integer getMinimumPoints() {
		return minimumPoints;
	}

	public String getFreeProductType() {
		return freeProductType;
	}

	public boolean isExcludeSku() {
		return excludeSku;
	}

	public boolean isExcludeStore() {
		return excludeStore;
	}

	public boolean isDisplayHomeScreen() {
		return isDisplayHomeScreen;
	}

	public boolean isExclusive() {
		return isExclusive;
	}

	public void setBurnRuleId(Long burnRuleId) {
		this.burnRuleId = burnRuleId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	public void setRuleImagePath(String ruleImagePath) {
		this.ruleImagePath = ruleImagePath;
	}

	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	public void setRewardQty(String rewardQty) {
		this.rewardQty = rewardQty;
	}

	public void setRewardImagePath(String rewardImagePath) {
		this.rewardImagePath = rewardImagePath;
	}

	public void setSkuFilePath(String skuFilePath) {
		this.skuFilePath = skuFilePath;
	}

	public void setStoreList(List<Store> storeList) {
		this.storeList = storeList;
	}

	public void setRuleLocalList(List<RuleLocalBean> ruleLocalList) {
		this.ruleLocalList = ruleLocalList;
	}

	public void setMinimumPoints(Integer minimumPoints) {
		this.minimumPoints = minimumPoints;
	}

	public void setFreeProductType(String freeProductType) {
		this.freeProductType = freeProductType;
	}

	public void setExcludeSku(boolean excludeSku) {
		this.excludeSku = excludeSku;
	}

	public void setExcludeStore(boolean excludeStore) {
		this.excludeStore = excludeStore;
	}

	public void setDisplayHomeScreen(boolean isDisplayHomeScreen) {
		this.isDisplayHomeScreen = isDisplayHomeScreen;
	}

	public void setExclusive(boolean isExclusive) {
		this.isExclusive = isExclusive;
	}

}
