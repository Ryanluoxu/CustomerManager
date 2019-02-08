package io.ryanluoxu.customerManager.controller.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import io.ryanluoxu.customerManager.base.util.ClassUtil;
import io.ryanluoxu.customerManager.controller.BaseController;
import io.ryanluoxu.customerManager.service.AuditTrailService;
import io.ryanluoxu.customerManager.service.CompanyInfoService;
import io.ryanluoxu.customerManager.service.ProductInfoService;
import io.ryanluoxu.customerManager.validator.CompanyInfoValidator;
import io.ryanluoxu.customerManager.validator.CustomerInfoValidator;
import io.ryanluoxu.customerManager.validator.ProductInfoValidator;

public abstract class BaseControllerImpl<T, TVO, TInput> implements BaseController<T, TVO, TInput> {

	@SuppressWarnings("rawtypes")
	protected Class tClass;
	@SuppressWarnings("rawtypes")
	protected Class tVOClass;
	@SuppressWarnings("rawtypes")
	protected Class tInputClass;

	@Autowired
	protected AuditTrailService auditTrailService;
	@Autowired
	protected CompanyInfoService companyInfoService;
	@Autowired
	protected ProductInfoService productInfoService;
	
	@Autowired
	protected CompanyInfoValidator companyInfoValidator;
	@Autowired
	protected ProductInfoValidator productInfoValidator;
	@Autowired
	protected CustomerInfoValidator customerInfoValidator;

	
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

	@SuppressWarnings("unchecked")
	protected TInput convertToInput(T t) {
		TInput tInput = null;
		try {
			tInput = (TInput) tInputClass.newInstance();
			BeanUtils.copyProperties(t, tInput);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return tInput;
	}

}
