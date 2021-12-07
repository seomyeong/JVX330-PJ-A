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

<form action="">
	<h1>SignCafe 로그인</h1>
	<p>회원확인을 위해 회원정보를 입력해주세요.</p>
	<div>
	
		Phone <input value="" type="text" autocomplete="off" name="phoneNum" id="phone" maxlength="11" placeholder="-를 제외한 전화번호를 입력해주세요">
		Password <input value="" type="password" autocomplete="off" name="userPw" id="pw" maxlength="20" placeholder="비밀번호를 입력해주세요" required>
		
	</div>
	
	<div>
		<a href="index.jsp">이전</a>
		<input type="submit" value="로그인"> 
	</div>
	
	<!-- 
	$('#eMail').keyup(function(){
	$(this).css('color','#000');
	});
	$('#eMail').blur(function(){
	var value = $('#labletext').text()+$(this).val();

	alert(value);
	});
	// Source: http://stackoverflow.com/
	 -->
</form>
</body>
</html>