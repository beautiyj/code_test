<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>로그인 처리 결과</title>
</head>
<body>
    <%
        // vs코드 test6.html 폼에서 보낸 name="id"와 name="passwd" 값을 자바 변수로 받습니다.
        String userId = request.getParameter("id");
        String userPw = request.getParameter("passwd");
    %>

    <h2>로그인 시도 결과</h2>
    <p>입력하신 아이디: <%= userId %></p>
    <p>입력하신 비밀번호: <%= userPw %></p>

    <a href="javascript:history.back()">뒤로 가기</a>
</body>
</html>