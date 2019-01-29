package io.ryanluoxu.customerManager.service;

import java.util.List;

import io.ryanluoxu.customerManager.entity.CustomerInfo;
import io.ryanluoxu.customerManager.input.CustomerInfoInput;

public interface CustomerInfoService {
	CustomerInfo addCustomerInfo(CustomerInfoInput customerInfoInput);
	CustomerInfo updateCustomerInfo(CustomerInfoInput customerInfoInput);
	CustomerInfo deleteById(Long customerInfoId);
	
	List<CustomerInfo> findAll();
	CustomerInfo getById(Long customerInfoId);
}
