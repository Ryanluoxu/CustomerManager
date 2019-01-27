package io.ryanluoxu.customerManager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.dao.CustomerInfoDao;
import io.ryanluoxu.customerManager.entity.CustomerInfo;
import io.ryanluoxu.customerManager.service.CustomerInfoService;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {
	
	@Autowired
	private CustomerInfoDao customerInfoDao;

	@Override
	public CustomerInfo addCustomerInfo(CustomerInfo customerInfo) {
		return customerInfoDao.add(customerInfo);
	}

	@Override
	public CustomerInfo updateCustomerInfo(CustomerInfo customerInfo) {
		return customerInfoDao.update(customerInfo);
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

}
