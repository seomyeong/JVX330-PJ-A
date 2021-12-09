<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignCafe</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admin/signCafe_INFO.css">
</head>
<body>
	<table>
		<caption>제품 정보</caption>
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

	<table>
		<caption>멤버쉽 가입유저 리스트</caption>
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
				<td>${allUserInfo.passWd}</td>
				<td>${allUserInfo.mileage}</td>
				<td>${allUserInfo.regDate}</td>
			</tr>
		</c:forEach>
	</table>

	<table>
		<caption>주문 내역</caption>
		<tr>
			<th>주문번호</th>
			<th>회원 구분(전화번호)</th>
			<th>제품번호</th>
			<th>제품 사이즈</th>
			<th>제품 온도</th>
			<th>수량</th>
			<th>사용한 마일리지</th>
			<th>총 가격</th>
			<th>주문 일시</th>
		</tr>
		<c:forEach items="${info.allOrderedListInfo}" var="allOrderedListInfo">
			<tr>
				<td>${allOrderedListInfo.orderedList}</td>
				<td>${allOrderedListInfo.customerInfo}</td>
				<td>${allOrderedListInfo.menuInfo.menuNum}</td>
				<td><c:choose>
						<c:when test="${allOrderedListInfo.extraSize_Price == 0}">
							S
						</c:when>
						<c:when test="${allOrderedListInfo.extraSize_Price == 300}">
							M
						</c:when>
						<c:when test="${allOrderedListInfo.extraSize_Price == 500}">
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
				<td>${allOrderedListInfo.menuCount}</td>
				<td>${allOrderedListInfo.usingMileage}</td>
				<td>${allOrderedListInfo.totalPrice}</td>
				<td>${allOrderedListInfo.orderedDate}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="../index.jsp">메인 메뉴로</a>
</body>
</html>