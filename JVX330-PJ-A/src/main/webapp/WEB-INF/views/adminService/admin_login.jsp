<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignCafe</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admin/admin_login.css">
</head>
<body>
<jsp:include page="/resources/incl/signCafeIncl.jsp"></jsp:include>
	<section id="adminLoginPage">
		<div id="adminLoginForm">
			<h2>관리자 모드</h2>
			<form action="adminLogin" method="POST">
				<table>
					<tr>
						<th>아이디</th>
						<td>:</td>
						<td><input type="text" name="name"
							placeholder="아이디를 입력하세요."></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td>:</td>
						<td><input type="password" name="passWd"
							placeholder="비밀번호를 입력하세요."></td>
					</tr>
				</table>
				<p>${errorMsg}</p>
				<div id="adminLoginBtn">
					<a href="../index.jsp">이전</a>
					<input type="submit" value="로그인"/>
				</div>
			</form>
		</div>
	</section>>
	
		
</body>
</html>