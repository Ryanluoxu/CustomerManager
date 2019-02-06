package io.ryanluoxu.customerManager.validator;

import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.bean.input.CompanyInfoInput;

public interface CompanyInfoValidator {

	void validateMandatoryFields(CompanyInfoInput companyInfoInput, String actionType) throws CommonException;
	void validateInputValue(CompanyInfoInput companyInfoInput, String actionType) throws CommonException;

}
