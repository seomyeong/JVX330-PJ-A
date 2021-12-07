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
				<td><input type="text" name="userName" placeholder="이름을 입력하세요."></td>
			</tr>

			<tr>
				<th>전화번호</th>
				<td> : </td>
				<td><input type="text" name="userPhone"
					placeholder="전화번호를 입력하세요."></td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td> : </td>
				<td><input type="password" name="userPw"
					placeholder="비밀번호를 입력하세요."></td>
			</tr>
		</table>
		<a href="#">이전</a> <input type="submit" value="가입">
	</form>
</body>
</html>