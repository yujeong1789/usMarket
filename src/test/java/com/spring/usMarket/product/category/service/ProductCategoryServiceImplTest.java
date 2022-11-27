package com.spring.usMarket.product.category.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring.usMarket.product.category.domain.ProductCategoryDto;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ProductCategoryServiceImplTest {

	@Autowired
	private ProductCategoryService service;
	
	@Test
	public void searchProductCategory1Test() throws Exception{
		List<ProductCategoryDto>list=service.searchProductCategory1();
		for(ProductCategoryDto dto:list) {
			System.out.println(dto.getProduct_category1_no()+"\t"+dto.getProduct_category1_name());
		}
		assertEquals(list.size(), 15);
	}

}
