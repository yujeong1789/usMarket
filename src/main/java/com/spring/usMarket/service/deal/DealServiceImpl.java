package com.spring.usMarket.service.deal;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.usMarket.dao.deal.DealDao;
import com.spring.usMarket.dao.product.ProductDao;
import com.spring.usMarket.domain.deal.DealInsertDto;

@Service
public class DealServiceImpl implements DealService{
	private static final Logger logger = LoggerFactory.getLogger(DealService.class);
	
	@Autowired DealDao dealDao;
	@Autowired ProductDao productDao;
	
	public String getResult(int rowCnt) {
		return rowCnt == 1 ? "OK" : "NOT_OK";
	}
	
	@Override
	@Transactional(rollbackFor = SQLException.class)
	public boolean addDeal(DealInsertDto dto, String isUpdate) throws Exception {
		int cnt = 0;
		int result = 0;
		// 주소 업데이트 체크시 수행
		if(isUpdate.equals("Y") || isUpdate == "Y") {
			int updateAddressCnt = dealDao.updateAddress(dto.getCustomer_zipcode(), dto.getCustomer_address(), dto.getCustomer_address_detail(), dto.getCustomer_no());
			cnt++;
			result += updateAddressCnt;
			logger.info("회원 주소 업데이트 결과 = {}", getResult(updateAddressCnt));
		}
		
		// 거래내역 insert
		int insertDealCnt = dealDao.insertDeal(dto);
		cnt++;
		result += insertDealCnt;
		logger.info("거래내역 등록 결과 = {}", getResult(insertDealCnt));
		
		// 해당 상품 판매완료 처리
		int modifyProductCnt = productDao.updateProductState(3, dto.getSeller_no().toString(), dto.getProduct_no().toString());
		cnt++;
		result += modifyProductCnt;
		logger.info("상품 판매완료 처리 결과 = {}", getResult(modifyProductCnt));
		
		return cnt==result ? true : false;
	}


}