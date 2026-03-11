package com.reciproci.loyalty.tier.model;

import java.util.List;

public class TierRegionBean {
	
	private Long regionId;
    private Long countryId;
    private Integer tierEngagementDays;
    private List<TierBean> tierList;
    private String countryName;

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public Long getCountryId() {
		return countryId;
	}


	public Integer getTierEngagementDays() {
		return tierEngagementDays;
	}

	public List<TierBean> getTierList() {
		return tierList;
	}


	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}


	public void setTierEngagementDays(Integer tierEngagementDays) {
		this.tierEngagementDays = tierEngagementDays;
	}

	public void setTierList(List<TierBean> tierList) {
		this.tierList = tierList;
	}


}
