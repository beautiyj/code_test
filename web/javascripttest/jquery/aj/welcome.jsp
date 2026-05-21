<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%
request.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지 %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>welcome.jsp 파일 내용</title>
  </head>
  <!-- 콜백함수에서 리턴하는 데이터 username -->
  <body>
    환영합니다. <%=request.getParameter("username") %> 님 <br />
  </body>
</html>
