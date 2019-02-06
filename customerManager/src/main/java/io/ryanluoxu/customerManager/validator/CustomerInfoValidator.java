package io.ryanluoxu.customerManager.validator;

import io.ryanluoxu.customerManager.base.exception.CustomerInfoException;
import io.ryanluoxu.customerManager.bean.input.CustomerInfoInput;

public interface CustomerInfoValidator {

	void validateMandatoryFieldsForAdd(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	void validateMandatoryFieldsForEdit(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	void validateMandatoryFieldsForDelete(CustomerInfoInput customerInfoInput) throws CustomerInfoException;

	void validateInputValueForAdd(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	void validateInputValueForEdit(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	void validateInputValueForDelete(CustomerInfoInput customerInfoInput) throws CustomerInfoException;

}
