package io.ryanluoxu.customerManager.validator;

import io.ryanluoxu.customerManager.exception.CustomerInfoException;
import io.ryanluoxu.customerManager.input.CustomerInfoInput;

public interface CustomerInfoValidator {

	void validateMandatoryFieldsForAdd(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	void validateMandatoryFieldsForDelete(CustomerInfoInput customerInfoInput) throws CustomerInfoException;

	void validateInputValueForAdd(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	void validateInputValueForDelete(CustomerInfoInput customerInfoInput) throws CustomerInfoException;

}
