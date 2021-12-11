<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signCafe</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/common.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/menu/menuPage.css">

</head>
<body>
	<h1>SIGN CAFE</h1>
	<section id="menu">
		<h2 class="hidden">카페 메뉴</h2>
		<div class="menuWrap">
			<article id="category">
				<h3 class="hidden">카테고리</h3>
				<p>COFFEE</p>
				<P>NON_COFFEE</P>
				<P>FOOD</P>
			</article>

			<article id="coffee" class="categoryArticle">
				<h3 class="hidden">커피</h3>
				<c:forEach items="${menuInfoList}" var="menuInfoList">
					<c:if test="${menuInfoList.category eq 'COFFEE'}">
						<div class="menuRow">
							<img
								src="<%=request.getContextPath()%>${menuInfoList.menuImgPath }">
							<p class="">${menuInfoList.menuName}</p>
							<p class="">${menuInfoList.menuPrice}</p>
						</div>
					</c:if>
				</c:forEach>
			</article>
			<article id="nonCoffee" class="categoryArticle">
				<h3 class="hidden">논커피</h3>
				<c:forEach items="${menuInfoList}" var="menuInfoList">
					<c:if test="${menuInfoList.category eq 'NON_COFFEE'}">
						<div class="menuRow">
							<img
								src="<%=request.getContextPath()%>${menuInfoList.menuImgPath }">
							<p class="">${menuInfoList.menuName}</p>
							<p class="">${menuInfoList.menuPrice}</p>
						</div>
					</c:if>
				</c:forEach>
			</article>
			<article id="food" class="categoryArticle">
				<h3 class="hidden">푸드</h3>
				<c:forEach items="${menuInfoList}" var="menuInfoList">
					<c:if test="${menuInfoList.category eq 'FOOD'}">
						<div class="menuRow">
							<img
								src="<%=request.getContextPath()%>${menuInfoList.menuImgPath }">
							<p class="">${menuInfoList.menuName}</p>
							<p class="">${menuInfoList.menuPrice}</p>
						</div>
					</c:if>
				</c:forEach>
			</article>


			<article id="ordered">
				<h2 class="hidden">주문상품</h2>
				<div>
					<p>주문하신 상품을 확인하세요.</p>
				</div>
			</article>

		</div>
	</section>

</body>
</html>