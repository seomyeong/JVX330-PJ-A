<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signCafe</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/common.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/menu/menuPage.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/menuPage.js"
	defer="defer"></script>

</head>
<body>
	<h1>SIGN CAFE</h1>
	<section id="menuListWrap">
		<h2 class="hidden">카페 메뉴</h2>
		<div class="menuWrap">
			<article id="titleMenu">
				<h3 class="hidden">카테고리</h3>
				<p>COFFEE</p>
				<P>NON_COFFEE</P>
				<P>FOOD</P>
			</article>

			<article id="coffee" class="categoryArticle">
				<h3 class="hidden">커피</h3>
				<c:forEach items="${menuInfoList}" var="menuInfoList">
					<c:if test="${menuInfoList.category eq 'COFFEE'}">
						<div class="eachMenu">
							<img
								src="<%=request.getContextPath()%>/${menuInfoList.menuImgPath }"
								class="menuImg">
							<p id="menuName">${menuInfoList.menuName}</p>
							<p>${menuInfoList.menuPrice}</p>
						</div>
					</c:if>
				</c:forEach>
			</article>
			<article id="nonCoffee" class="categoryArticle">
				<h3 class="hidden">논커피</h3>
				<c:forEach items="${menuInfoList}" var="menuInfoList">
					<c:if test="${menuInfoList.category eq 'NON_COFFEE'}">
						<div class="eachMenu">
							<img
								src="<%=request.getContextPath()%>${menuInfoList.menuImgPath }"
								class="menuImg">
							<p id="menuName">${menuInfoList.menuName}</p>
							<p>${menuInfoList.menuPrice}</p>
						</div>
					</c:if>
				</c:forEach>
			</article>
			<article id="food" class="categoryArticle">
				<h3 class="hidden">푸드</h3>
				<c:forEach items="${menuInfoList}" var="menuInfoList">
					<c:if test="${menuInfoList.category eq 'FOOD'}">
						<div class="eachMenu">
							<img
								src="<%=request.getContextPath()%>${menuInfoList.menuImgPath }"
								class="menuImg">
							<p id="menuName">${menuInfoList.menuName}</p>
							<p>${menuInfoList.menuPrice}</p>
						</div>
					</c:if>
				</c:forEach>
			</article>
		</div>
	</section>

	<section id="orderedList">
		<h2 class="hidden">장바구니</h2>
		<form action="checkUser" method="post" id="container">
			<p>총 주문 수량을 확인하세요.</p>
			<p>${sessionScope.errorMsg }</p>
			<input type="text" name="totalNum" id="totalNum"
				value="${sessionScope.totalNum}"> <input type="submit"
				value="결제하기" id="payment">

			<c:set var="i" value="1" />
			<c:forEach items="${sessionScope.cart}" var="order">
				<div id="eachCart${i}" class='commonCart'>
					<input type='text' name="name${i}" class='cartName'
						value="${order.menuInfo.menuName}">
					<div id='tempWrap'>
						<c:choose>
							<c:when
								test="${order.extraTemp_Price == 0.0}">
								<label for="hot${i}"> <input type='radio' id="hot${i}"
									class='temp' name="temp${i}" value='0' checked>HOT
								</label>
								<label for="cold${i}"> <input type='radio' id="cold${i}"
									class='temp' name="temp${i}" value='500'>COLD
								</label>
							</c:when>
							<c:otherwise>
								<label for="hot${i}"> <input type='radio' id="hot${i}"
									class='temp' name="temp${i}" value='0' checked>HOT
								</label>
								<label for="cold${i}"> <input type='radio' id="cold${i}"
									class='temp' name="temp${i}" value='500'>COLD
								</label>

							</c:otherwise>
							<c:when
								test="${order.extraTemp_Price == 500.0}">
								<label for="hot${i}"> <input type='radio' id="hot${i}"
									class='temp' name="temp${i}" value='0' checked>HOT
								</label>
								<label for="cold${i}"> <input type='radio' id="cold${i}"
									class='temp' name="temp${i}" value='500' checked>COLD
								</label>
							</c:when>
						</c:choose>
					</div>

					<div id='sizeWrap'>
						<c:choose>
							<c:when test="${order.extraSize_Price == 0.0}">
								<label for="small${i}"> <input type='radio' class='size'
									id="small${i}" name="size${i}" value='0' checked>S
								</label>
								<label for="midium${i}"> <input type='radio'
									class='size' id="midium${i}" name="size${i}" value='500'>M
								</label>
								<label for="large${i}"> <input type='radio' class='size'
									id="large${i}" name="size${i}" value='1000'>L
								</label>
							</c:when>

							<c:when test="${order.extraSize_Price == 500.0}">
								<label for="small${i}"> <input type='radio' class='size'
									id="small${i}" name="size${i}" value='0'>S
								</label>
								<label for="midium${i}"> <input type='radio'
									class='size' id="midium${i}" name="size${i}" value='500'
									checked>M
								</label>
								<label for="large${i}"> <input type='radio' class='size'
									id="large${i}" name="size${i}" value='1000'>L
								</label>
							</c:when>

							<c:when test="${order.extraSize_Price == 1000.0}">
								<label for="small${i}"> <input type='radio' class='size'
									id="small${i}" name="size${i}" value='0'>S
								</label>
								<label for="midium${i}"> <input type='radio'
									class='size' id="midium${i}" name="size${i}" value='500'>M
								</label>
								<label for="large${i}"> <input type='radio' class='size'
									id="large${i}" name="size${i}" value='1000' checked>L
								</label>
							</c:when>
						</c:choose>
					</div>

					<div id='numWrap'>
						<input type='text' class='num' name="count${i}" value='1'>
					</div>
					<fmt:parseNumber var="totalPrice" value="${order.totalPrice div 1}"
						integerOnly="true" />
					<input type='text' name="price${i}" class='price'
						value=${totalPrice}> <a href='#' class='remove'> X </a>
				</div>
				<c:set var="i" value="${i + 1}" />
			</c:forEach>
		</form>
		<a href="<%=request.getContextPath()%>/index.jsp" id="goToIndex">메인으로</a>
	</section>
</body>
</html>