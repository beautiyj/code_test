<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 페이지</title>
</head>
<body>

<table border=1 width=400 align=center>
	<caption><h3>상세 페이지</h3></caption>
	<tr>
		<td>작성자</td>
		<td>${board.board_name}</td>
	</tr>
	<tr>
		<td>날짜</td>
		<td>
			<fmt:formatDate value="${board.board_date}" pattern="yyyy-MM-dd HH:mm:ss EEE요일"/>
		</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${board.board_readcount}</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${board.board_subject}</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<pre>${board.board_content}</pre>
			${content}
		</td>
	</tr>
	<tr>
		<td colspan=2 align=center>
			<input type="button" value="목록" 
			onclick="location.href='boardlist?page=${page}'">
			
			<input type="button" value="댓글" 
onclick="location.href='boardcontent?board_num=${board.board_num}&page=${page}&state=reply'">
			
			<input type="button" value="수정" 
onclick="location.href='boardcontent?board_num=${board.board_num}&page=${page}&state=edit'">
			
			<input type="button" value="삭제" 
onclick="location.href='boardcontent?board_num=${board.board_num}&page=${page}&state=del'">
		</td>
	</tr>
</table>

</body>
</html>