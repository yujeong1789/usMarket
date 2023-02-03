package com.spring.usMarket.deal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.usMarket.deal.service.DealService;

@Controller
@RequestMapping("/deal")
public class DealController {
	private static final Logger logger = LoggerFactory.getLogger(DealController.class);
	
	@Autowired
	DealService dealService;

	@GetMapping("/complete")
	public void complete (@ModelAttribute String deal_no) {
		logger.info("deal_no = {}", deal_no);
	}
}