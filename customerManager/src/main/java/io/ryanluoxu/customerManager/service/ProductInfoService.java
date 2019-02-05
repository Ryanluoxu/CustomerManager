package io.ryanluoxu.customerManager.service;

import java.util.List;

import io.ryanluoxu.customerManager.bean.entity.ProductInfo;

public interface ProductInfoService {
	ProductInfo add(ProductInfo productInfo);
	ProductInfo update(ProductInfo productInfo);
	ProductInfo deleteById(Long productInfoId);

	List<ProductInfo> findAll();
	List<ProductInfo> findActive();
	ProductInfo getById(Long productInfoId);
}
