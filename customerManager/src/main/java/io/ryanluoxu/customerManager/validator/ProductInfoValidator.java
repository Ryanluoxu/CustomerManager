package io.ryanluoxu.customerManager.validator;

import io.ryanluoxu.customerManager.bean.input.ProductInfoInput;
import io.ryanluoxu.customerManager.exception.CommonException;

public interface ProductInfoValidator {

	void validateMandatoryFields(ProductInfoInput productInfoInput, String actionType) throws CommonException;
	void validateInputValue(ProductInfoInput productInfoInput, String actionType) throws CommonException;

}
