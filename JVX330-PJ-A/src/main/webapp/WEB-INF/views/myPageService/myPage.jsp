<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignCafe</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/common.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/myPage/myPage.css"></head>
<body>
<jsp:include page="/resources/incl/signCafeIncl.jsp"></jsp:include>	

<div id="myPageWrap">
	<div id="myPageForm">
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
		
		<div id="mileageWrap">
			<p>*마일리지 확인</p>
			<table id="userMileage">
				<tr>
					<th>mileage
					<td><input type="text" value="${user.mileage}" name="mileage" id="mileage" readonly></td>
				</tr>
			</table>	
		</div>
				
		
		<div id="myPageBtn">
			<a href="../index.jsp" id="prev">이전</a> <input type="submit" value="수정">
		</div>
		
	</form>
</div>
</div>


</body>
</html>