package com.youyd.product;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.youyd.product.bean.ProductInfo;
import com.youyd.product.repository.ProductInfoRepository;


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
	
	@Test
	public void testfindByProductIdIn() throws Exception{
		
		List<ProductInfo> products = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022","157875227953464068"));
		for (ProductInfo productInfo : products) {
			System.out.println(productInfo.getProductName());
		}
		Assert.assertTrue(products.size()>0);
	}

}
