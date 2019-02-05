package io.ryanluoxu.customerManager.bean.input;

import java.util.Date;

public class CompanyInfoInput{

	private Long companyInfoId;
	private String companyName;
	private String country;
	private String status;
	private Date createdDate;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
