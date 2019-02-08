package io.ryanluoxu.customerManager.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.constant.StatusConstant;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;
import io.ryanluoxu.customerManager.bean.entity.OrderInfo;
import io.ryanluoxu.customerManager.bean.entity.ProductInfo;
import io.ryanluoxu.customerManager.bean.input.OrderInfoInput;
import io.ryanluoxu.customerManager.bean.vo.OrderInfoVO;
import io.ryanluoxu.customerManager.controller.OrderInfoController;

@Service
public class OrderInfoControllerImpl extends BaseControllerImpl<OrderInfo, OrderInfoVO, OrderInfoInput> implements OrderInfoController {
	
	@Override
	public List<OrderInfoVO> findAll() {
		List<OrderInfoVO> orderInfoVOs = new ArrayList<>();
		List<OrderInfo> orderInfos = orderInfoService.findActive();
		for (OrderInfo orderInfo : orderInfos) {
			ProductInfo productInfo = productInfoService.getById(orderInfo.getProductInfoId());
			CustomerInfo customerInfo = customerInfoService.getById(orderInfo.getCustomerInfoId());
			OrderInfoVO orderInfoVO = convertToVO(orderInfo);
			orderInfoVO.setCustomerName(customerInfo.getCustomerName());
			orderInfoVO.setProductName(productInfo.getProductName());
			orderInfoVOs.add(orderInfoVO);
		}
		return orderInfoVOs;
	}

	@Override
	public OrderInfoVO add(OrderInfoInput orderInfoInput) {
		OrderInfoVO orderInfoVO = convertToVO(orderInfoService.add(convertToBean(orderInfoInput)));
		auditTrailService.add(ActionTypeConstant.ACTION_TYPE_ADD, orderInfoVO.toString());
		return orderInfoVO;
	}

	@Override
	public OrderInfoVO update(OrderInfoInput orderInfoInput) {
		OrderInfo orderInfo = orderInfoService.getById(orderInfoInput.getOrderInfoId());
		orderInfo.setCustomerInfoId(orderInfoInput.getCustomerInfoId());
		orderInfo.setProductInfoId(orderInfoInput.getProductInfoId());
		orderInfo.setPaymentMode(orderInfoInput.getPaymentMode());
		orderInfo.setProfit(orderInfoInput.getProfit());
		orderInfo.setQuantity(orderInfoInput.getQuantity());
		orderInfo.setUnitPrice(orderInfoInput.getUnitPrice());
		OrderInfoVO orderInfoVO = convertToVO(orderInfoService.update(orderInfo));
		auditTrailService.add(ActionTypeConstant.ACTION_TYPE_UPDATE, orderInfoVO.toString());
		return orderInfoVO;
	}

	@Override
	public OrderInfoVO delete(OrderInfoInput orderInfoInput) {
		OrderInfo orderInfo = orderInfoService.getById(orderInfoInput.getOrderInfoId());
		orderInfo.setStatus(StatusConstant.INACTIVE);
		OrderInfoVO orderInfoVO = convertToVO(orderInfoService.update(orderInfo));
		auditTrailService.add(ActionTypeConstant.ACTION_TYPE_DELETE, orderInfoVO.toString());
		return orderInfoVO;
	}

	@Override
	public void validate(OrderInfoInput input, String actionType) throws CommonException {
		orderInfoValidator.validateMandatoryFields(input, actionType);
		orderInfoValidator.validateInputValue(input, actionType);
	}

}
