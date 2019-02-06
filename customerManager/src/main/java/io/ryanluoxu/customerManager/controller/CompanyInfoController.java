package io.ryanluoxu.customerManager.controller;

import java.util.List;

import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.bean.input.CompanyInfoInput;
import io.ryanluoxu.customerManager.bean.vo.CompanyInfoVO;

public interface CompanyInfoController {

	void validateInput(CompanyInfoInput companyInfoInput, String actionType) throws CommonException;

	CompanyInfoVO add(CompanyInfoInput companyInfoInput) throws CommonException;
	CompanyInfoVO update(CompanyInfoInput companyInfoInput) throws CommonException;
	CompanyInfoVO delete(CompanyInfoInput companyInfoInput) throws CommonException;

	List<CompanyInfoVO> findAll() throws CommonException;

}
