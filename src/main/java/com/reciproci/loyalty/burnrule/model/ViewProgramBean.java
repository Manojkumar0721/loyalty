package com.reciproci.loyalty.burnrule.model;

public class ViewProgramBean {

	private Long burnRuleId;
	private String ruleName;
	private String rewardType;
	private String redeemType;
	private String redeemQty;
	private String startDate;
	private String endDate;

	public Long getBurnRuleId() {
		return burnRuleId;
	}

	public String getRuleName() {
		return ruleName;
	}

	public String getRewardType() {
		return rewardType;
	}

	public String getRedeemType() {
		return redeemType;
	}

	public String getRedeemQty() {
		return redeemQty;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setBurnRuleId(Long burnRuleId) {
		this.burnRuleId = burnRuleId;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	public void setRedeemType(String redeemType) {
		this.redeemType = redeemType;
	}

	public void setRedeemQty(String redeemQty) {
		this.redeemQty = redeemQty;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
