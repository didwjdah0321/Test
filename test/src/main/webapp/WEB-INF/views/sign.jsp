<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
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
	<h1>회원가입</h1><br>
	<form action = "insertMember" method = "post">
		<table>
			<tr>
				<td>아이디</td><td><input type = "text" name = "id" /></td>
			</tr>
			<tr>
				<td>비밀번호</td><td><input type = "password" name = "pw" /></td>
			</tr>
			<tr>
				<td>이름</td><td><input type = "text" name = "name" /></td>
			</tr>			
			<tr>
				<td><input type = "submit" value = "회원가입"></td>
			</tr>			
		</table>
	</form>
	
	
</body>
</html>
