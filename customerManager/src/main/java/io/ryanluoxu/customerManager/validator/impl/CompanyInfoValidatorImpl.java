package io.ryanluoxu.customerManager.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.ryanluoxu.customerManager.bean.entity.CompanyInfo;
import io.ryanluoxu.customerManager.bean.input.CompanyInfoInput;
import io.ryanluoxu.customerManager.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.exception.CommonError;
import io.ryanluoxu.customerManager.exception.CommonException;
import io.ryanluoxu.customerManager.service.CompanyInfoService;
import io.ryanluoxu.customerManager.validator.CompanyInfoValidator;

@Service
public class CompanyInfoValidatorImpl implements CompanyInfoValidator {
	
	@Autowired
	private CompanyInfoService companyInfoService;

	@Override
	public void validateMandatoryFields(CompanyInfoInput companyInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			checkMissingCompanyName(companyInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			checkMissingCompanyInfoId(companyInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			checkMissingCompanyInfoId(companyInfoInput);
			
		} else {
			throw new CommonException(CommonError.INVALID_CUSTOMER_INFO_ID);
		}
	}
	
	@Override
	public void validateInputValue(CompanyInfoInput companyInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			checkCompanyInfoId(companyInfoInput);
			
		} else {
			throw new CommonException(CommonError.INVALID_CUSTOMER_INFO_ID);
		}
	}
	
	/**
	 * check missing fields
	 */
	private void checkMissingCompanyName(CompanyInfoInput companyInfoInput) throws CommonException {
		if (StringUtils.isEmpty(companyInfoInput.getCompanyName())) {
			throw new CommonException(CommonError.MISSING_COMPANY_NAME);
		}
	}
	private void checkMissingCompanyInfoId(CompanyInfoInput companyInfoInput) throws CommonException {
		
	}
	
	/**
	 * validate fields
	 */
	private void checkCompanyInfoId(CompanyInfoInput companyInfoInput) throws CommonException {
		// TODO check status
		CompanyInfo companyInfo = companyInfoService.getById(companyInfoInput.getCompanyInfoId());
		if (companyInfo == null) {
			throw new CommonException(CommonError.INVALID_PRODUCT_INFO_ID);
		}
	}


}
