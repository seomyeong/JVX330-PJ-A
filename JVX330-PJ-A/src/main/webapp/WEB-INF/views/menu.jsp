<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Menu</title>
<script src="/js/jquery-3.6.0.js"></script>
<script>
	$(document).ready(function(){

	let rand;
	 
	$('.guest_box').on('click',function(){

		rand = (Math.ceil(Math.random()*5))*10;

		$('#main p').remove();
		$(this).append('<p>your discount is ' + rand + '%');	
		
		$('.guest_box').unbind();  
	})
})

</script>
<style>
	.guest_box{
		background-color: #000;
	}
</style>
</head>
<body>
	<div id="header">
			<h2>Jump for Joy Sale</h2>
		</div>
		<div id="main">
			<div class="guest_box"><img src="images/jump1.jpg"/></div>
			<div class="guest_box"><img src="images/jump2.jpg"/></div>
			<div class="guest_box"><img src="images/jump3.jpg"/></div>
			<div class="guest_box"><img src="images/jump4.jpg"/></div>
		</div>
</body>
</html>