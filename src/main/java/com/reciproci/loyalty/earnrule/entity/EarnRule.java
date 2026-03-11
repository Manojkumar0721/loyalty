package com.reciproci.loyalty.earnrule.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.reciproci.loyalty.program.entity.Program;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "EARNRULE")
public class EarnRule {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "program_id", insertable = false, updatable = false)
    private Long programId;
    private String rewardType;
    private Boolean displayOnHomeScreen;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isPerpectual;
    private LocalTime startTime;
    private LocalTime endTime;
    private String pointExpiryIn;
    private String status; 
    private String expiryDate;
    private Integer expiryDays;
    private String ruleImgPath;
    private String actionType;
    private String action;
    private Integer maxOverallAccrual;
    private Integer overallLimitPerCustomer;
    private Integer dailyCustomerLimit;
    private String countryName;
    private Double minimumOrderValue;
    private Boolean excludeDeliveryCost;
    private Boolean excludeTax;
    private String skuFilePath;
    
    @ManyToMany
    @JoinTable(
        name = "earn_rule_languages",
        joinColumns = @JoinColumn(name = "earn_rule_id"),
        inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages;


    @ManyToMany
    @JoinTable(
        name = "earn_rule_stores",
        joinColumns = @JoinColumn(name = "earn_rule_id"),
        inverseJoinColumns = @JoinColumn(name = "store_id")
    )
    private List<Store> stores;
    
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    
    @ManyToOne
    @JoinColumn(name = "program_id")
    @JsonBackReference
    private Program program;
    
    @OneToMany(mappedBy = "earnRule",cascade = CascadeType.ALL)
    private List<EarnRuleTransactionAmountDefs> earnRuleTransactionAmountDefs;
    
    @OneToMany(mappedBy = "earnRule",cascade = CascadeType.ALL)
    private List<EarnRuleTransactionPointDefs> earnRuleTransactionPointDefs;
    
    @OneToMany(mappedBy = "earnRule", cascade = CascadeType.ALL)
    private List<EarnRuleLocales> earnRuleLocales;
    
    
	public String getSkuFilePath() {
		return skuFilePath;
	}


	public void setSkuFilePath(String skuFilePath) {
		this.skuFilePath = skuFilePath;
	}


	public List<EarnRuleLocales> getEarnRuleLocales() {
		return earnRuleLocales;
	}


	public void setEarnRuleLocales(List<EarnRuleLocales> earnRuleLocales) {
		this.earnRuleLocales = earnRuleLocales;
	}




	public List<EarnRuleTransactionPointDefs> getEarnRuleTransactionPointDefs() {
		return earnRuleTransactionPointDefs;
	}


	public void setEarnRuleTransactionPointDefs(List<EarnRuleTransactionPointDefs> earnRuleTransactionPointDefs) {
		this.earnRuleTransactionPointDefs = earnRuleTransactionPointDefs;
	}


	public List<EarnRuleTransactionAmountDefs> getEarnRuleTransactionAmountDefs() {
		return earnRuleTransactionAmountDefs;
	}


	public void setEarnRuleTransactionAmountDefs(List<EarnRuleTransactionAmountDefs> earnRuleTransactionAmountDefs) {
		this.earnRuleTransactionAmountDefs = earnRuleTransactionAmountDefs;
	}


	public List<Language> getLanguages() {
		return languages;
	}


	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}


	public String getRewardType() {
		return rewardType;
	}


	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}




	public Boolean getDisplayOnHomeScreen() {
		return displayOnHomeScreen;
	}


	public void setDisplayOnHomeScreen(Boolean displayOnHomeScreen) {
		this.displayOnHomeScreen = displayOnHomeScreen;
	}


	public List<Store> getStores() {
		return stores;
	}


	public void setStores(List<Store> stores) {
		this.stores = stores;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getProgramId() {
		return programId;
	}


	public void setProgramId(Long programId) {
		this.programId = programId;
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


	public Boolean getIsPerpectual() {
		return isPerpectual;
	}


	public void setIsPerpectual(Boolean isPerpectual) {
		this.isPerpectual = isPerpectual;
	}


	public LocalTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}


	public LocalTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}


	public String getPointExpiryIn() {
		return pointExpiryIn;
	}


	public void setPointExpiryIn(String pointExpiryIn) {
		this.pointExpiryIn = pointExpiryIn;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	public Integer getExpiryDays() {
		return expiryDays;
	}


	public void setExpiryDays(Integer expiryDays) {
		this.expiryDays = expiryDays;
	}


	public String getRuleImgPath() {
		return ruleImgPath;
	}


	public void setRuleImgPath(String ruleImgPath) {
		this.ruleImgPath = ruleImgPath;
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


	public Integer getMaxOverallAccrual() {
		return maxOverallAccrual;
	}


	public void setMaxOverallAccrual(Integer maxOverallAccrual) {
		this.maxOverallAccrual = maxOverallAccrual;
	}


	public Integer getOverallLimitPerCustomer() {
		return overallLimitPerCustomer;
	}


	public void setOverallLimitPerCustomer(Integer overallLimitPerCustomer) {
		this.overallLimitPerCustomer = overallLimitPerCustomer;
	}


	public Integer getDailyCustomerLimit() {
		return dailyCustomerLimit;
	}


	public void setDailyCustomerLimit(Integer dailyCustomerLimit) {
		this.dailyCustomerLimit = dailyCustomerLimit;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public Double getMinimumOrderValue() {
		return minimumOrderValue;
	}


	public void setMinimumOrderValue(Double minimumOrderValue) {
		this.minimumOrderValue = minimumOrderValue;
	}


	public Boolean getExcludeDeliveryCost() {
		return excludeDeliveryCost;
	}


	public void setExcludeDeliveryCost(Boolean excludeDeliveryCost) {
		this.excludeDeliveryCost = excludeDeliveryCost;
	}


	public Boolean getExcludeTax() {
		return excludeTax;
	}


	public void setExcludeTax(Boolean excludeTax) {
		this.excludeTax = excludeTax;
	}


	public Program getProgram() {
		return program;
	}


	public void setProgram(Program program) {
		this.program = program;
	}
    
    


}



