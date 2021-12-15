<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignCafe</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/common.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/menu/payment.css">
</head>
<body>
	<jsp:include page="/resources/incl/signCafeIncl.jsp"></jsp:include>
	<div id="patmentWrap">
		<form action="orderSheet" method="POST">
			<table id="cardWrap">
				<tr class="cardInfo">
					<th>카드사 선택</th>
					<td><select name="creditCard">
							<option value="삼성카드">삼성카드</option>
							<option value="국민카드">국민카드</option>
							<option value="농협카드">농협카드</option>
							<option value="비씨카드">비씨카드</option>
							<option value="신한카드">신한카드</option>
					</select></td>
				</tr>
				<tr class="cardNum">
					<th>카드번호</th>
					<td><input type="text" name="cardNum" pattern="[0-9]+"
						maxlength="16" minlength="16" required></td>
				</tr>

				<c:choose>
					<c:when test="${user.mileage eq 0}">
						<tr class="userMileage">
							<th>보유 마일리지</th>
							<td><input type="text" name="mileage" readonly="readonly"
								value="0"></td>
						</tr>
						<tr class="mileageUse">
							<th>마일리지 사용</th>
							<td><input type="text" name="amount" pattern="[0-9]+"
								readonly value="0"></td>
						</tr>
					</c:when>

					<c:otherwise>
						<tr class="userMileage">
							<th>보유 마일리지</th>
							<td><input type="text" name="mileage" readonly="readonly"
								value=${user.mileage}></td>
						</tr>
						<tr class="mileageUse">
							<th>마일리지 사용</th>
							<td><input type="text" name="amount" pattern="[0-9]+" value="0"></td>
						</tr>
					</c:otherwise>
				</c:choose>


				<tr class="totalPrice">
					<th>총 결제금액</th>
					<td><input type="text" name="orderPrice" value="${orderPrice}"></td>
				</tr>
			</table>

			<div id="paymentBtn">
				<a href="<%=request.getContextPath()%>/menuService/menuPage">주문취소</a>
				<input type="submit" value="결제">
			</div>
		</form>
	</div>
</body>
</html>