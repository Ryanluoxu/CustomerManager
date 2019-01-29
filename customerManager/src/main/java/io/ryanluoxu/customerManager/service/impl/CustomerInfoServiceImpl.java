package io.ryanluoxu.customerManager.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.dao.CustomerInfoDao;
import io.ryanluoxu.customerManager.entity.CustomerInfo;
import io.ryanluoxu.customerManager.input.CustomerInfoInput;
import io.ryanluoxu.customerManager.service.CustomerInfoService;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {
	
	@Autowired
	private CustomerInfoDao customerInfoDao;

	@Override
	public CustomerInfo addCustomerInfo(CustomerInfoInput customerInfoInput) {
		return customerInfoDao.add(convertToCustomerInfo(customerInfoInput));
	}

	@Override
	public CustomerInfo updateCustomerInfo(CustomerInfoInput customerInfoInput) {
		return customerInfoDao.update(convertToCustomerInfo(customerInfoInput));
	}

	@Override
	public CustomerInfo deleteById(Long customerInfoId) {
		return customerInfoDao.deleteById(customerInfoId);
	}

	@Override
	public List<CustomerInfo> findAll() {
		return customerInfoDao.findAll();
	}

	@Override
	public CustomerInfo getById(Long customerInfoId) {
		return customerInfoDao.getById(customerInfoId);
	}
	
	private CustomerInfo convertToCustomerInfo(CustomerInfoInput customerInfoInput) {
		CustomerInfo customerInfo = new CustomerInfo();
		BeanUtils.copyProperties(customerInfoInput, customerInfo);
		return customerInfo;
	}

}
