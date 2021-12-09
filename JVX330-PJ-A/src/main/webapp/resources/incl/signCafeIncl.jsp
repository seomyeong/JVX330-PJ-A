<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signCafeIncl</title>
<style>
	#signCafeLogo h1{
    text-align: center; font-size: 75px; 
    position: fixed; top: 50px; left: 80px; 
    z-index: 999;
    color: #dfc535; font-style: italic;
    writing-mode: vertical-rl; text-orientation: upright;
    letter-spacing: -50px;
    text-shadow: -2px 0 #000, 0 2px #000, 2px 0 #000, 0 -2px #000;
    }
#signCafeLogo #signLine{ height: 600px; width: 4px; background: rgb(223, 223, 223);
    position: fixed; top: 50px; left: calc(50% - 627px); z-index: 1;
    transform: rotate(8deg);
}
</style>
</head>
<body>
	<div id="signCafeLogo">
		<h1>Sign Cafe</h1>
		<div id="signLine"></div>
	</div>
</body>
</html>