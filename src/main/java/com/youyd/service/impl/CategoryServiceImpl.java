package com.youyd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.youyd.bean.ProductCategory;
import com.youyd.repository.ProductCategoryRepository;
import com.youyd.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ProductCategoryRepository categoryRepository;
	
	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType) {
		return categoryRepository.findByCategoryTypeIn(categoryType);
	}

}
