package com.youyd.product.service;

import java.util.List;

import com.youyd.product.bean.ProductInfo;
import com.youyd.product.dto.CartDTO;

public interface ProductService {
	/**
	 * 查询所有在架商品列表
	 * @return
	 */
	List<ProductInfo> findUpAll();
	
	/**
	 * 查询商品列表
	 * @param productIdList
	 * @return
	 */
	List<ProductInfo> findList(List<String> productIdList);
	
	
	void desreseStock(List<CartDTO> cartDTOList);
}
