package io.ryanluoxu.customerManager.dao.impl;

import org.springframework.stereotype.Repository;

import io.ryanluoxu.customerManager.dao.CustomerInfoDao;
import io.ryanluoxu.customerManager.entity.CustomerInfo;

@Repository
public class CustomerInfoDaoImpl extends GenericDaoImpl<CustomerInfo, Long> implements CustomerInfoDao {
	
}
