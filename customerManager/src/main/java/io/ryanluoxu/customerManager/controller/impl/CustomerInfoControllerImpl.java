package io.ryanluoxu.customerManager.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.constant.CustomerInfoConstant;
import io.ryanluoxu.customerManager.controller.CustomerInfoController;
import io.ryanluoxu.customerManager.entity.CustomerInfo;
import io.ryanluoxu.customerManager.exception.CustomerInfoException;
import io.ryanluoxu.customerManager.input.CustomerInfoInput;
import io.ryanluoxu.customerManager.service.CustomerInfoService;
import io.ryanluoxu.customerManager.validator.CustomerInfoValidator;
import io.ryanluoxu.customerManager.vo.CustomerInfoVO;

@Service
public class CustomerInfoControllerImpl extends BaseControllerImpl<CustomerInfo, CustomerInfoVO, CustomerInfoInput> implements CustomerInfoController {

	@Autowired
	private CustomerInfoValidator customerInfoValidator;

	@Autowired
	private CustomerInfoService customerInfoService;

	@Override
	public void validateInputForAdd(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		customerInfoValidator.validateMandatoryFieldsForAdd(customerInfoInput);
		customerInfoValidator.validateInputValueForAdd(customerInfoInput);
	}

	@Override
	public void validateInputForEdit(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		customerInfoValidator.validateMandatoryFieldsForEdit(customerInfoInput);
		customerInfoValidator.validateInputValueForEdit(customerInfoInput);
	}
	
	@Override
	public void validateInputForDelete(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		customerInfoValidator.validateMandatoryFieldsForDelete(customerInfoInput);
		customerInfoValidator.validateInputValueForDelete(customerInfoInput);
	}

	@Override
	public CustomerInfoVO add(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		return convertToVO(customerInfoService.add(convertToBean(customerInfoInput)));
	}

	@Override
	public CustomerInfoVO delete(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		CustomerInfo customerInfo = customerInfoService.getById(customerInfoInput.getCustomerInfoId());
		customerInfo.setStatus(CustomerInfoConstant.STATUS_INACTIVE);
		return convertToVO(customerInfoService.update(customerInfo));
	}

	@Override
	public List<CustomerInfoVO> findAll() throws CustomerInfoException {
		List<CustomerInfoVO> customerInfoVOs = new ArrayList<>();
		List<CustomerInfo> customerInfos = customerInfoService.findActive();
		for (CustomerInfo customerInfo : customerInfos) {
			CustomerInfoVO customerInfoVO = convertToVO(customerInfo);
			customerInfoVOs.add(customerInfoVO);
		}
		return customerInfoVOs;
	}

	@Override
	public CustomerInfoVO update(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		// TODO Auto-generated method stub
		return null;
	}




}
