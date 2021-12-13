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
	<section id="successAddUser">
		<h2>주문이 성공적으로 완료되었습니다.</h2>
		<p>주문내역</p>
		<p>결제내역</p>
		<a href="../index.jsp">확인</a>
	</section>
</body>
</html>