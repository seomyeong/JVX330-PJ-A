<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signCafe</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/common.css">
</head>
<body>
	<jsp:include page="/resources/incl/signCafeIncl.jsp"></jsp:include>
<<<<<<< HEAD
	<h1>주문서</h1>
	<p>주문이 성공적으로 완료되었습니다.</p>
	<table>
		<thead>
			<tr>
				<th>MenuName
				<th>Ea
				<th>OptionName
				<th>OptionPrice
				<th>TotalPrice
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty orderedList}">
				<c:forEach var="orderedList" items="${orderedList}">
					<tr>
						<td>${menuIfo.menuName}</td>
						<td>${orderedList.menuCount}</td>
						<td>${orderedList.extraName}</td>
						<td>${orderedList.extraPrice}</td>
						<td>${orderedList.totalPrice}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<td>총 합계금액</td>
			<td></td>
			<td></td>
			<td></td>
			<td>1000원</td>
		</tfoot>
	</table>
	
	<table>
		<tr>
			<th>카 드 종 류 :
			<td></td>
		</tr>
		<tr>
			<th>카 드 번 호 :
			<td></td>
		</tr>
		<tr>
			<th>할 부 개 월 :
			<td>일시불</td>
		</tr>
		<tr>
			<th>판 매 금 액 :
			<td></td>
		</tr>
		<tr>
			<th>부 가 세 :
			<td></td>
		</tr>
		<tr>
			<th>승 인 금 액 :
			<td></td>
		</tr>
		<tr>
			<th>승 인 번 호 :
			<td></td>
		</tr>
		<tr>
			<th>승 인 일 시 :
			<td></td>
		</tr>
	</table>
	
	<a href="../index.jsp">확인</a>
=======
	<section id="successAddUser">
		<h2>주문이 성공적으로 완료되었습니다.</h2>
		<p>주문내역</p>
		<p>결제내역</p>
		<a href="../index.jsp">확인</a>
	</section>
>>>>>>> branch 'main' of https://github.com/seomyeong/JVX330-PJ-A.git
</body>
</html>