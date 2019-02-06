package io.ryanluoxu.customerManager.bean.vo;

import java.util.Date;

import io.ryanluoxu.customerManager.bean.entity.CompanyInfo;

public class ProductInfoVO {

	private Long productInfoId;
	private CompanyInfo companyInfo;
	private String productName;
	private String status;
	private Date createdDate;
	public Long getProductInfoId() {
		return productInfoId;
	}
	public void setProductInfoId(Long productInfoId) {
		this.productInfoId = productInfoId;
	}
	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
