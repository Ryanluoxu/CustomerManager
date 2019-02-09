package io.ryanluoxu.customerManager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import io.ryanluoxu.customerManager.base.constant.CompanyInfoConstant;
import io.ryanluoxu.customerManager.bean.entity.OrderInfo;
import io.ryanluoxu.customerManager.bean.input.QueryInput;
import io.ryanluoxu.customerManager.dao.OrderInfoDao;

@Repository
public class OrderInfoDaoImpl extends GenericDaoImpl<OrderInfo, Long> implements OrderInfoDao {

	private static String ORDER_INFO_ID = "orderInfoId";

	@Override
	public OrderInfo getActive(Long id) {
		List<QueryInput> queryInputs = new ArrayList<>();
		queryInputs.add(new QueryInput(QUERY_TYPE_EQUAL, STATUS, CompanyInfoConstant.STATUS_ACTIVE));
		queryInputs.add(new QueryInput(QUERY_TYPE_EQUAL, ORDER_INFO_ID, String.valueOf(id)));
		CriteriaQuery<OrderInfo> criteriaQuery = getCriteriaQuery(queryInputs);
		return getSession().createQuery(criteriaQuery).getSingleResult();	
	}

}