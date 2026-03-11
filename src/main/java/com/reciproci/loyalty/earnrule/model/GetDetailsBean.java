package com.reciproci.loyalty.earnrule.model;
import java.time.LocalDate;
public class GetDetailsBean {
	private Long earnRuleId;
	private Long programId;
	private String ruleName;
	private String rewardType;
	private String actionType;
	private String action;
	private LocalDate startDate;
	private LocalDate endDate;
	private String countryName;
	private String languageName;
	private String languageDirection;
	private String status;
	private Integer maxOverallAccrual;
	private Integer overallLimitCustomer;
	private Integer dailylLimitCustomer;
	public Long getEarnRuleId() {
		return earnRuleId;
	}
	public void setEarnRuleId(Long earnRuleId) {
		this.earnRuleId = earnRuleId;
	}
	public Long getProgramId() {
		return programId;
	}
	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getRewardType() {
		return rewardType;
	}
	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getLanguageDirection() {
		return languageDirection;
	}
	public void setLanguageDirection(String languageDirection) {
		this.languageDirection = languageDirection;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getMaxOverallAccrual() {
		return maxOverallAccrual;
	}
	public void setMaxOverallAccrual(Integer maxOverallAccrual) {
		this.maxOverallAccrual = maxOverallAccrual;
	}
	public Integer getOverallLimitCustomer() {
		return overallLimitCustomer;
	}
	public void setOverallLimitCustomer(Integer overallLimitCustomer) {
		this.overallLimitCustomer = overallLimitCustomer;
	}
	public Integer getDailylLimitCustomer() {
		return dailylLimitCustomer;
	}
	public void setDailylLimitCustomer(Integer dailylLimitCustomer) {
		this.dailylLimitCustomer = dailylLimitCustomer;
	}
	
	
}



