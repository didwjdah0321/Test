<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 정보 수정</title>
</head>
<body>
	<form action = "updateMember" method = "post">
		<table>
			<tr>
				<td>아이디</td> <td><input type = "text" name = "id" value = "${info.id}" readOnly/></td>
			</tr>
			<tr>
				<td>이름</td> <td><input type = "text" name = "name" value = "${info.name}"/></td>
			</tr>
			<tr>
				<td>비밀번호</td> <td><input type = "password" name = "pw" value = "${info.pw}" /></td>
			</tr>			
			<tr>
				<td>포인트</td> <td><input type = "text" name = "point" value = "${info.point}"/></td> 
			</tr>
			<tr>
				<td><input type = "submit" value = "수정" /></td>
			</tr>			
		</table>
		
	</form>
</body>
</html>