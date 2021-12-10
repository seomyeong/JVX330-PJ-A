<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignCafe</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/common.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/index.css">
</head>

<body>
	<jsp:include page="/resources/incl/signCafeIncl.jsp"></jsp:include>
	<div id="indexWrap">
		<div id="index">
			<div id="menuWrap">
				<a href="addUserService/addUser" id="addUser">Membership</a> 
				<a href="menuPage.jsp" id="menu">Menu</a> 
				<a href="myPageService/myPageLogin" id="myPage">My Page</a> 
				<a href="adminService/adminLogin" id="admin">Admin Mode</a>
				<p>1.0.1ver</p>
			</div>
		</div>
	</div>		
</body>
</html>