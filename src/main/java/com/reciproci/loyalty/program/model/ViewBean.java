package com.reciproci.loyalty.program.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.reciproci.loyalty.brand.entity.Brand;


@JsonPropertyOrder({"programId","status","programType","programName","programDescription","programImgPath",
	"rewardType","startDate","endDate","startTime","endTime","pointExpiryIn","expiryDays","expireDate","skuFilePath",
	"isPerpetual","createdTime","modifiedTime","brand"})
public class ViewBean {
	private Long programId;
	
	private String status;
	
	private String programType;
	
	private String programName;
	
	private String programDescription;
	
	private String programImgPath;
	
	private String rewardType;
	
	private String startDate;
	
	private String endDate;
	
	private String startTime;
	
	private String endTime;
	
	private String pointExpiryIn;
	
	private Integer expiryDays;	
	
	private String expireDate;
	
	private String skuFilePath;
	
	private boolean isPerpetual;
	
	private LocalDateTime createdTime;
	
	private LocalDateTime modifiedTime;
	private Brand brand;
	public Long getProgramId() {
		return programId;
	}
	public void setProgramId(Long programId) {
		this.programId = programId;
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
	public void setProgramType(String programType) {
		this.programType = programType;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramDescription() {
		return programDescription;
	}
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}
	public String getProgramImgPath() {
		return programImgPath;
	}
	public void setProgramImgPath(String programImgPath) {
		this.programImgPath = programImgPath;
	}
	public String getRewardType() {
		return rewardType;
	}
	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getPointExpiryIn() {
		return pointExpiryIn;
	}
	public void setPointExpiryIn(String pointExpiryIn) {
		this.pointExpiryIn = pointExpiryIn;
	}
	public Integer getExpiryDays() {
		return expiryDays;
	}
	public void setExpiryDays(Integer expiryDays) {
		this.expiryDays = expiryDays;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	public String getSkuFilePath() {
		return skuFilePath;
	}
	public void setSkuFilePath(String skuFilePath) {
		this.skuFilePath = skuFilePath;
	}
	public boolean isPerpetual() {
		return isPerpetual;
	}
	public void setPerpetual(boolean isPerpetual) {
		this.isPerpetual = isPerpetual;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	
}

