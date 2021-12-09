<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignCafe</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/user/succeessAddUser.css">
</head>

<body>
<jsp:include page="/resources/incl/signCafeIncl.jsp"></jsp:include>	
 	<section id="successAddUser">
        <h2>멤버쉽 가입 성공!</h2>
        <a href="../index.jsp">홈으로</a>
    </section> 
</body>
</html>