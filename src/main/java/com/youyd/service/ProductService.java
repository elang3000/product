package com.youyd.service;

import java.util.List;

import com.youyd.bean.ProductInfo;

public interface ProductService {
	/**
	 * 查询所有在架商品列表
	 * @return
	 */
	List<ProductInfo> findUpAll();
}
