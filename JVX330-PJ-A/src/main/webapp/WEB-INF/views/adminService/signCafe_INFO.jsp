<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignCafe</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/admin/signCafe_INFO.css">
</head>
<body>
	<h1>관리자 페이지</h1>
	<article id="article1">
		<p class="caption">제품 정보</p>
		<div id="productWrap">
			<table id="product">
				<tr>
					<th>제품번호</th>
					<th>제품종류</th>
					<th>제품명</th>
					<th>가격</th>
					<th>판매량</th>
					<th>마일리지 사용량</th>
				</tr>
				<c:forEach items="${info.allMenuInfo}" var="allMenuInfo">
					<tr>
						<td>${allMenuInfo.menuNum}</td>
						<td>${allMenuInfo.category}</td>
						<td>${allMenuInfo.menuName}</td>
						<td>${allMenuInfo.menuPrice}</td>
						<td>${allMenuInfo.menuCount}</td>
						<td>${allMenuInfo.mileageCount}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</article>

	<article id="article2">
		<p class="caption">멤버쉽 가입유저 리스트</p>
		<div id="membershipWrap">
			<table id="membership">
				<tr>
					<th>등록번호</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>비밀번호</th>
					<th>마일리지</th>
					<th>가입일</th>
				</tr>
				<c:forEach items="${info.allUserInfo}" var="allUserInfo">
					<tr>
						<td>${allUserInfo.id}</td>
						<td>${allUserInfo.name}</td>
						<td>${allUserInfo.phone}</td>
						<td>********</td>
						<td>${allUserInfo.mileage}</td>
						<td>${allUserInfo.regDate}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</article>

	<article id=article3>
		<p class="caption">주문 내역</p>
		<div id="orderListWrap">
			<table id="orderList">
				<tr>
					<th>주문번호</th>
					<th>회원 구분(전화번호)</th>
					<th>제품명</th>
					<th>제품 사이즈</th>
					<th>제품 온도</th>
					<th>사용한 마일리지</th>
					<th>총 가격</th>
					<th>주문 일시</th>
				</tr>
				<c:forEach items="${info.allOrderedListInfo}"
					var="allOrderedListInfo">
					<tr>
						<td>${allOrderedListInfo.orderedList}</td>
						<td>${allOrderedListInfo.customerInfo}</td>
						<td>${allOrderedListInfo.menuInfo.menuName}</td>
						<td><c:choose>
								<c:when test="${allOrderedListInfo.extraSize_Price == 0}">
							S
						</c:when>
								<c:when test="${allOrderedListInfo.extraSize_Price == 500}">
							M
						</c:when>
								<c:when test="${allOrderedListInfo.extraSize_Price == 1000}">
							L
						</c:when>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${allOrderedListInfo.extraTemp_Price == 0}">
						Hot
					</c:when>
								<c:when test="${allOrderedListInfo.extraTemp_Price == 500}">
						Ice
					</c:when>
							</c:choose></td>
						<td>${allOrderedListInfo.usingMileage}</td>
						<td>${allOrderedListInfo.totalPrice}</td>
						<td>${allOrderedListInfo.orderedDate}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</article>

	<div id="sellByProduct">
		<p class="caption">기타 기능</p>
		<p># 제품별 판매 금액</p>
		<select id="productSelectList">
			<option value="0.0 원">항목을 선택해주세요.</option>
			<c:forEach items="${info.allMenuInfo}" var="allMenuInfo">
				<option
					value="${allMenuInfo.menuPrice * allMenuInfo.menuCount - allMenuInfo.mileageCount} 원 ">${allMenuInfo.menuName}</option>
			</c:forEach>
		</select> <span id="productSelectNum">0.0 원</span>

		<p id="netSalesCap"># 매장 순매출</p>
		<c:forEach items="${info.allMenuInfo}" var="allMenuInfo">
				<c:set var="netSales" value="${netSales = netSales + (allMenuInfo.menuPrice * allMenuInfo.menuCount - allMenuInfo.mileageCount)}"/>
		</c:forEach>
		<span id="netSales">${netSales} 원</span>
		
		<p id="totalSalesCap"># 매장 총매출</p>
		<c:forEach items="${info.allMenuInfo}" var="allMenuInfo">
				<c:set var="totalSales" value="${totalSales = totalSales + (allMenuInfo.menuPrice * allMenuInfo.menuCount) }"/>
		</c:forEach>
		<span id="totalSales">${totalSales} 원</span>
	</div>

	<a href="../index.jsp" id="goMain">메인 메뉴로</a>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/signCafe_INFO.js"></script>
</body>
</html>