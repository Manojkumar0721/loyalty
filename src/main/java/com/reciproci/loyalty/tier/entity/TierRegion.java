package com.reciproci.loyalty.tier.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.reciproci.loyalty.earnrule.entity.Country;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tier_regions")
public class TierRegion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	private Integer tierEngagementDays;

	@OneToMany(mappedBy = "tierRegion", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TierConfig> tierList;

	private LocalDateTime createdTime;
	private LocalDateTime modifiedTime;

	public Long getId() {
		return id;
	}

	public Country getCountry() {
		return country;
	}

	public Integer getTierEngagementDays() {
		return tierEngagementDays;
	}

	public List<TierConfig> getTierList() {
		return tierList;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public void setCountry(Country country) {
		this.country = country;
	}


	public void setTierEngagementDays(Integer tierEngagementDays) {
		this.tierEngagementDays = tierEngagementDays;
	}

	public void setTierList(List<TierConfig> tierList) {
		this.tierList = tierList;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}



}
