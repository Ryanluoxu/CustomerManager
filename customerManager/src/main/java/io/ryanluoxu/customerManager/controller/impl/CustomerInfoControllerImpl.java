package io.ryanluoxu.customerManager.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ryanluoxu.customerManager.base.constant.ActionTypeConstant;
import io.ryanluoxu.customerManager.base.constant.CustomerInfoConstant;
import io.ryanluoxu.customerManager.base.exception.CommonException;
import io.ryanluoxu.customerManager.bean.entity.CustomerInfo;
import io.ryanluoxu.customerManager.bean.input.CustomerInfoInput;
import io.ryanluoxu.customerManager.bean.vo.CustomerInfoVO;
import io.ryanluoxu.customerManager.controller.CustomerInfoController;
import io.ryanluoxu.customerManager.service.CustomerInfoService;
import io.ryanluoxu.customerManager.validator.CustomerInfoValidator;

@Service
public class CustomerInfoControllerImpl extends BaseControllerImpl<CustomerInfo, CustomerInfoVO, CustomerInfoInput> implements CustomerInfoController {

	@Autowired
	private CustomerInfoValidator customerInfoValidator;

	@Autowired
	private CustomerInfoService customerInfoService;

	@Override
	public CustomerInfoVO add(CustomerInfoInput customerInfoInput) {
		CustomerInfoVO customerInfoVO = convertToVO(customerInfoService.add(convertToBean(customerInfoInput)));
		auditTrailService.add(ActionTypeConstant.ACTION_TYPE_ADD, customerInfoVO.toString());
		return customerInfoVO;
	}

	@Override
	public CustomerInfoVO delete(CustomerInfoInput customerInfoInput) {
		CustomerInfo customerInfo = customerInfoService.getById(customerInfoInput.getCustomerInfoId());
		customerInfo.setStatus(CustomerInfoConstant.STATUS_INACTIVE);
		CustomerInfoVO customerInfoVO = convertToVO(customerInfoService.update(customerInfo));
		auditTrailService.add(ActionTypeConstant.ACTION_TYPE_DELETE, customerInfoVO.toString());
		return customerInfoVO;
	}

	@Override
	public CustomerInfoVO update(CustomerInfoInput customerInfoInput) {
		CustomerInfo customerInfo = customerInfoService.getById(customerInfoInput.getCustomerInfoId());
		customerInfo.setAddress(customerInfoInput.getAddress());
		customerInfo.setCompanyName(customerInfoInput.getCompanyName());
		customerInfo.setContactFax(customerInfoInput.getContactFax());
		customerInfo.setContactMobile(customerInfoInput.getContactMobile());
		customerInfo.setContactOffice(customerInfoInput.getContactOffice());
		customerInfo.setCountry(customerInfoInput.getCountry());
		customerInfo.setCustomerName(customerInfoInput.getCustomerName());
		customerInfo.setEmail(customerInfoInput.getEmail());
		customerInfo.setFunction(customerInfoInput.getFunction());
		CustomerInfoVO customerInfoVO = convertToVO(customerInfoService.update(customerInfo));
		auditTrailService.add(ActionTypeConstant.ACTION_TYPE_UPDATE, customerInfoVO.toString());
		return customerInfoVO;
	}

	@Override
	public List<CustomerInfoVO> findAll() {
		List<CustomerInfoVO> customerInfoVOs = new ArrayList<>();
		List<CustomerInfo> customerInfos = customerInfoService.findActive();
		for (CustomerInfo customerInfo : customerInfos) {
			CustomerInfoVO customerInfoVO = convertToVO(customerInfo);
			customerInfoVOs.add(customerInfoVO);
		}
		return customerInfoVOs;
	}

	@Override
	public void validate(CustomerInfoInput input, String actionType) throws CommonException {
		customerInfoValidator.validateMandatoryFields(input, actionType);
		customerInfoValidator.validateInputValue(input, actionType);
	}


}
