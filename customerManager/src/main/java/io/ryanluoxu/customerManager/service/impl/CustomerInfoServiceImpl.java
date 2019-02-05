package io.ryanluoxu.customerManager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;
import io.ryanluoxu.customerManager.constant.CustomerInfoConstant;
import io.ryanluoxu.customerManager.dao.CustomerInfoDao;
import io.ryanluoxu.customerManager.service.CustomerInfoService;

@Service
@Transactional
public class CustomerInfoServiceImpl implements CustomerInfoService {

	@Autowired
	private CustomerInfoDao customerInfoDao;

	@Override
	public CustomerInfo add(CustomerInfo customerInfo) {
		customerInfo.setCreatedDate(new Date());
		customerInfo.setStatus(CustomerInfoConstant.STATUS_ACTIVE);
		return customerInfoDao.add(customerInfo);
	}

	@Override
	public CustomerInfo update(CustomerInfo customerInfo) {
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

	@Override
	public List<CustomerInfo> findActive() {
		return customerInfoDao.findActive();
	}

}
