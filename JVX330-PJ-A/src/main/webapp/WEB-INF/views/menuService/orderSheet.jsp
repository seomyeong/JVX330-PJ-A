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
	href="<%=request.getContextPath()%>/resources/css/menu/orderSheet.css">
</head>
<body>
	<%-- <jsp:include page="/resources/incl/signCafeIncl.jsp"></jsp:include> --%>
	<h1>SIGN CAFE</h1>
	<p>주문이 성공적으로 완료되었습니다.</p>
	<table id="order">
		<caption>주문서</caption>
		<thead>
			<tr>
				<th>MenuName</th>
				<th>Ea</th>
				<th>OptionName</th>
				<th>OptionPrice</th>
				<th>TotalPrice</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cart}" var="orderedList">
				<tr>
					<td>${orderedList.menuInfo.menuName}</td>
					<td>1</td>
					<td><c:choose>
							<c:when test="${orderedList.extraTemp_Price eq 0.0}">

							</c:when>
							<c:otherwise>
									얼음 추가
								</c:otherwise>
						</c:choose> <c:choose>
							<c:when test="${orderedList.extraSize_Price eq 0.0}">
									기본 사이즈
								</c:when>
							<c:when test="${orderedList.extraSize_Price eq 500.0}">
									M 사이즈
								</c:when>
							<c:when test="${orderedList.extraSize_Price eq 1000.0}">
									L 사이즈
								</c:when>
						</c:choose></td>
					<td>${orderedList.extraSize_Price + orderedList.extraTemp_Price}</td>
					<td>${orderedList.totalPrice}</td>
				</tr>
			</c:forEach>
			<%-- 밑에는 test --%>
			<!-- <tr>
				<td>클래식 아메리카노</td>
				<td>1</td>
				<td>얼음 추가</td>
				<td>500</td>
				<td>7000</td>
			</tr>
			<tr>
				<td>바닐라빈 라떼</td>
				<td>1</td>
				<td>사이즈 M</td>
				<td>500</td>
				<td>8300</td>
			</tr>
			<tr>
				<td>벨벳 다크 모카 카푸치노</td>
				<td>1</td>
				<td>얼음 추가, 사이즈 M</td>
				<td>1000</td>
				<td>8500</td>
			</tr> -->
		</tbody>
		<tfoot>
			<tr>
				<td>사용한 마일리지</td>
				<td></td>
				<td></td>
				<td></td>
				<td>-${payment.amount} 원</td>
			</tr>
			<tr>
				<td>총 합계금액</td>
				<td></td>
				<td></td>
				<td></td>
				<td>${totalPrice - payment.amount} 원</td>
			</tr>
		</tfoot>
	</table>

	<p class="creditInfo">신용승인정보</p>
	<table id="creditInfo">
		<tr>
			<th>카 드 종 류 :</th>
			<td>${payment.creditCard}</td>
		</tr>
		<tr>
			<th>카 드 번 호 :</th>
			<td>${payment.cardNum}</td>
		</tr>
		<tr>
			<th>할 부 개 월 :</th>
			<td>일시불</td>
		</tr>
		<tr>
			<th>판 매 금 액 :</th>
			<td>${payment.orderPrice / 100 * 90}</td>
		</tr>
		<tr>
			<th>부 가 세 :</th>
			<td>${payment.orderPrice / 100 * 10}</td>
		</tr>
		<tr>
			<th>할 인 금액 :</th>
			<td>${payment.amount}</td>
		</tr>
		<tr>
			<th>승 인 금 액 :</th>
			<td>${totalPrice - payment.amount}</td>
		</tr>
		<tr>
			<th>적 립 금 액 :</th>
			<td>${totalPrice / 100 * 3}</td>
		</tr>
		<tr>
			<th>승 인 일 시 :</th>
			<td>${payRegDate}</td>
		</tr>
	</table>

	<a href="../Index">확인</a>
</body>
</html>