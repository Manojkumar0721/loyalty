package com.reciproci.loyalty.burnrule.model;

import java.math.BigDecimal;

public class RewardValueBean {
	
	private Long regionId;
	private Long tierid;
	private BigDecimal rewardValue;
	public Long getRegionId() {
		return regionId;
	}
	public Long getTierid() {
		return tierid;
	}
	public BigDecimal getRewardValue() {
		return rewardValue;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	public void setTierid(Long tierid) {
		this.tierid = tierid;
	}
	public void setRewardValue(BigDecimal rewardValue) {
		this.rewardValue = rewardValue;
	}

}
