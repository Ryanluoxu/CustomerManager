package io.ryanluoxu.customerManager.dao;

import java.util.List;

import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;

public interface CustomerInfoDao extends GenericDao<CustomerInfo, Long>{

	List<CustomerInfo> findActive();

	CustomerInfo getActive(Long customerInfoId);

}
