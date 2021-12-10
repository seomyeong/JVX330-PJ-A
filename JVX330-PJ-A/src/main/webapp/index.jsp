<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignCafe</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/index.css">
</head>

<body>
	<jsp:include page="/resources/incl/signCafeIncl.jsp"></jsp:include>	
	<section id="index">
		<div id="banner"></div>
		<div id="menuWrap">
			<a href="addUserService/addUser" id="addUser">멤버쉽 가입</a>
			<a href="menuService/menuPage" id="menu">메뉴 선택</a>
			
			<form action="menuService/menuPage" method="post">
				<input type="submit" value="메뉴 조회">
			</form>
			
			<a href="myPageService/myPageLogin" id="myPage">마이페이지</a>
			<a href="adminService/adminLogin" id="admin">관리자 모드</a>
			<p>1.0.1ver</p>
		</div>
	</section>
</body>
</html>