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
	<h1>주문서</h1>
	<p>주문이 성공적으로 완료되었습니다.</p>
	<table id="order">
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
			<tr>
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
			</tr>
		</tbody>
		<tfoot>
			<td>총 합계금액</td>
			<td></td>
			<td></td>
			<td></td>
			<td>23800원</td>
		</tfoot>
	</table>
	
	<p>신용승인정보</p>
	<table id="creditInfo">
		<tr>
			<th>카 드 종 류 :
			<td>국민카드</td>
		</tr>
		<tr>
			<th>카 드 번 호 :
			<td>1212-2323-3434-4545</td>
		</tr>
		<tr>
			<th>할 부 개 월 :
			<td>일시불</td>
		</tr>
		<tr>
			<th>판 매 금 액 :
			<td>21570</td>
		</tr>
		<tr>
			<th>부 가 세 :
			<td>2380</td>
		</tr>
		<tr>
			<th>승 인 금 액 :
			<td>23800</td>
		</tr>
		<tr>
			<th>승 인 일 시 :
			<td>2021-01-07 17:29:22</td>
		</tr>
	</table>
	
	<a href="../index.jsp">확인</a>
</body>
</html>