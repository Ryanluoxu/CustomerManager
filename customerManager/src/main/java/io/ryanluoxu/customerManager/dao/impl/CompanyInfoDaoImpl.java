package io.ryanluoxu.customerManager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import io.ryanluoxu.customerManager.base.constant.CompanyInfoConstant;
import io.ryanluoxu.customerManager.bean.entity.CompanyInfo;
import io.ryanluoxu.customerManager.bean.input.QueryInput;
import io.ryanluoxu.customerManager.dao.CompanyInfoDao;

@Repository
public class CompanyInfoDaoImpl extends GenericDaoImpl<CompanyInfo, Long> implements CompanyInfoDao {

	private static String STATUS = "status";
	private static String COMPANY_INFO_ID = "companyInfoId";

	@Override
	public List<CompanyInfo> findActive() {
		CriteriaQuery<CompanyInfo> criteriaQuery = getCriteriaQuery(QUERY_TYPE_EQUAL, STATUS, CompanyInfoConstant.STATUS_ACTIVE);
		return getSession().createQuery(criteriaQuery).getResultList();		
	}

	@Override
	public CompanyInfo getActive(Long companyInfoId) {
		List<QueryInput> queryInputs = new ArrayList<>();
		queryInputs.add(new QueryInput(QUERY_TYPE_EQUAL, STATUS, CompanyInfoConstant.STATUS_ACTIVE));
		queryInputs.add(new QueryInput(QUERY_TYPE_EQUAL, COMPANY_INFO_ID, String.valueOf(companyInfoId)));
		CriteriaQuery<CompanyInfo> criteriaQuery = getCriteriaQuery(queryInputs);
		return getSession().createQuery(criteriaQuery).getSingleResult();	
	}

}