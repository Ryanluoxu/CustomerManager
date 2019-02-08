package io.ryanluoxu.customerManager.bean.vo;

import java.util.Date;

public class ProductInfoVO {

	private Long productInfoId;
	private Long companyInfoId;
	private String companyName;
	private String productName;
	private String status;
	private Date createdDate;
	public Long getProductInfoId() {
		return productInfoId;
	}
	public void setProductInfoId(Long productInfoId) {
		this.productInfoId = productInfoId;
	}
	public Long getCompanyInfoId() {
		return companyInfoId;
	}
	public void setCompanyInfoId(Long companyInfoId) {
		this.companyInfoId = companyInfoId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	@Override
	public String toString() {
		return "ProductInfoVO [productInfoId=" + productInfoId + ", companyInfoId=" + companyInfoId + ", companyName="
				+ companyName + ", productName=" + productName + "]";
	}

}
