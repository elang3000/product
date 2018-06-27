package com.youyd.product.service;

import java.util.List;

import com.youyd.product.bean.ProductInfo;

public interface ProductService {
	/**
	 * 查询所有在架商品列表
	 * @return
	 */
	List<ProductInfo> findUpAll();
}
