<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateform</title>
</head>
<body>
<form method="post" action="update">
<input type="hidden" name="id" value="${member.id}">
<table border=1 width="400" align="center">
	<caption>회원정보 수정</caption>
	<tr>
		<th>ID</th>
		<!-- 프라이머리키라서 수정불가 -->
		<td>${member.id}</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="passwd" required="required"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="name" required="required" value="${member.name}"></td>
	</tr>
	<tr>
		<th>E-Mail</th>
		<td><input type="text" name="email" required="required" value="${member.email}"></td>
	</tr>
	<tr>
		<td colspan="2" align=center>
			<input type="submit" value="정보수정">
			<input type="reset" value="취소" onclick="history.go(-1)">
		</td>
	</tr>
</table>
</form>
</body>
</html>