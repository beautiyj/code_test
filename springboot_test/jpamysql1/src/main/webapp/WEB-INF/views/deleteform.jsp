<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteform</title>
</head>
<body>
<form method="post" action="delete">
<input type="hidden" name="id" value="${member.id}">
<table border=1 width="400" align="center">
	<caption>회원탈퇴 폼</caption>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="passwd" required="required"></td>
	</tr>
	<tr>
		<td colspan="2" align=center>
			<input type="submit" value="회원탈퇴">
			<input type="reset" value="취소" onclick="history.go(-1)">
		</td>
	</tr>
</table>
</form>
</body>
</html>