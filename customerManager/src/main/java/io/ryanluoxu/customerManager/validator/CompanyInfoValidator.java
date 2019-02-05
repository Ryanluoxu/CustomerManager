package io.ryanluoxu.customerManager.validator;

import io.ryanluoxu.customerManager.bean.input.CompanyInfoInput;
import io.ryanluoxu.customerManager.exception.CommonException;

public interface CompanyInfoValidator {

	void validateMandatoryFields(CompanyInfoInput companyInfoInput, String actionType) throws CommonException;
	void validateInputValue(CompanyInfoInput companyInfoInput, String actionType) throws CommonException;

}
