<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signCafe</title>
</head>
<body>
	<jsp:include page="/resources/incl/signCafeIncl.jsp"></jsp:include>
	<table>
		<tr>
			<th>카드사 선택</th>
			<td><select>
					<option value="삼성카드">삼성카드</option>
					<option value="국민카드">국민카드</option>
					<option value="농협카드">농협카드</option>
			</select></td>
		</tr>
		<tr>
			<th>카드번호</th>
			<td><input type="text"> <input type="text"> <input
				type="password"> <input type="password"></td>
		</tr>
		<tr>
			<th>보유 마일리지</th>
			<td><input type="text" readonly="readonly"></td>
		</tr>
		<tr>
			<th>마일리지 사용</th>
			<td><input type="text"></td>
		</tr>
		<tr>
			<th>총 결제금액</th>
			<td><input type="text"></td>
		</tr>
	</table>
	<form action="orderSheet" method="POST">
		<div id="paymentBtn">
			<a href="<%=request.getContextPath()%>/menuService/menuPage">주문취소</a>
			<input type="submit" value="결제">
		</div>
	</form>
</body>
</html>