package com.youyd.product;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.youyd.bean.ProductInfo;
import com.youyd.repository.ProductInfoRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

	@Autowired
	private ProductInfoRepository productInfoRepository;
	
	@Test
	public void testFindByProductStatus() {
		List<ProductInfo> products = productInfoRepository.findByProductStatus(0);
		Assert.assertTrue(products.size()>0);
	}

}
