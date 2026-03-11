package com.reciproci.loyalty.burnrule.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rewardValues")
public class RewardValue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long regionId;
	private Long tierId;
	private BigDecimal rewardValue;
	
	@ManyToOne
	@JoinColumn(name = "burnRule_id")
	private BurnRule burnRule;

	public BurnRule getBurnRule() {
		return burnRule;
	}

	public void setBurnRule(BurnRule burnRule) {
		this.burnRule = burnRule;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRegionId() {
		return regionId;
	}

	public Long getTierId() {
		return tierId;
	}

	public BigDecimal getRewardValue() {
		return rewardValue;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public void setTierId(Long tierId) {
		this.tierId = tierId;
	}

	public void setRewardValue(BigDecimal rewardValue) {
		this.rewardValue = rewardValue;
	}

}
