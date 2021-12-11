<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signCafe</title>
</head>
<body>
	<h1>TEST : DB에서 메뉴판 값 읽어오기</h1>
	<section id="menu">
		<div class="menuWrap">
				<c:forEach items="${menuInfoList}" var="menuInfoList">
					<div class="menuRow">
                        <img src="<%=request.getContextPath()%>${menuInfoList.menuImgPath }" width="120" height="120">
						<p class="">${menuInfoList.menuName}</p>
						<p class="">${menuInfoList.menuPrice}</p>
					</div>
				</c:forEach>
		</div>
	</section>

</body>
</html>