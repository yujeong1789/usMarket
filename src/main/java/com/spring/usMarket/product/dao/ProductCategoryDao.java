package com.spring.usMarket.product.dao;

import java.util.List;
import java.util.Map;

import com.spring.usMarket.product.domain.ProductCategoryDto;

public interface ProductCategoryDao {
	List<Map<String, Object>> searchProductCategory1() throws Exception;
	List<ProductCategoryDto> searchProductCategory2(Integer product_category1_no) throws Exception;
}
