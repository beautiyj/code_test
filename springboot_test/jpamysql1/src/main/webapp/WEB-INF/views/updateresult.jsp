<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateresult</title>
</head>
<body>

<c:if test="${result == 1}">
	<script>
		alert("회원정보 수정 성공");
		location.href="mypage";
	</script>
</c:if>
<c:if test="${result != 1}">
	<script>
		alert("회원정보 수정 실패(비번 불일치)");
		history.go(-1);
	</script>
</c:if>

</body>
</html>