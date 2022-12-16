<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="hero">
<div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="<c:url value='/'/>"><img src="<c:url value='/resources/customer/img/logo.png'/>" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="<c:url value='/product/list'/>" id="searchForm">
								<input type="text" name="keyword" id="searchKeyword" placeholder="상품명 또는 태그로 원하는 상품을 검색하세요">
								<button type="submit" id="submit" class="site-btn">SEARCH</button>
							</form>
						</div>
						<div class="hero__search__mypage">
							<a href="#">판매하기</a>
							<span>|</span>
							<a href="#">내상점</a>
							<span>|</span>
							<a href="#">채팅</a>
						</div>
					</div> <!-- hero__search -->
				</div>
            </div>
        </div>
        
        
        <div class="container">
            <div class="row">
        		<div class="index__visual">
	            	<div class="col-lg-3">
	                    <div class="hero__categories">
							<div class="hero__categories__all">
	                        	<img src="<c:url value='/resources/customer/img/categories/line1.png' />">
	                            <span>전체 카테고리</span>
	                        </div>
	                        <ul>
	                        <c:forEach var="productCategoryDto" items="${categoryList }">
	                            <li>
	                            	<a href='<c:url value="/product/list?category1=${productCategoryDto.product_category1_no}" />'>
	                            		${productCategoryDto.product_category1_name }
	                            	</a>
	                            </li>
	                        </c:forEach>
	                        </ul>
	                    </div> <!-- hero__categories__all -->
					</div>
				</div>
			</div>
		</div>
		
		
    </section>
    
<script type="text/javascript">
	const searchForm = document.getElementById('searchForm');
	searchForm.addEventListener('submit', function(e){
		if(document.getElementById('searchKeyword').value.length < 2){
			alert("검색어는 두 글자 이상 입력해 주세요.");
			e.preventDefault();
		};
	});
</script>