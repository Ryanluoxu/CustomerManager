package io.ryanluoxu.customerManager.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.entity.CustomerInfo;
import io.ryanluoxu.customerManager.exception.CustomerInfoError;
import io.ryanluoxu.customerManager.exception.CustomerInfoException;
import io.ryanluoxu.customerManager.input.CustomerInfoInput;
import io.ryanluoxu.customerManager.service.CustomerInfoService;
import io.ryanluoxu.customerManager.validator.CustomerInfoValidator;

@Service
public class CustomerInfoValidatorImpl implements CustomerInfoValidator {
	
	@Autowired
	private CustomerInfoService customerInfoService;

	@Override
	public void validateMandatoryFieldsForAdd(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		if (customerInfoInput.getCustomerName() == null) {
			throw new CustomerInfoException(CustomerInfoError.MISSING_CUSTOMER_NAME);
		}
	}

	@Override
	public void validateInputValueForAdd(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		// TODO Auto-generated method stub
	}

	@Override
	public void validateMandatoryFieldsForDelete(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		if (customerInfoInput.getCustomerInfoId() == null) {
			throw new CustomerInfoException(CustomerInfoError.MISSING_CUSTOMER_INFO_ID);
		}
	}

	@Override
	public void validateInputValueForDelete(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		CustomerInfo customerInfo = customerInfoService.getById(customerInfoInput.getCustomerInfoId());
		if (customerInfo == null) {
			throw new CustomerInfoException(CustomerInfoError.INVALID_CUSTOMER_INFO_ID);
		}
	}

}
