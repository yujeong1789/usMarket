package com.spring.usMarket.product.service;

import java.util.List;
import java.util.Map;

import com.spring.usMarket.common.SearchCondition;
import com.spring.usMarket.product.domain.ProductCategoryDto;
import com.spring.usMarket.product.domain.ProductDto;
import com.spring.usMarket.product.domain.ProductPageHandler;

public interface ProductService {
	List<ProductCategoryDto> getProductCategory1() throws Exception;
	
	List<ProductCategoryDto> getProductCategory2(Integer product_category1_no) throws Exception;
	
	List<ProductDto> getMainProduct() throws Exception;
	
	List<ProductDto> getProductByCategory(ProductPageHandler ph) throws Exception;
}