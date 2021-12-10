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
		<p class="caption">제품 정보</p>
		<div id="productWrap">
			<table id="menu_info">
				<tr>
					<th>category</th>
					<th>menuName</th>
					<th>menuPrice</th>
					<th>menuImgPath</th>
				</tr>
				<c:forEach items="${menuInfoList}" var="menuInfoList">
					<tr class="">
						<td class="">${menuInfoList.category}</td>
						<td class="">${menuInfoList.menuName}</td>
						<td class="">${menuInfoList.menuPrice}</td>
						<td class="">
						<img src="<%=request.getContextPath()%>${menuInfoList.menuImgPath }">
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</section>

</body>
</html>