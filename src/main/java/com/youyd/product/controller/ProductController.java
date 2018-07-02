package com.youyd.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youyd.product.bean.ProductCategory;
import com.youyd.product.bean.ProductInfo;
import com.youyd.product.dto.CartDTO;
import com.youyd.product.service.CategoryService;
import com.youyd.product.service.ProductService;
import com.youyd.product.utils.ResultVOUtil;
import com.youyd.product.vo.ProductInfoVO;
import com.youyd.product.vo.ProductVO;
import com.youyd.product.vo.ResultVO;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	/**
	 * 1.查询所有在架的商品 2.获取类目type列表 3.查询类目 4.构造数据
	 */
	@RequestMapping("/list")
	public ResultVO<ProductVO> list() {
		//1.查询所有在架的商品
		List<ProductInfo> productInfoList = productService.findUpAll();
		// 2.获取类目type列表
		List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType)
				.collect(Collectors.toList());
		//3.查询类目
		List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
		
		//4.构造数据
		List<ProductVO> productVOList=new ArrayList<>();
		for(ProductCategory category:categoryList) {
			ProductVO productVO=new ProductVO();
			productVO.setCategoryName(category.getCategoryName());
			productVO.setCategoryType(category.getCategoryType());
			
			List<ProductInfoVO> productInfoVOList=new ArrayList<>();
			for (ProductInfo productInfo : productInfoList) {
				if(productInfo.getCategoryType().equals(category.getCategoryType())) {
					ProductInfoVO productInfoVO=new ProductInfoVO();
					BeanUtils.copyProperties(productInfo, productInfoVO);
					productInfoVOList.add(productInfoVO);
				}
			}
			productVO.setProductInfoVOList(productInfoVOList);
			productVOList.add(productVO);
		}
		
		return ResultVOUtil.success(productVOList);
	}
	
	/**
	 * 获取商品列表(给订单服务用的)
	 * @param productIdList
	 * @return
	 */
	@PostMapping("/listForOrder")
	public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){
		return productService.findList(productIdList);
	}
	
	
	@PostMapping("/decreaseStock")
	public void decreaseStock(@RequestBody List<CartDTO> cartDTOList) {
		productService.desreseStock(cartDTOList);
	}
}
