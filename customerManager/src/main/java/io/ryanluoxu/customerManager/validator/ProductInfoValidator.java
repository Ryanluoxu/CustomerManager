package io.ryanluoxu.customerManager.validator;

import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.bean.input.ProductInfoInput;

public interface ProductInfoValidator {

	void validateMandatoryFields(ProductInfoInput productInfoInput, String actionType) throws CommonException;
	void validateInputValue(ProductInfoInput productInfoInput, String actionType) throws CommonException;

}
