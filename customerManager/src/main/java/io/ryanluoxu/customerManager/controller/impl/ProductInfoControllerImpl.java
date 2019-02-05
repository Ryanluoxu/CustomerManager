package io.ryanluoxu.customerManager.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.bean.entity.ProductInfo;
import io.ryanluoxu.customerManager.bean.input.ProductInfoInput;
import io.ryanluoxu.customerManager.bean.vo.ProductInfoVO;
import io.ryanluoxu.customerManager.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.controller.ProductInfoController;
import io.ryanluoxu.customerManager.exception.CommonError;
import io.ryanluoxu.customerManager.exception.CommonException;
import io.ryanluoxu.customerManager.exception.ProductInfoException;
import io.ryanluoxu.customerManager.service.ProductInfoService;
import io.ryanluoxu.customerManager.validator.ProductInfoValidator;

@Service
public class ProductInfoControllerImpl extends BaseControllerImpl<ProductInfo, ProductInfoVO, ProductInfoInput> implements ProductInfoController {
	
	@Autowired
	private ProductInfoValidator productInfoValidator;

	@Autowired
	private ProductInfoService productInfoService;

	@Override
	public List<ProductInfoVO> findAll() throws ProductInfoException {
		List<ProductInfoVO> productInfoVOs = new ArrayList<>();
		List<ProductInfo> productInfos = productInfoService.findActive();
		for (ProductInfo productInfo : productInfos) {
			ProductInfoVO productInfoVO = convertToVO(productInfo);
			productInfoVOs.add(productInfoVO);
		}
		return productInfoVOs;
	}


	@Override
	public ProductInfoVO add(ProductInfoInput productInfoInput) throws ProductInfoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductInfoVO update(ProductInfoInput productInfoInput) throws ProductInfoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validateInput(ProductInfoInput productInfoInput, String actionType) throws CommonException {
		if (ActionTypeConstant.ACTION_TYPE_ADD.equals(actionType)) {
			productInfoValidator.validateMandatoryFields(productInfoInput, actionType);
			
		} else if (ActionTypeConstant.ACTION_TYPE_UPDATE.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_FIND.equals(actionType)) {
			
		} else if (ActionTypeConstant.ACTION_TYPE_DELETE.equals(actionType)) {
			
		} else {
			throw new CommonException(CommonError.INVALID_CUSTOMER_INFO_ID);
		}
		
	}




}
