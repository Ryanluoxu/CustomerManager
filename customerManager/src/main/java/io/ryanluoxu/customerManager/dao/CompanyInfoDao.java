package io.ryanluoxu.customerManager.dao;

import java.util.List;

import io.ryanluoxu.customerManager.bean.entity.CompanyInfo;

public interface CompanyInfoDao extends GenericDao<CompanyInfo, Long>{

	List<CompanyInfo> findActive();

	CompanyInfo getActive(Long companyInfoId);

}
