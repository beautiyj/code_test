<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>

<form method=post action="boardupdate">
<input type="hidden" name="board_num" value="${board.board_num}">
<input type="hidden" name="page" value="${page}">

<table border=1 width=400 align=center>
	<caption>글수정</caption>
	<tr><th>작성자명</th>
		<td><input type=text name="board_name" required="required"
				   value="${board.board_name}"></td>
	</tr>
	<tr><th>비밀번호</th>
		<td><input type=password name="board_pass" required="required"></td>
	</tr>
	<tr><th>제목</th>
		<td><input type=text name="board_subject" required="required"
				   value="${board.board_subject}"></td>
	</tr>
	<tr><th>내용</th>
		<td><textarea cols=40 rows=5 name="board_content" required="required">${board.board_content}</textarea></td>
	</tr>
	<tr><td colspan=2 align=center>
			<input type=submit value="글수정">
			<input type=reset value="취소">
		</td>
	</tr>
</table>
</form>

</body>
</html>