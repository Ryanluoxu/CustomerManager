package io.ryanluoxu.customerManager.bean.input;

import io.ryanluoxu.customerManager.bean.BaseBean;

public class CompanyInfoInput extends BaseBean{

	private Long companyInfoId;
	private String companyName;
	private String country;
	private String status;
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
}
