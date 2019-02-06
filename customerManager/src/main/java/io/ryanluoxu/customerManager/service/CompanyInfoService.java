package io.ryanluoxu.customerManager.service;

import java.util.List;

import io.ryanluoxu.customerManager.bean.entity.CompanyInfo;

public interface CompanyInfoService {
	CompanyInfo add(CompanyInfo companyInfo);
	CompanyInfo update(CompanyInfo companyInfo);
	CompanyInfo deleteById(Long companyInfoId);

	List<CompanyInfo> findAll();
	List<CompanyInfo> findActive();
	CompanyInfo getById(Long companyInfoId);
	CompanyInfo getActive(Long companyInfoId);
}
