package com.reciproci.loyalty.program.model;

import java.time.LocalDateTime;


public class CreateProgramBean {
	
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
	
	private Long brandId;

	public String getStatus() {
		return status;
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

	public Long getBrandId() {
		return brandId;
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

	public void setStatus(String status) {
		this.status = status;
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

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
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

}
