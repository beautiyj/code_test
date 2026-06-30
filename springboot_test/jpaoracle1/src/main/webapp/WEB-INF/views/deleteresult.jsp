<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteresult</title>
</head>
<body>

<c:if test="${result == 1}">
	<script>
		alert("회원탈퇴 성공");
		location.href="loginform";
	</script>
</c:if>
<c:if test="${result != 1}">
	<script>
		alert("회원탈퇴 실패(비번 불일치)");
		history.go(-1);
	</script>
</c:if>

</body>
</html>