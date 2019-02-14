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
@Table(name="product_info")
public class ProductInfo implements Serializable{
	private static final long serialVersionUID = 8073995469761213521L;

	@Id
	@Column(name="product_info_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_info_seq_gen")
	@SequenceGenerator(name = "product_info_seq_gen", sequenceName = "product_info_id_seq", initialValue = 1, allocationSize = 1)
	private Long productInfoId;

	@Column(name="company_info_id")
	private Long companyInfoId;
	@Column(name="product_name")
	private String productName;
	@Column(name="status")
	private String status;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="min_price")
	private double minPrice;
	@Column(name="max_price")
	private double maxPrice;
	
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
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
