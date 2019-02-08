package io.ryanluoxu.customerManager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.bean.entity.ProductInfo;
import io.ryanluoxu.customerManager.bean.input.QueryInput;
import io.ryanluoxu.customerManager.dao.ProductInfoDao;

@Repository
public class ProductInfoDaoImpl extends GenericDaoImpl<ProductInfo, Long> implements ProductInfoDao {

	private static String STATUS = "status";
	private static String PRODUCT_INFO_ID = "productInfoId";
	private static String COMPANY_INFO_ID = "companyInfoId";

	@Override
	public List<ProductInfo> findActive() {
		CriteriaQuery<ProductInfo> criteriaQuery = getCriteriaQuery(QUERY_TYPE_EQUAL, STATUS, StatusConstant.ACTIVE);
		return getSession().createQuery(criteriaQuery).getResultList();
	}

	@Override
	public ProductInfo getActive(Long productInfoId) {
		List<QueryInput> queryInputs = new ArrayList<>();
		queryInputs.add(new QueryInput(QUERY_TYPE_EQUAL, STATUS, StatusConstant.ACTIVE));
		queryInputs.add(new QueryInput(QUERY_TYPE_EQUAL, PRODUCT_INFO_ID, String.valueOf(productInfoId)));
		CriteriaQuery<ProductInfo> criteriaQuery = getCriteriaQuery(queryInputs);
		return getSession().createQuery(criteriaQuery).getSingleResult();
	}

	@Override
	public List<ProductInfo> findByCompanyInfoId(Long companyInfoId) {
		CriteriaQuery<ProductInfo> criteriaQuery = getCriteriaQuery(QUERY_TYPE_EQUAL, COMPANY_INFO_ID, String.valueOf(companyInfoId));
		return getSession().createQuery(criteriaQuery).getResultList();
	}

}
