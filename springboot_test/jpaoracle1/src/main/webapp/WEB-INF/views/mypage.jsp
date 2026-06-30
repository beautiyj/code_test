<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage</title>
</head>
<body>

	<!-- 데이터가 null이 아닌 경우 = 로그인 성공한 경우 마이페이지 접속 허가 -->
	<c:if test="${!empty sessionScope.id}">
		${sessionScope.id}님 환영합니다<br>
		
		<a href ="updateform">회원정보 수정</a><br>
		<a href ="logout">로그아웃</a><br>
		<a href ="deleteform">회원 탈퇴</a><br>

	</c:if>

	<c:if test="${empty sessionScope.id}">
		<a href="memberform">회원가입</a><br>
		<a href="loginform">로그인</a><br>
	</c:if>

</body>
</html>