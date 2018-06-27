package com.youyd.product;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.youyd.product.bean.ProductCategory;
import com.youyd.product.repository.ProductCategoryRepository;


@Component
public class ProductCategoryRepositoryTest extends ProductApplicationTests{

	@Autowired
	private ProductCategoryRepository categoryRepository;
	
	@Test
	public void testFindByCategoryTypeIn() {
		List<ProductCategory> categorys = categoryRepository.findByCategoryTypeIn(Arrays.asList(11,12));
		System.out.println(categorys);
	}

}
