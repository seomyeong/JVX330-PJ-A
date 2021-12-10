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
<div id="myPageWrap">
	<form action="myPage" method="POST">
	
		<h1>마이페이지</h1>
		<p>수정하실 정보를 입력해주세요.</p>
		
		<table id="userInfo">
			<tr>	
				<th>Name
				<td><input type="text" value="${user.name}" autocomplete="off" name="name" id="name" required readonly></td>
			</tr>
			<tr>
				<th>Phone
				<td><input type="text" value="${user.phone}" autocomplete="off" name="phone" id="phone" maxlength="11" required></td>
			</tr>
			<tr>
				<th>Password
				<td><input type="password" value="${user.passWd}" autocomplete="off" name="passWd" id="pw" maxlength="20" required></td>
			</tr>
		</table>
		
		<p>${errormsg}</p>
		
		<p>*마일리지 확인</p>
		<table id="userMileage">
			<tr>
				<th>mileage
				<td><input type="text" value="${user.mileage}" name="mileage" id="mileage" readonly></td>
			</tr>
		</table>
		
		
		<div id="modifyBtn">
			<a href="../index.jsp" id="prev">이전</a> <input type="submit" value="수정">
		</div>
		
	</form>
</div>

</body>
</html>