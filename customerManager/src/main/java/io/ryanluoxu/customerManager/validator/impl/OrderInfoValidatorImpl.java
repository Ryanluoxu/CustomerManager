package io.ryanluoxu.customerManager.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.exception.CommonError;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.bean.entity.OrderInfo;
import io.ryanluoxu.customerManager.bean.input.OrderInfoInput;
import io.ryanluoxu.customerManager.service.OrderInfoService;
import io.ryanluoxu.customerManager.validator.OrderInfoValidator;

@Service
public class OrderInfoValidatorImpl implements OrderInfoValidator {
	
	@Autowired
	private OrderInfoService orderInfoService;

	@Override
	public void validateMandatoryFields(OrderInfoInput orderInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			checkMissingOrderInfoId(orderInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			checkMissingOrderInfoId(orderInfoInput);
			
		} else {
			throw new CommonException(CommonError.INVALID_CUSTOMER_INFO_ID);
		}
	}
	
	@Override
	public void validateInputValue(OrderInfoInput orderInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			validateOrderInfoId(orderInfoInput);
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			validateOrderInfoId(orderInfoInput);
			
		} else {
			throw new CommonException(CommonError.INVALID_CUSTOMER_INFO_ID);
		}
	}
	
	/**
	 * check missing fields
	 */
	private void checkMissingOrderInfoId(OrderInfoInput orderInfoInput) throws CommonException {
		if (orderInfoInput.getOrderInfoId() == null) {
			throw new CommonException(CommonError.MISSING_ORDER_INFO_ID);
		}
	}
	
	/**
	 * validate fields
	 */
	private void validateOrderInfoId(OrderInfoInput orderInfoInput) throws CommonException {
		OrderInfo orderInfo = orderInfoService.getActive(orderInfoInput.getOrderInfoId());
		if (orderInfo == null) {
			throw new CommonException(CommonError.MISSING_ORDER_INFO_ID);
		}
	}


}
