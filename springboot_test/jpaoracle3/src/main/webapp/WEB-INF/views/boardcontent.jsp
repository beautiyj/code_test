<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<body>

	<table border=1 width=500 align=center>
		<caption>상세페이지</caption>
		<tr>
			<th>작성자명</th>
			<td>${board.writer}</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td><fmt:formatDate value="${board.regdate}"
					pattern="yyyy-MM-dd HH:mm:ss" /></td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.subject}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><pre>${board.content}</pre></td>
		</tr>
		<tr>
			<td colspan=2 align=center><input type=button value="수정"
				onclick="location.href='updateform?no=${board.no}&page=${page}'">
				<input type=button value="삭제"
				onclick="location.href='deleteform?no=${board.no}&page=${page}'"> <input
				type=button value="목록"
				onclick="location.href='boardlist?page=${page}'"></td>
		</tr>
	</table>

</body>
</html>