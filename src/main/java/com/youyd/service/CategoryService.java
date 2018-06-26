package com.youyd.service;

import java.util.List;

import com.youyd.bean.ProductCategory;

public interface CategoryService {
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
