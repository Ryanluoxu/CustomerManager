package io.ryanluoxu.customerManager.bean.vo;

import java.util.Date;

public class CompanyInfoVO{

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
	@Override
	public String toString() {
		return "CompanyInfoVO [companyInfoId=" + companyInfoId + ", companyName=" + companyName + ", country=" + country
				+ "]";
	}

}