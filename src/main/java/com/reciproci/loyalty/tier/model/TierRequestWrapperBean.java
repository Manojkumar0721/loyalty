package com.reciproci.loyalty.tier.model;

import java.util.List;

public class TierRequestWrapperBean {

	private List<TierRegionBean> tierRegionList;
	private String timestamp;

	public List<TierRegionBean> getTierRegionList() {
		return tierRegionList;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTierRegionList(List<TierRegionBean> tierRegionList) {
		this.tierRegionList = tierRegionList;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
