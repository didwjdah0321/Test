<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	$( document ).ready(function() {
	    var msg = '${msg}';
	    
	    if(msg != "")
	    	alert(msg);
	});
	
	function modify(id){		
		location.href="modify?id="+id;
	}
	
	function remove(id){
		location.href="removeMember?id="+id;
	}
</script>
</head>
<body>
	<h1 style = "text-align: center;">관리자 페이지</h1>
	<table border = 1 style = "width : 500px; text-align: center; margin : auto;">
		<tr>
			<td>아이디</td><td>이름</td><td>포인트</td><td>삭제</td><td>수정</td>
		</tr>
		<c:forEach var = "list" items = "${info}">
		<tr>
			<td>${list.id}</td><td>${list.name}</td><td>${list.point}</td><td><input type = "button" value = "수정" onclick = "modify('${list.id}')"/></td><td><input type = "button" value = "삭제" onclick = "remove('${list.id}')"/></td>
		</tr>			
		</c:forEach>
	</table>
	<h1>스케줄러 관리</h1>
	<input type = "button" value = "스케줄러(20초마다 포인트 1증가) 실행시작" onclick = "location.href='start'"/> <input type = "button" value = "스케줄러 실행 종료" onclick = "location.href='end'"/>
</body>
</html>