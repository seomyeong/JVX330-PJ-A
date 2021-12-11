<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signCafe</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.js"></script>

</head>
<body>
    <p>일치하는 회원정보가 없습니다. 멤버쉽가입으로 이동하시겠습니까?</p>
    <div id="addUserBtn">멤버쉽가입</div>

    <script>
        $('#addUserBtn').on('click', function () {
            window.open("<%=request.getContextPath()%>/addUserService/addUser", "popup1", "width=1280, height=700, left=50, top=50")
        })
    </script>
</body>
</html>