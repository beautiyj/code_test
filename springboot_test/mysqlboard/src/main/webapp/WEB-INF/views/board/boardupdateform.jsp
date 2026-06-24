<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>

<form method="post" action="boardupdate">
    <%-- 수정할 글의 번호를 넘기는 hidden 타입 --%>
    <input type="hidden" name="no" value="${board.no}">
    <input type="hidden" name="page" value="${page}">
    
    <table border="1" width="400" align="center">
        <caption>글수정</caption>
        <tr>
            <th>작성자명</th>
            <td><input type="text" name="writer" value="${board.writer}" required="required"></td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type="password" name="passwd" required="required"></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><input type="text" name="subject" value="${board.subject}" required="required"></td>
        </tr>
        <tr>
            <th>내용</th>
            <td>
                <textarea name="content" cols="40" rows="5" required="required">${board.content}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="수정완료">
                <input type="reset" value="취소">
            </td>
        </tr>
    </table>
</form>

</body>
</html>