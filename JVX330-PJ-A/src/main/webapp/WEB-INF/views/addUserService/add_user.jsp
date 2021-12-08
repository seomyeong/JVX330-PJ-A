<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignCafe</title>
</head>
<body>
	<form action="addUser" method="POST">
		<table>
			<tr>
				<th>이름</th>
				<td> : </td>
				<td><input type="text" name="name" placeholder="이름을 입력하세요."></td>
			</tr>

			<tr>
				<th>전화번호</th>
				<td> : </td>
				<td><input type="text" name="phone" placeholder="전화번호를 입력하세요." pattern="[0-9]+"></td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td> : </td>
				<td><input type="password" name="passWd" placeholder="비밀번호를 입력하세요."></td>
			</tr>
		</table>
		<p>${errormsg}</p>
		<a href="index.jsp">이전</a> <input type="submit" value="가입">
	</form>
</body>
</html>