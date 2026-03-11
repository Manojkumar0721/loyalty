package com.reciproci.loyalty.tier.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tier_configs")
public class TierConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tierName;
	private String tierImage;
	private Double minAmount;
	private Double maxAmount;
	private Integer tierLevel;

	@ManyToOne
	@JoinColumn(name = "tier_region_id")
	private TierRegion tierRegion;

	public Long getId() {
		return id;
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

	public TierRegion getTierRegion() {
		return tierRegion;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setTierRegion(TierRegion tierRegion) {
		this.tierRegion = tierRegion;
	}

}
