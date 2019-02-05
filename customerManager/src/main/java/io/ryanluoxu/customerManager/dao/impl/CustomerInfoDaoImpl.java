package io.ryanluoxu.customerManager.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;
import io.ryanluoxu.customerManager.constant.CustomerInfoConstant;
import io.ryanluoxu.customerManager.dao.CustomerInfoDao;

@Repository
public class CustomerInfoDaoImpl extends GenericDaoImpl<CustomerInfo, Long> implements CustomerInfoDao {

	private static String STATUS = "status";

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerInfo> findActive() {
		Criteria criteria = getSession().createCriteria(CustomerInfo.class);
		criteria.add(Restrictions.eq(STATUS, CustomerInfoConstant.STATUS_ACTIVE));
		return criteria.list();
	}

}
