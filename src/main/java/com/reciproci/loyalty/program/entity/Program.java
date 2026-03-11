package com.reciproci.loyalty.program.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.reciproci.loyalty.brand.entity.Brand;
import com.reciproci.loyalty.burnrule.entity.BurnRule;
import com.reciproci.loyalty.earnrule.entity.EarnRule;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROGRAM")
public class Program {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String status;
	
	private String programType;
	
	private String programName;
	
	private String programDiscription;
	
	private String programImgpath;
	
	private String rewardType;
	
	private String startDate;
	
	private String endDate;
	
	private String startTime;
	
	private String endTime;
	
	private String pointExpiryIn;
	
	private Integer expiryDays;
	
	private String expireDate;
	
	private String skuFilePath;
	
	private boolean isPrepetual;
	
	private LocalDateTime createdTime;
	
	private LocalDateTime modifiedTime;
	
	@OneToOne(mappedBy = "program", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Brand brand;
	
	@OneToMany(mappedBy = "program", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<EarnRule> earnRules;
	
	@OneToOne(mappedBy = "program", cascade = CascadeType.ALL)
	@JsonManagedReference
	private BurnRule burnRule;


	public Long getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProgramType() {
		return programType;
	}

	public String getProgramName() {
		return programName;
	}

	public String getProgramDiscription() {
		return programDiscription;
	}

	public String getProgramImgpath() {
		return programImgpath;
	}


	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getPointExpiryIn() {
		return pointExpiryIn;
	}

	public Integer getExpiryDays() {
		return expiryDays;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public String getSkuFilePath() {
		return skuFilePath;
	}

	public boolean isPrepetual() {
		return isPrepetual;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public void setProgramDiscription(String programDiscription) {
		this.programDiscription = programDiscription;
	}

	public void setProgramImgpath(String programImgpath) {
		this.programImgpath = programImgpath;
	}


	public String getRewardType() {
		return rewardType;
	}

	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setPointExpiryIn(String pointExpiryIn) {
		this.pointExpiryIn = pointExpiryIn;
	}

	public void setExpiryDays(Integer expiryDays) {
		this.expiryDays = expiryDays;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public void setSkuFilePath(String skuFilePath) {
		this.skuFilePath = skuFilePath;
	}

	public void setPrepetual(boolean isPrepetual) {
		this.isPrepetual = isPrepetual;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<EarnRule> getEarnRules() {
		return earnRules;
	}

	public void setEarnRules(List<EarnRule> earnRules) {
		this.earnRules = earnRules;
	}

	public BurnRule getBurnRule() {
		return burnRule;
	}

	public void setBurnRule(BurnRule burnRule) {
		this.burnRule = burnRule;
	}

}
