package com.reciproci.loyalty.tier.model;

public class TierBean {
	
	private Long tierId;
	private String tierName;
	private String tierImage;
	private Double minAmount;
	private Double maxAmount;
	private Integer tierLevel;


	public Long getTierId() {
		return tierId;
	}

	public void setTierId(Long tierId) {
		this.tierId = tierId;
	}

	public String getTierName() {
		return tierName;
	}

	public String getTierImage() {
		return tierImage;
	}

	public Double getMinAmount() {
		return minAmount;
	}

	public Double getMaxAmount() {
		return maxAmount;
	}

	public Integer getTierLevel() {
		return tierLevel;
	}

	public void setTierName(String tierName) {
		this.tierName = tierName;
	}

	public void setTierImage(String tierImage) {
		this.tierImage = tierImage;
	}

	public void setMinAmount(Double minAmount) {
		this.minAmount = minAmount;
	}

	public void setMaxAmount(Double maxAmount) {
		this.maxAmount = maxAmount;
	}

	public void setTierLevel(Integer tierLevel) {
		this.tierLevel = tierLevel;
	}

}
