<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signCafe</title>
</head>
<body>
	<jsp:include page="/resources/incl/signCafeIncl.jsp"></jsp:include>
	<table>
		<tr>
			<th>카드사 선택</th>
			<td><select>
					<option value="삼성카드">삼성카드</option>
					<option value="국민카드">국민카드</option>
					<option value="농협카드">농협카드</option>
					<option value=""></option>
			</select></td>
		</tr>
	</table>
</body>
</html>