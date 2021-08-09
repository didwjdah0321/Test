<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
    var msg = '${msg}';
    
    if(msg != ""){
    	alert(msg);
    }
})

</script>
</head>
<body>
	<div>
		<h1>메인페이지</h1>
		<div style = "text-align: right">
			${info.name}(${info.id})님 안녕하세요. <input type = "button" value = "로그아웃" onclick = "location.href = 'logout'"/><br>
			포인트 : ${info.point}점
		</div>
	</div>
	<div>
		<h3>구입할 컨텐츠를 선택하세요.</h3>
		<table style = "text-align: center;">
			<tr>
				<td><a href = "buy?id=${info.id}&point=${info.point}&subject=intro"><img src = "resources/img/Intro_350_408.png"></a></td>
				<td><a href = "buy?id=${info.id}&point=${info.point}&subject=java"><img src = "resources/img/Java_350_408.png"></a></td>
				<td><a href = "buy?id=${info.id}&point=${info.point}&subject=c"><img src = "resources/img/Cpp_350_408.png"></a></td>
			</tr>
			<tr>
				<td>100,000포인트</td><td>500,000포인트</td><td>300,000포인트</td>
			</tr>
			<tr>
				<td><a href = "ad?id=${info.id}"><img src = "resources/img/korea_it.png"></a></td>
			</tr>
		</table>
	</div>
	
</body>
</html>