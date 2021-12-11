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
	<section id="index">
		<div id="banner">
			<div id="menuWrap">
				<a href="addUserService/addUser" id="addUser">Sign Up</a>
				<form action="menuService/menuPage" method="post">
					<input type="submit" value="Menu" id="menu">
				</form>
				<a href="myPageService/myPageLogin" id="myPage">Membership</a>
				<a href="adminService/adminLogin" id="admin">Admin Mode</a>
				<p id="signcafe">SIGN CAFE</p>
				<p id="version">1.0.1ver</p>
			</div>
		</div>	
	</section>

</body>
</html>