<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1 width=500 align=center>
		<caption>
			<h3>회원목록</h3>
		</caption>
		<tr>
			<th>이름</th>
			<th>EMail</th>
		</tr>
		<c:forEach var="b" items="${list}">
			<tr>
				<td>${b.name}</td>
				<td>${b.email}</td>
				<%-- 프로퍼티에 아이디비번추가함
				# http://localhost:9999/member/list에서 해당 아이디비번으로 로그인하면
				# http://localhost:9999/member/list?continue로 자동 이동, 리스트 보임	 --%>
			</tr>
		</c:forEach>
	</table>


</body>
</html>