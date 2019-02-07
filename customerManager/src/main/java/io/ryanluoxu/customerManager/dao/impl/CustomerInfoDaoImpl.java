package io.ryanluoxu.customerManager.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;
import io.ryanluoxu.customerManager.dao.CustomerInfoDao;

@Repository
public class CustomerInfoDaoImpl extends GenericDaoImpl<CustomerInfo, Long> implements CustomerInfoDao {

	private static String STATUS = "status";

	@Override
	public List<CustomerInfo> findActive() {
		CriteriaQuery<CustomerInfo> criteriaQuery = getCriteriaQuery(QUERY_TYPE_EQUAL, STATUS, StatusConstant.ACTIVE);
		return getSession().createQuery(criteriaQuery).getResultList();
	}

}
