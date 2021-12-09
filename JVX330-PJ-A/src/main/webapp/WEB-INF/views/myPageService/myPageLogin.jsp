<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignCafe</title>
<link href='' rel="stylesheet" type="text/css">

</head>
<body>

<form action="myPageLogin
" method="POST">

	<h1>SignCafe 로그인</h1>
	<p>회원확인을 위해 회원정보를 입력해주세요.</p>
	
	<table>
		<tr>
			<th>Phone</th>
			<td><input value="" type="text" autocomplete="off" name="phone" id="phone" maxlength="11" placeholder="-를 제외한 전화번호를 입력해주세요"></td>
		</tr>
		<tr>
			<th>Password</th>
			<td><input value="" type="password" autocomplete="off" name="passWd" id="pw" maxlength="20" placeholder="비밀번호를 입력해주세요" required></td>
		
	</table>
	<p>${errormsg}</p>
	<div>
		<a href="index.jsp">이전</a>
		<input type="submit" value="로그인"> 
	</div>
	
</form>
</body>
</html>