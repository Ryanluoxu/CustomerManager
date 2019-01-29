package io.ryanluoxu.customerManager.controller.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.controller.CustomerInfoController;
import io.ryanluoxu.customerManager.entity.CustomerInfo;
import io.ryanluoxu.customerManager.exception.CustomerInfoException;
import io.ryanluoxu.customerManager.input.CustomerInfoInput;
import io.ryanluoxu.customerManager.service.CustomerInfoService;
import io.ryanluoxu.customerManager.validator.CustomerInfoValidator;
import io.ryanluoxu.customerManager.vo.CustomerInfoVO;

@Service
public class CustomerInfoControllerImpl implements CustomerInfoController {
	
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
	public void validateInputForDelete(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		customerInfoValidator.validateMandatoryFieldsForDelete(customerInfoInput);
		customerInfoValidator.validateInputValueForDelete(customerInfoInput);
	}

	@Override
	public CustomerInfoVO add(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		return convertToCustomerInfoVO(customerInfoService.addCustomerInfo(customerInfoInput));
	}

	@Override
	public CustomerInfoVO delete(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		return convertToCustomerInfoVO(customerInfoService.deleteById(customerInfoInput.getCustomerInfoId()));
	}

	private CustomerInfoVO convertToCustomerInfoVO(CustomerInfo customerInfo) {
		CustomerInfoVO customerInfoVO = new CustomerInfoVO();
		BeanUtils.copyProperties(customerInfo, customerInfoVO);
		return customerInfoVO;
	}

}