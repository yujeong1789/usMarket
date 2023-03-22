package com.spring.usMarket.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminSearchCondition {
	private Integer page = 1;
	private Integer pageSize;
	
	private String startDate = "2022-04-01";
	private String endDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
	private String condition = "";
	private String order = "";
	
	public AdminSearchCondition() {}

	public AdminSearchCondition(Integer page, Integer pageSize, String startDate, String endDate, String condition,
			String order) {
		this.page = page;
		this.pageSize = pageSize;
		this.startDate = startDate;
		this.endDate = endDate;
		this.condition = condition;
		this.order = order;
	}
	
	public Integer getStartPage() {
		return 1+(page-1)*pageSize; // 1, 31, 61...
	}
	
	public Integer getEndPage() {
		return page*pageSize; // 30, 60, 90...
	}
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "AdminSearchCondition [page=" + page + ", startPage=" + getStartPage() + ", endPage=" + getEndPage() + ", pageSize=" + pageSize + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", condition=" + condition + ", order=" + order + "]";
	}
}
