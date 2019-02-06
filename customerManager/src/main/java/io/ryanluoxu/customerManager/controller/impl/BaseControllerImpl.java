package io.ryanluoxu.customerManager.controller.impl;

import org.springframework.beans.BeanUtils;

import io.ryanluoxu.customerManager.base.util.ClassUtil;
import io.ryanluoxu.customerManager.controller.BaseController;

public abstract class BaseControllerImpl<T, TVO, TInput> implements BaseController {

	@SuppressWarnings("rawtypes")
	protected Class tClass;

	@SuppressWarnings("rawtypes")
	protected Class tVOClass;

	@SuppressWarnings("rawtypes")
	protected Class tInputClass;

	public BaseControllerImpl() {
		this.tClass = ClassUtil.getTypeArguments(BaseControllerImpl.class, this.getClass()).get(0);
		this.tVOClass = ClassUtil.getTypeArguments(BaseControllerImpl.class, this.getClass()).get(1);
		this.tInputClass = ClassUtil.getTypeArguments(BaseControllerImpl.class, this.getClass()).get(2);
	}

	@SuppressWarnings("unchecked")
	protected TVO convertToVO(T t) {
		TVO tVO = null;
		try {
			tVO = (TVO) tVOClass.newInstance();
			BeanUtils.copyProperties(t, tVO);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return tVO;
	}

	@SuppressWarnings("unchecked")
	protected T convertToBean(TInput input) {
		T t = null;
		try {
			t = (T) tClass.newInstance();
			BeanUtils.copyProperties(input, t);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return t;
	}



}
