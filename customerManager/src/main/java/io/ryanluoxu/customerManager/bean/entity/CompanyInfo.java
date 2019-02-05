package io.ryanluoxu.customerManager.bean.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="company_info")
public class CompanyInfo implements Serializable{

	private static final long serialVersionUID = -667259521602728457L;

	@Id
	@Column(name="company_info_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_info_seq_gen")
	@SequenceGenerator(name = "company_info_seq_gen", sequenceName = "company_info_id_seq", initialValue = 1, allocationSize = 1)
	private Long companyInfoId;

	@Column(name="company_name")
	private String companyName;
	@Column(name="country")
	private String country;
	@Column(name="status")
	private String status;
	@Column(name="created_date")
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
