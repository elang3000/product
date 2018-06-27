package com.youyd.product.service;

import java.util.List;

import com.youyd.product.bean.ProductCategory;

public interface CategoryService {
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
