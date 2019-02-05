package io.ryanluoxu.customerManager.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.ryanluoxu.customerManager.bean.entity.ProductInfo;
import io.ryanluoxu.customerManager.bean.input.ProductInfoInput;
import io.ryanluoxu.customerManager.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.exception.CommonError;
import io.ryanluoxu.customerManager.exception.CommonException;
import io.ryanluoxu.customerManager.exception.ProductInfoError;
import io.ryanluoxu.customerManager.exception.ProductInfoException;
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
			throw new CommonException(CommonError.INVALID_CUSTOMER_INFO_ID);
		}
	}
	
	@Override
	public void validateInputValue(ProductInfoInput productInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			checkProductInfoId(productInfoInput);
			
		} else {
			throw new CommonException(CommonError.INVALID_CUSTOMER_INFO_ID);
		}
	}
	
	/**
	 * check missing fields
	 */
	private void checkMissingProductName(ProductInfoInput productInfoInput) throws ProductInfoException {
		if (StringUtils.isEmpty(productInfoInput.getProductName())) {
			throw new ProductInfoException(ProductInfoError.MISSING_PRODUCT_NAME);
		}
	}
	private void checkMissingProductInfoId(ProductInfoInput productInfoInput) throws ProductInfoException {
		
	}
	
	/**
	 * validate fields
	 */
	private void checkProductInfoId(ProductInfoInput productInfoInput) throws CommonException {
		// TODO check status
		ProductInfo productInfo = productInfoService.getById(productInfoInput.getProductInfoId());
		if (productInfo == null) {
			throw new CommonException(CommonError.INVALID_PRODUCT_INFO_ID);
		}
	}


}
