package io.ryanluoxu.customerManager.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import io.ryanluoxu.customerManager.bean.entity.ProductInfo;
import io.ryanluoxu.customerManager.constant.ProductInfoConstant;
import io.ryanluoxu.customerManager.dao.ProductInfoDao;

@Repository
public class ProductInfoDaoImpl extends GenericDaoImpl<ProductInfo, Long> implements ProductInfoDao {

	private static String STATUS = "status";

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<ProductInfo> findActive() {
		Criteria criteria = getSession().createCriteria(ProductInfo.class);
		criteria.add(Restrictions.eq(STATUS, ProductInfoConstant.STATUS_ACTIVE));
		return criteria.list();
	}

}
