package io.ryanluoxu.customerManager.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.exception.CommonError;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.base.exception.ProductInfoException;
import io.ryanluoxu.customerManager.bean.entity.ProductInfo;
import io.ryanluoxu.customerManager.bean.input.ProductInfoInput;
import io.ryanluoxu.customerManager.service.ProductInfoService;
import io.ryanluoxu.customerManager.validator.ProductInfoValidator;

@Service
public class ProductInfoValidatorImpl implements ProductInfoValidator {
	
	@Autowired
	private ProductInfoService productInfoService;

	@Override
	public void validateMandatoryFields(ProductInfoInput productInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			checkMissingProductName(productInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			checkMissingProductInfoId(productInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			checkMissingProductInfoId(productInfoInput);
			
		} else {
			throw new CommonException(CommonError.INVALID_ACTION_TYPE);
		}
	}
	
	@Override
	public void validateInputValue(ProductInfoInput productInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			validateProductInfoId(productInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			validateProductInfoId(productInfoInput);
			
		} else {
			throw new CommonException(CommonError.INVALID_PRODUCT_INFO_ID);
		}
	}
	
	/**
	 * check missing fields
	 */
	private void checkMissingProductName(ProductInfoInput productInfoInput) throws ProductInfoException {
		if (StringUtils.isEmpty(productInfoInput.getProductName())) {
			throw new ProductInfoException(CommonError.MISSING_PRODUCT_NAME);
		}
	}
	private void checkMissingProductInfoId(ProductInfoInput productInfoInput) throws ProductInfoException {
		if (productInfoInput.getProductInfoId() == null) {
			throw new ProductInfoException(CommonError.MISSING_PRODUCT_INFO_ID);
		}
	}
	
	/**
	 * validate fields
	 */
	private void validateProductInfoId(ProductInfoInput productInfoInput) throws CommonException {
		ProductInfo productInfo = productInfoService.getActive(productInfoInput.getProductInfoId());
		if (productInfo == null) {
			throw new CommonException(CommonError.INVALID_PRODUCT_INFO_ID);
		}
	}


}
