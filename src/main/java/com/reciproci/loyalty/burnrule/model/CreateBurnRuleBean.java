package com.reciproci.loyalty.burnrule.model;

import java.util.List;

import com.reciproci.loyalty.burnrule.entity.BurnRuleLocale;
import com.reciproci.loyalty.burnrule.entity.RewardValue;
import com.reciproci.loyalty.program.entity.Program;

public class CreateBurnRuleBean {

	private Long programId;
	private Long languageId;
	private String rewardType;
	private String rewardImagePath;
	private String rewardQty;
	private String startDate;
	private String endDate;
	private String ruleImagepath;
	private boolean isDisplayHomeScreen;
	private boolean isExclusive;
	private String skuFilePath;
	private Integer minimumPoints;
	private boolean isExcludeStore;
	private boolean isExcludeSku;
	private List<BurnRuleLocale> ruleLocales;
	private Program program;
	private List<Long> store;
	private String freeProductType;
	
	private List<RewardValue> rewardValues;

	public List<RewardValue> getRewardValues() {
		return rewardValues;
	}

	public void setRewardValues(List<RewardValue> rewardValues) {
		this.rewardValues = rewardValues;
	}

	public String getFreeProductType() {
		return freeProductType;
	}

	public void setFreeProductType(String freeProductType) {
		this.freeProductType = freeProductType;
	}

	public Long getProgramId() {
		return programId;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public String getRewardType() {
		return rewardType;
	}

	public String getRewardImagePath() {
		return rewardImagePath;
	}

	public String getRewardQty() {
		return rewardQty;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getRuleImagepath() {
		return ruleImagepath;
	}
	
	public boolean isDisplayHomeScreen() {
		return isDisplayHomeScreen;
	}

	public boolean isExclusive() {
		return isExclusive;
	}

	public String getSkuFilePath() {
		return skuFilePath;
	}

	public Integer getMinimumPoints() {
		return minimumPoints;
	}

	public boolean isExcludeStore() {
		return isExcludeStore;
	}

	public boolean isExcludeSku() {
		return isExcludeSku;
	}

	public List<BurnRuleLocale> getRuleLocales() {
		return ruleLocales;
	}

	public Program getProgram() {
		return program;
	}

	public List<Long> getStore() {
		return store;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	public void setRewardImagePath(String rewardImagePath) {
		this.rewardImagePath = rewardImagePath;
	}

	public void setRewardQty(String rewardQty) {
		this.rewardQty = rewardQty;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setRuleImagepath(String ruleImagepath) {
		this.ruleImagepath = ruleImagepath;
	}


	public void setDisplayHomeScreen(boolean isDisplayHomeScreen) {
		this.isDisplayHomeScreen = isDisplayHomeScreen;
	}

	public void setExclusive(boolean isExclusive) {
		this.isExclusive = isExclusive;
	}

	public void setSkuFilePath(String skuFilePath) {
		this.skuFilePath = skuFilePath;
	}

	public void setMinimumPoints(Integer minimumPoints) {
		this.minimumPoints = minimumPoints;
	}

	public void setExcludeStore(boolean isExcludeStore) {
		this.isExcludeStore = isExcludeStore;
	}

	public void setExcludeSku(boolean isExcludeSku) {
		this.isExcludeSku = isExcludeSku;
	}

	public void setRuleLocales(List<BurnRuleLocale> ruleLocales) {
		this.ruleLocales = ruleLocales;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public void setStore(List<Long> store) {
		this.store = store;
	}

}
