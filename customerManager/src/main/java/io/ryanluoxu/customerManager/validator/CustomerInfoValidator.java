package io.ryanluoxu.customerManager.validator;

import io.ryanluoxu.customerManager.bean.input.CustomerInfoInput;
import io.ryanluoxu.customerManager.exception.CustomerInfoException;

public interface CustomerInfoValidator {

	void validateMandatoryFieldsForAdd(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	void validateMandatoryFieldsForEdit(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	void validateMandatoryFieldsForDelete(CustomerInfoInput customerInfoInput) throws CustomerInfoException;

	void validateInputValueForAdd(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	void validateInputValueForEdit(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	void validateInputValueForDelete(CustomerInfoInput customerInfoInput) throws CustomerInfoException;

}
