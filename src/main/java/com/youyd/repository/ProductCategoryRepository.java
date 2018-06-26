package com.youyd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youyd.bean.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String>{
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
