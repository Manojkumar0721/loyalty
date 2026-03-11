package com.reciproci.loyalty.program.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"page","pageSize","totalCount","order","items"})
public class SearchResponse {
	
	private int page;
	private int pageSize;
	private int totalCoant;
	private Order order;
	private List<SearchItem> items = new ArrayList<>();
	
	
	public int getPage() {
		return page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalCoant() {
		return totalCoant;
	}

	public Order getOrder() {
		return order;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalCoant(int totalCoant) {
		this.totalCoant = totalCoant;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	public List<SearchItem> getItems() {
		return items;
	}

	public void setItems(List<SearchItem> items) {
		this.items = items;
	}


	public class Order{
		private String column;
		private String dir;
		public String getColumn() {
			return column;
		}
		public String getDir() {
			return dir;
		}
		public void setColumn(String column) {
			this.column = column;
		}
		public void setDir(String dir) {
			this.dir = dir;
		}
		
	}
	
	public class SearchItem{
		
		private Long programId;
		private Long brandId;
		private String brandName;
		private String programName;
		private String reward;
		private String endDate;
		private LocalDateTime modifiedTime;
		private String status;
		public Long getProgramId() {
			return programId;
		}
		public Long getBrandId() {
			return brandId;
		}
		public String getBrandName() {
			return brandName;
		}
		public String getProgramName() {
			return programName;
		}
		public String getReward() {
			return reward;
		}
		public String getEndDate() {
			return endDate;
		}
		public LocalDateTime getModifiedTime() {
			return modifiedTime;
		}
		public String getStatus() {
			return status;
		}
		public void setProgramId(Long programId) {
			this.programId = programId;
		}
		public void setBrandId(Long brandId) {
			this.brandId = brandId;
		}
		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}
		public void setProgramName(String programName) {
			this.programName = programName;
		}
		public void setReward(String reward) {
			this.reward = reward;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		public void setModifiedTime(LocalDateTime modifiedTime) {
			this.modifiedTime = modifiedTime;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
	}
	
	public void setSearchItems(List<SearchItem> arrayList) {
		this.items = arrayList;
	}


}
