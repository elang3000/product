package com.youyd.product;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.youyd.repository.ProductCategoryRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

	
	private ProductCategoryRepository categoryRepository;
	@Test
	public void testFindByCategoryTypeIn() {
		categoryRepository.findByCategoryTypeIn(Arrays.asList(11,12));
	}

}
