package io.ryanluoxu.customerManager.service;

import java.util.List;

import io.ryanluoxu.customerManager.entity.CustomerInfo;

public interface CustomerInfoService {
	CustomerInfo add(CustomerInfo customerInfo);
	CustomerInfo update(CustomerInfo customerInfo);
	CustomerInfo deleteById(Long customerInfoId);

	List<CustomerInfo> findAll();
	CustomerInfo getById(Long customerInfoId);
	List<CustomerInfo> findActive();
}
