package io.ryanluoxu.customerManager.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
		checkMissingCustomerName(customerInfoInput);
	}

	@Override
	public void validateInputValueForAdd(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		// TODO Auto-generated method stub
	}

	@Override
	public void validateMandatoryFieldsForDelete(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		checkMissingCustomerInfoId(customerInfoInput);
	}

	@Override
	public void validateInputValueForDelete(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		checkCustomerInfoId(customerInfoInput);
	}

	@Override
	public void validateMandatoryFieldsForEdit(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		checkMissingCustomerInfoId(customerInfoInput);
	}

	@Override
	public void validateInputValueForEdit(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * check missing fields
	 */
	private void checkMissingCustomerName(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		if (StringUtils.isEmpty(customerInfoInput.getCustomerName())) {
			throw new CustomerInfoException(CustomerInfoError.MISSING_CUSTOMER_NAME);
		}
	}
	private void checkMissingCustomerInfoId(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		if (customerInfoInput.getCustomerName() == null) {
			throw new CustomerInfoException(CustomerInfoError.MISSING_CUSTOMER_INFO_ID);
		}
	}
	
	/**
	 * validate fields
	 */
	private void checkCustomerInfoId(CustomerInfoInput customerInfoInput) throws CustomerInfoException {
		// TODO check status
		CustomerInfo customerInfo = customerInfoService.getById(customerInfoInput.getCustomerInfoId());
		if (customerInfo == null) {
			throw new CustomerInfoException(CustomerInfoError.INVALID_CUSTOMER_INFO_ID);
		}
	}

}
