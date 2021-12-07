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
	<form action="">
		<h1>마이페이지</h1>
		<p>수정하실 정보를 입력해주세요.</p>
		<div id="myPage">
			
			Name <input type="text" value="${user.userName}" autocomplete="off" name="userName" id="name"><br>
			Phone <input type="text" value="${user.phoneNum}" autocomplete="off" name="phoneNum" id="phone" maxlength="11"><br>
			Password <input type="password" value="${user.passWd}" autocomplete="off" name="userPw" id="pw" maxlength="20" required><br>
			
			<p>*마일리지 확인</p> <!-- <span class="asterisk">*</span> -->
			mileage <input type="text" value="${user.userMileage}" name="userMileage" id="mileage" readonly><br>
		</div>
		
		<div id="modifyBtn">
			<a href="index.jsp" id="prev">이전</a> <input type="submit" value="수정">
		</div>
	</form>
</div>

</body>
</html>