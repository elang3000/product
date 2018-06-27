package com.youyd.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youyd.product.bean.ProductCategory;
import com.youyd.product.repository.ProductCategoryRepository;
import com.youyd.product.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ProductCategoryRepository categoryRepository;
	
	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType) {
		return categoryRepository.findByCategoryTypeIn(categoryType);
	}

}
