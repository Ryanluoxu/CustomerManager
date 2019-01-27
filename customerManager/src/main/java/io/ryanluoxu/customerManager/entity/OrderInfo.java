package io.ryanluoxu.customerManager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="order_info")
public class OrderInfo implements Serializable{
	private static final long serialVersionUID = 4218469077136023963L;

	@Id
	@Column(name="order_info_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_info_seq_gen")
	@SequenceGenerator(name = "order_info_seq_gen", sequenceName = "order_info_id_seq", initialValue = 1, allocationSize = 1)
	private Long orderInfoId;
	
	@Column(name="customer_info_id")
	private String customerInfoId;
	@Column(name="product_name")
	private String productName;
	@Column(name="payment_mode")
	private String paymentMode;
	@Column(name="unit_price")
	private double unitPrice;
	@Column(name="quantity")
	private double quantity;
	@Column(name="profit")
	private double profit;
	public Long getOrderInfoId() {
		return orderInfoId;
	}
	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}
	public String getCustomerInfoId() {
		return customerInfoId;
	}
	public void setCustomerInfoId(String customerInfoId) {
		this.customerInfoId = customerInfoId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
}
