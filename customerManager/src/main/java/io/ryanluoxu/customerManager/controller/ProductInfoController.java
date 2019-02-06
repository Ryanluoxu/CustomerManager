package io.ryanluoxu.customerManager.controller;

import java.util.List;

import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.base.exception.ProductInfoException;
import io.ryanluoxu.customerManager.bean.input.ProductInfoInput;
import io.ryanluoxu.customerManager.bean.vo.ProductInfoVO;

public interface ProductInfoController {

	void validateInput(ProductInfoInput productInfoInput, String actionType) throws CommonException;

	ProductInfoVO add(ProductInfoInput productInfoInput) throws ProductInfoException;
	ProductInfoVO update(ProductInfoInput productInfoInput) throws ProductInfoException;
	List<ProductInfoVO> findAll() throws ProductInfoException;

	ProductInfoVO delete(ProductInfoInput productInfoInput);
}
