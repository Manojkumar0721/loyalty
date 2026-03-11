package com.reciproci.loyalty.burnrule.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.reciproci.loyalty.earnrule.entity.Language;
import com.reciproci.loyalty.earnrule.entity.Store;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BURNRULE")
public class BurnRule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "program_id", insertable = false, updatable = false)
	private Long programId;
	private String rewardType;
	private String rewardImagePath;
	private String rewardQty;
	private String startDate;
	private String endDate;
	private String ruleImagepath;
	private boolean isDisplayHomeScreen;
	private boolean isExclusive;
	private String skuFilePath;
	private Integer minimumPoints;
	private boolean isExcludeStore;
	private boolean isExcludeSku;
	private String freeProductType;
	
	@OneToMany(mappedBy = "burnRule", cascade = CascadeType.ALL)
	private List<RewardValue> rewardValues;
	
	@OneToMany(mappedBy = "burnRule", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BurnRuleLocale> ruleLocaleList;

	
	@OneToOne
	@JoinColumn(name = "program_id", unique = true)
	@JsonBackReference
	private Program program;
	
	@ManyToMany
	@JoinTable(
			name = "burn_rule_store",
			joinColumns = @JoinColumn(name = "burn_rule_id"),
			inverseJoinColumns = @JoinColumn(name = "store_id"))
	private List<Store> store;
	
	@ManyToMany
	@JoinTable(
			name = "burn_rule_language",
			joinColumns = @JoinColumn(name = "burn_rule_id"),
			inverseJoinColumns = @JoinColumn(name = "language_id"))
	private List<Language> language;



	public List<RewardValue> getRewardValues() {
		return rewardValues;
	}

	public void setRewardValues(List<RewardValue> rewardValues) {
		this.rewardValues = rewardValues;
	}

	public String getFreeProductType() {
		return freeProductType;
	}

	public void setFreeProductType(String freeProductType) {
		this.freeProductType = freeProductType;
	}

	public List<BurnRuleLocale> getRuleLocaleList() {
		return ruleLocaleList;
	}

	public void setRuleLocaleList(List<BurnRuleLocale> ruleLocaleList) {
		this.ruleLocaleList = ruleLocaleList;
	}

	public List<Language> getLanguage() {
		return language;
	}

	public void setLanguage(List<Language> language) {
		this.language = language;
	}

	public String getRewardQty() {
		return rewardQty;
	}

	public void setRewardQty(String rewardQty) {
		this.rewardQty = rewardQty;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public Long getProgramId() {
		return programId;
	}

	public String getRewardType() {
		return rewardType;
	}

	public String getRewardImagePath() {
		return rewardImagePath;
	}

	public String getRuleImagepath() {
		return ruleImagepath;
	}

	public void setRuleImagepath(String ruleImagepath) {
		this.ruleImagepath = ruleImagepath;
	}

	public boolean isDisplayHomeScreen() {
		return isDisplayHomeScreen;
	}

	public boolean isExclusive() {
		return isExclusive;
	}

	public String getSkuFilePath() {
		return skuFilePath;
	}

	public Integer getMinimumPoints() {
		return minimumPoints;
	}

	public boolean isExcludeStore() {
		return isExcludeStore;
	}

	public boolean isExcludeSku() {
		return isExcludeSku;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	public void setRewardImagePath(String rewardImagePath) {
		this.rewardImagePath = rewardImagePath;
	}
	
	public void setDisplayHomeScreen(boolean isDisplayHomeScreen) {
		this.isDisplayHomeScreen = isDisplayHomeScreen;
	}

	public void setExclusive(boolean isExclusive) {
		this.isExclusive = isExclusive;
	}

	public void setSkuFilePath(String skuFilePath) {
		this.skuFilePath = skuFilePath;
	}


	public void setMinimumPoints(Integer minimumPoints) {
		this.minimumPoints = minimumPoints;
	}

	public void setExcludeStore(boolean isExcludeStore) {
		this.isExcludeStore = isExcludeStore;
	}

	public void setExcludeSku(boolean isExcludeSku) {
		this.isExcludeSku = isExcludeSku;
	}
	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public List<Store> getStore() {
		return store;
	}

	public void setStore(List<Store> store) {
		this.store = store;
	}

}
