package com.youyd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youyd.bean.ProductCategory;
import com.youyd.bean.ProductInfo;
import com.youyd.service.CategoryService;
import com.youyd.service.ProductService;
import com.youyd.vo.ProductInfoVO;
import com.youyd.vo.ProductVO;
import com.youyd.vo.ResultVO;

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
		
		ResultVO resultVO=new ResultVO<>();
		resultVO.setData(productVOList);
		resultVO.setCode(0);
		resultVO.setMsg("成功");
		return resultVO;
	}
}
