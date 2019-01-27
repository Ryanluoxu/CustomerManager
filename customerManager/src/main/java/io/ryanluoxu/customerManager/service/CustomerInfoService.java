package io.ryanluoxu.customerManager.service;

import java.util.List;

import io.ryanluoxu.customerManager.entity.CustomerInfo;

public interface CustomerInfoService {
	CustomerInfo addCustomerInfo(CustomerInfo customerInfo);
	CustomerInfo updateCustomerInfo(CustomerInfo customerInfo);
	CustomerInfo deleteById(Long customerInfoId);
	
	List<CustomerInfo> findAll();
	CustomerInfo getById(Long customerInfoId);
}
