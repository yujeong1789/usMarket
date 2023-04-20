<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>

<div class="mypage_content">

<c:if test="${category == 'productList' || category == 'bookmarkList'}"> <!-- Product, Bookmark -->

	<div class="sub-title">
		<div></div>
		<div class="dropdown-container">
			<div class="dropdown order-dropdown">
				<span>정렬</span>
				<div class="dropdown-content">
					<ul>
						<li class="order-selected" data-order="regdate_desc">등록 최신순</li>
						<li data-order="regdate">등록 오래된순</li>
						<li data-order="view_desc">조회 많은순</li>
						<li data-order="view">조회 적은순</li>							
					</ul>
				</div>
			</div>
			<div class="dropdown condition-dropdown">
				<span>판매상태</span>
				<div class="dropdown-content">
					<ul>
						<li class="condition-selected" data-condition="0">전체</li>					
						<li data-condition="1">판매중</li>					
						<li data-condition="2">예약중</li>					
						<li data-condition="3">판매완료</li>					
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<input class="mode" type="hidden" value="${category}">
	
	<div class="content_list">
		<c:if test="${! empty pageList }">
			<div class="product__area">
				<c:forEach var="product" items="${pageList }" varStatus="status">
				<div class="product__box">
					<div class="product__img">
						<a href="<c:url value='/product/info?product_no=${product.PRODUCT_NO}' />"> 
							<c:if test="${product.PRODUCT_STATE_NO == 2}">
								<img class="product__img__top" src="${pageContext.request.contextPath}/resources/customer/img/product/reserve.png">
							</c:if>
							<c:if test="${product.PRODUCT_STATE_NO == 3}">
								<img class="product__img__top" src="${pageContext.request.contextPath}/resources/customer/img/product/complete.png">
							</c:if>
							<img src="https://usmarket.s3.ap-northeast-2.amazonaws.com/${product.PRODUCT_IMG_PATH}">
						</a>
					</div>
					<div class="product__info__1">
						<div class="product__title">
							<a href="<c:url value='/product/info?product_no=${product.PRODUCT_NO}' />">
								<c:out value="${product.PRODUCT_NAME }" />
							</a>
						</div>
						<div class="product__info__2">
							<div class="product__price">
								<span><fmt:formatNumber value="${product.PRODUCT_PRICE}" pattern="#,###"/></span>
							</div>
							<div class="product__regdate">
								<fmt:formatDate value="${product.PRODUCT_REGDATE }" pattern="yyyy년 MM월 dd일 HH:mm"/>
							</div>
							<div class="info-view">
								<img src="<c:url value='/resources/customer/img/view.png'/>">
							<span>${product.PRODUCT_VIEW }</span>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
			
			<div class="paging__container">
				<c:if test="${ph.totalCnt != null}">
					<c:if test="${ph.showPrev }">
						<div class="paging-prev">&lt;&lt;</div>
					</c:if>
					<c:forEach var="i" begin="${ph.beginPage }" end="${ph.endPage }">
						<div class="paging-box ${i eq ph.sc.page ? 'current-page' : 'not-current-page' }">
							<input id="pageValue" type="hidden" value="${i }">
							${i}
						</div>
					</c:forEach>
					<c:if test="${ph.showNext }">
						<div class="paging-next">&gt;&gt;</div>
					</c:if>
				</c:if>
			</div> <!-- paging__container -->
		</c:if>
		
		<c:if test="${empty pageList }">
			<div class="no__item">등록된 상품이 없습니다.</div> <!-- 이미지 만들 것 -->				
		</c:if>
	</div>
</c:if>

<c:if test="${category == 'reviewList'}"> <!-- Review -->
	<div class="sub-title">
		<div></div>
		<div class="dropdown-container">
			<div class="dropdown order-dropdown">
				<span>정렬</span>
				<div class="dropdown-content">
					<ul>
						<li class="order-selected" data-order="regdate_desc">등록 최신순</li>
						<li data-order="regdate">등록 오래된순</li>
						<li data-order="view_desc">조회 많은순</li>
						<li data-order="view">조회 적은순</li>							
					</ul>
				</div>
			</div>
			<div class="dropdown condition-dropdown">
				<span>판매상태</span>
				<div class="dropdown-content">
					<ul>
						<li class="condition-selected" data-condition="0">전체</li>					
						<li data-condition="1">판매중</li>					
						<li data-condition="2">예약중</li>					
						<li data-condition="3">판매완료</li>					
					</ul>
				</div>
			</div>
		</div>
	</div>

	<input class="mode" type="hidden" value="${category}">
	
	<div class="content_list">
		<c:if test="${empty pageList }">
			<div class="empty">
				<span>리뷰내역이 존재하지 않습니다.</span>
			</div>
		</c:if>
		<c:if test="${! empty pageList }">
			<div class="review__area">
				<ul>
					<c:forEach var="review" items="${pageList }">
						<li data-no="${review.DEAL_NO }" onclick="getDealInfo(this)">
							<div class="review-left">
								<img class="seller-img" src="<c:url value='${review.MEMBER_IMAGE }' />">
							</div>
							<div class="review-right">
								<span>${review.PRODUCT_NAME }</span>
								<span>${review.REVIEW_CONTENT }</span>
								<span>${review.MEMBER_NICKNAME }</span>
								<span><fmt:formatDate value="${review.DEAL_START_DATE }" pattern="yyyy.MM.dd (a HH:mm)"/></span>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			
			<div class="paging__container">
				<c:if test="${ph.totalCnt != null}">
					<c:if test="${ph.showPrev }">
						<div class="paging-prev">&lt;&lt;</div>
					</c:if>
					<c:forEach var="i" begin="${ph.beginPage }" end="${ph.endPage }">
						<div class="paging-box ${i eq ph.sc.page ? 'current-page' : 'not-current-page' }">
							<input id="pageValue" type="hidden" value="${i }">
							${i}
						</div>
					</c:forEach>
					<c:if test="${ph.showNext }">
						<div class="paging-next">&gt;&gt;</div>
					</c:if>
				</c:if>
			</div> <!-- paging__container -->
		</c:if>
		
		<c:if test="${empty pageList }">
			<div class="no__item">등록된 상품이 없습니다.</div> <!-- 이미지 만들 것 -->				
		</c:if>
	</div>
</c:if>
</div>



</html>