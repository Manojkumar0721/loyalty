package com.reciproci.loyalty.earnrule.model;
public class TransactionAmountDefs {
	private Double spendAmount;
	private Long countryId;
	private String countryName;
	private String countryCode;
	private String currencyCode;
	private Boolean allowMultiple;
	
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public Double getSpendAmount() {
		return spendAmount;
	}
	public void setSpendAmount(Double spendAmount) {
		this.spendAmount = spendAmount;
	}
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Boolean getAllowMultiple() {
		return allowMultiple;
	}
	public void setAllowMultiple(Boolean allowMultiple) {
		this.allowMultiple = allowMultiple;
	}
	
	
}



