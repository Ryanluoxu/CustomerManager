package io.ryanluoxu.customerManager.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import io.ryanluoxu.customerManager.bean.entity.CompanyInfo;
import io.ryanluoxu.customerManager.constant.CompanyInfoConstant;
import io.ryanluoxu.customerManager.dao.CompanyInfoDao;

@Repository
public class CompanyInfoDaoImpl extends GenericDaoImpl<CompanyInfo, Long> implements CompanyInfoDao {

	private static String STATUS = "status";

	@Override
	public List<CompanyInfo> findActive() {
		CriteriaQuery<CompanyInfo> criteriaQuery = getCriteriaQuery(QUERY_TYPE_EQUAL, STATUS, CompanyInfoConstant.STATUS_ACTIVE);
		return getSession().createQuery(criteriaQuery).getResultList();		
	}
	
}