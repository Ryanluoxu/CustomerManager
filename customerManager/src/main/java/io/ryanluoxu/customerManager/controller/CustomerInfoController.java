package io.ryanluoxu.customerManager.controller;

import java.util.List;

import io.ryanluoxu.customerManager.bean.input.CustomerInfoInput;
import io.ryanluoxu.customerManager.bean.vo.CustomerInfoVO;
import io.ryanluoxu.customerManager.exception.CustomerInfoException;

public interface CustomerInfoController {

	void validateInputForAdd(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	void validateInputForEdit(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	void validateInputForDelete(CustomerInfoInput customerInfoInput) throws CustomerInfoException;

	CustomerInfoVO add(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	CustomerInfoVO update(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	CustomerInfoVO delete(CustomerInfoInput customerInfoInput) throws CustomerInfoException;
	List<CustomerInfoVO> findAll() throws CustomerInfoException;
}
