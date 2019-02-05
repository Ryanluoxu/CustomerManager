package io.ryanluoxu.customerManager.service;

import java.util.List;

import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;

public interface CustomerInfoService {
	CustomerInfo add(CustomerInfo customerInfo);
	CustomerInfo update(CustomerInfo customerInfo);
	CustomerInfo deleteById(Long customerInfoId);

	List<CustomerInfo> findAll();
	List<CustomerInfo> findActive();
	CustomerInfo getById(Long customerInfoId);
}
