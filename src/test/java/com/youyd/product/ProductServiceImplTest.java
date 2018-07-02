package com.youyd.product;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.youyd.product.bean.ProductInfo;
import com.youyd.product.dto.CartDTO;
import com.youyd.product.service.ProductService;

@Component
public class ProductServiceImplTest extends ProductApplicationTests {

	@Autowired
	private ProductService productService;
	
	@Test
	public void testFindUpAll() {
		List<ProductInfo> productList = productService.findUpAll();
		Assert.assertTrue(productList.size()>0);
	}

	@Test
	public void testFindList() {
		List<ProductInfo> productList = productService.findList(Arrays.asList("157875196366160022","157875227953464068"));
		Assert.assertTrue(productList.size()>0);
	}
	@Test
	public void testDesreseStock() {
		CartDTO cartDTO=new CartDTO("157875196366160022", 2);
		productService.desreseStock(Arrays.asList(cartDTO));
	}

}
