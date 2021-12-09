<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignCafe</title>
</head>
<body>
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
		<input type="submit" value="로그인"/>
		<a href="../index.jsp">이전</a>
	</form>
</body>
</html>