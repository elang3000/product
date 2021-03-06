package com.youyd.product.enums;

/**
 * 商品上下架状态
 * @author youyd
 *
 */

public enum ProductStatusEnum {
	
	UP(0,"在架"),
	DOWN(1,"下架"),
	;


	private Integer code;
	
	private String message;
	
	private ProductStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	
	
	
	
}
