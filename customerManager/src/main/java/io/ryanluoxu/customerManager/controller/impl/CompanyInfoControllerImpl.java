package io.ryanluoxu.customerManager.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.bean.entity.CompanyInfo;
import io.ryanluoxu.customerManager.bean.input.CompanyInfoInput;
import io.ryanluoxu.customerManager.bean.vo.CompanyInfoVO;
import io.ryanluoxu.customerManager.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.controller.CompanyInfoController;
import io.ryanluoxu.customerManager.exception.CommonError;
import io.ryanluoxu.customerManager.exception.CommonException;
import io.ryanluoxu.customerManager.service.CompanyInfoService;
import io.ryanluoxu.customerManager.validator.CompanyInfoValidator;

@Service
public class CompanyInfoControllerImpl extends BaseControllerImpl<CompanyInfo, CompanyInfoVO, CompanyInfoInput> implements CompanyInfoController {
	
	@Autowired
	private CompanyInfoValidator companyInfoValidator;

	@Autowired
	private CompanyInfoService companyInfoService;

	@Override
	public List<CompanyInfoVO> findAll() throws CommonException {
		List<CompanyInfoVO> companyInfoVOs = new ArrayList<>();
		List<CompanyInfo> companyInfos = companyInfoService.findActive();
		for (CompanyInfo companyInfo : companyInfos) {
			CompanyInfoVO companyInfoVO = convertToVO(companyInfo);
			companyInfoVOs.add(companyInfoVO);
		}
		return companyInfoVOs;
	}


	@Override
	public CompanyInfoVO add(CompanyInfoInput companyInfoInput) throws CommonException {
		return convertToVO(companyInfoService.add(convertToBean(companyInfoInput)));
	}

	@Override
	public CompanyInfoVO update(CompanyInfoInput companyInfoInput) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public CompanyInfoVO delete(CompanyInfoInput companyInfoInput) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validateInput(CompanyInfoInput companyInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			companyInfoValidator.validateMandatoryFields(companyInfoInput, actionType);
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			
		} else {
			throw new CommonException(CommonError.INVALID_CUSTOMER_INFO_ID);
		}
		
	}







}
