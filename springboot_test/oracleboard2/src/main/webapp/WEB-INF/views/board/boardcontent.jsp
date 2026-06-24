<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<body>

	<form method=post action="boardcontent">
		<table border=1 width=400 align=center>
			<caption>상세페이지</caption>
			<tr>
				<th>작성자명</th>
				<td>${board.writer}</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td><fmt:formatDate value="${board.register}" pattern="yyyy-MM-dd HH:mm" /></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${board.readcount}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${board.subject}</td>
			</tr>

			<tr>
				<th>내용</th>
				<%-- <td><pre>${board.content}</pre></td> 둘 다 상관없음
				그냥 board.content로 하면 1줄로만 나와서 줄바꿈 적용하려면 둘 중 하나 적용해야함 --%>
				<td>${content}</td>
			</tr>
			<tr>
				<td colspan=2 align=center>
					<input type=button value="목록" onclick="location.href='boardlist?page=${page}'">
					<input type=button value="수정" onclick="location.href='boardupdateform?no=${board.no}&page=${page}'">
					<input type=button value="삭제" onclick="location.href='boarddeleteform?no=${board.no}&page=${page}'">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>