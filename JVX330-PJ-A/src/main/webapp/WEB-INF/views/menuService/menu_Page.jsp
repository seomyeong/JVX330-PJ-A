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
								src="<%=request.getContextPath()%>/${menuInfoList.menuImgPath }" class="menuImg">
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
								src="<%=request.getContextPath()%>${menuInfoList.menuImgPath }" class="menuImg">
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
								src="<%=request.getContextPath()%>${menuInfoList.menuImgPath }" class="menuImg">
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
            <input type="text" name="totalNum" id="totalNum">
            <input type="submit" value="결제하기" id="payment">
        </form>
        <a href="<%=request.getContextPath()%>/index.jsp" id="goToIndex">메인으로</a>
    </section>
</body>
</html>