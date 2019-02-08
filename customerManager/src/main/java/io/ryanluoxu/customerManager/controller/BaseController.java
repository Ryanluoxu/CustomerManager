package io.ryanluoxu.customerManager.controller;

import java.util.List;

import io.ryanluoxu.customerManager.base.exception.CommonException;

public interface BaseController<T, TVO, TInput> {

	void validate(TInput input, String actionType) throws CommonException;
	
	TVO add(TInput input) throws CommonException;
	
	TVO update(TInput input) throws CommonException;
	
	List<TVO> findAll() throws CommonException;

	TVO delete(TInput input);

}
