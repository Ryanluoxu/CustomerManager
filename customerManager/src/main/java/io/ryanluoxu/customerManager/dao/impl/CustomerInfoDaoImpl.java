package io.ryanluoxu.customerManager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;
import io.ryanluoxu.customerManager.bean.input.QueryInput;
import io.ryanluoxu.customerManager.dao.CustomerInfoDao;

@Repository
public class CustomerInfoDaoImpl extends GenericDaoImpl<CustomerInfo, Long> implements CustomerInfoDao {

	private static String CUSTOMER_INFO_ID = "customerInfoId";

	@Override
	public CustomerInfo getActive(Long customerInfoId) {
		List<QueryInput> queryInputs = new ArrayList<>();
		queryInputs.add(new QueryInput(QUERY_TYPE_EQUAL, STATUS, StatusConstant.ACTIVE));
		queryInputs.add(new QueryInput(QUERY_TYPE_EQUAL, CUSTOMER_INFO_ID, String.valueOf(customerInfoId)));
		CriteriaQuery<CustomerInfo> criteriaQuery = getCriteriaQuery(queryInputs);
		return getSession().createQuery(criteriaQuery).getSingleResult();
	}

}
