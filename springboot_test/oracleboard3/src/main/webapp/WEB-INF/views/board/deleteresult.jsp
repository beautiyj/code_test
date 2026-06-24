<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete result</title>
</head>
<body>

	<c:if test="${result == 1}">
		<script>
			alert("글 삭제 성공");
			location.href = "boardlist?page=${page}";
		</script>
	</c:if>

	<c:if test="${result != 1}">
		<script>
			alert("글 삭제 실패");
			history.go(-1);
		</script>
	</c:if>

</body>
</html>