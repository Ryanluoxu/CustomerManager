package io.ryanluoxu.customerManager.validator;

import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.bean.input.CustomerInfoInput;

public interface CustomerInfoValidator {

	void validateMandatoryFields(CustomerInfoInput customerInfoInput, String actionType) throws CommonException;
	void validateInputValue(CustomerInfoInput customerInfoInput, String actionType) throws CommonException;
}
