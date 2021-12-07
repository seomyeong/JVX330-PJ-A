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
			
			Name <input value="${user.userName}" type="text" autocomplete="off" name="userName" id="name">
			Phone <input value="${user.phoneNum}" type="text" autocomplete="off" name="phoneNum" id="phone" maxlength="11">
			Password <input value="${user.passWd}" type="password" autocomplete="off" name="userPw" id="pw" maxlength="20" required>
			
			<p>*마일리지 확인</p> <!-- <span class="asterisk">*</span> -->
			mileage <input value="${user.userMileage}" type="text" name="userMileage" id="mileage" readonly>
		</div>
		
		<div id="modifyBtn">
			<a href="index.jsp" id="prev">이전</a> <input value="수정" type="submit">
		</div>
	</form>
</div>

</body>
</html>