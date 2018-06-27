package com.youyd.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youyd.product.bean.ProductInfo;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>{
	List<ProductInfo> findByProductStatus(Integer productStatus);
}
