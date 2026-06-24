<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
	<a href="boardform">글 작성</a>
	<br> 글 목록 (${listcount}개)

	<table border="1" width="800" align="center">
		<caption>
			<h4>boardlist</h4>
		</caption>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>

		<%-- 게시글 목록 출력: varStatus="status"를 사용하여 번호 자동 계산 --%>
		<c:forEach var="b" items="${boardlist}" varStatus="status">
			<tr>
				<%-- num 계산식과 동일한 결과를 status.index를 이용해 산출 --%>
				<td align="center">${listcount - (page - 1) * 10 - status.index}</td>

				<td><a href="boardcontent?no=${b.no}&page=${page}">${b.subject}</a></td>

				<td>${b.writer}</td>
				<td align="center"><fmt:formatDate value="${b.register}"
						pattern="yyyy-MM-dd HH:mm" /></td>
				<td align="center">${b.readcount}</td>
			</tr>
		</c:forEach>
	</table>

	<%-- 페이지 처리 --%>
	<center>
		<c:if test="${listcount > 0}">
			<%-- 전체 목록 페이지 처리 --%>
			<c:if test="${empty keyword }">

				<%-- 처음으로 이동 --%>
				<c:if test="${startpage > 1}">
					<a href="boardlist?page=1" style="text-decoration: none"> [<<]
					</a>
				</c:if>
				<%-- 이전 블럭이 있어야 < 버튼 나타남 --%>
				<c:if test="${startpage > 1}">
					<a href="boardlist?page=${startpage - 1}"
						style="text-decoration: none"> [<] </a>
				</c:if>
				<%-- 각 블럭에 10개의 페이지 출력 --%>
				<c:forEach var="i" begin="${startpage}" end="${endpage}">
					<c:if test="${i == page}">
						<b>[${i}]</b>
					</c:if>
					<c:if test="${i != page}">
						<a href="boardlist?page=${i}">${i}</a>
					</c:if>
				</c:forEach>
				<%-- 다음 블럭이 있어야 > 버튼 나타남 --%>
				<c:if test="${endpage < pagecount}">
					<a href="boardlist?page=${endpage + 1}"
						style="text-decoration: none"> [>] </a>
				</c:if>
				<c:if test="${endpage < pagecount}">
					<a href="boardlist?page=${pagecount}" style="text-decoration: none">
						[>>]</a>
				</c:if>

			</c:if>

			<%-- 검색 목록 페이지 처리 --%>
			<c:if test="${not empty keyword }">

				<%-- 처음으로 이동 --%>
				<c:if test="${startpage > 1}">
					<a href="boardlist?page=1&search=${search}&keyword=${keyword}"
						style="text-decoration: none"> << </a>
				</c:if>
				<%-- 이전 블럭이 있어야 < 버튼 나타남 --%>
				<c:if test="${startpage > 1}">
					<a
						href="boardlist?page=${startpage - 1}&search=${search}&keyword=${keyword}"
						style="text-decoration: none"> < </a>
				</c:if>
				<%-- 각 블럭에 10개의 페이지 출력 --%>
				<c:forEach var="i" begin="${startpage}" end="${endpage}">
					<c:if test="${i == page}">
						<b>[${i}]</b>
					</c:if>
					<c:if test="${i != page}">
						<a href="boardlist?page=${i}&search=${search}&keyword=${keyword}">${i}</a>
					</c:if>
				</c:forEach>
				<%-- 다음 블럭이 있어야 > 버튼 나타남 --%>
				<c:if test="${endpage < pagecount}">
					<a
						href="boardlist?page=${endpage + 1}&search=${search}&keyword=${keyword}"
						style="text-decoration: none"> > </a>
				</c:if>
				<c:if test="${endpage < pagecount}">
					<a
						href="boardlist?page=${pagecount}&search=${search}&keyword=${keyword}"
						style="text-decoration: none"> >> </a>
				</c:if>

			</c:if>

		</c:if>

		<%-- 검색 --%>
		<br> <br> <br>

		<form action="boardlist">
			<select name="search">
				<option value="writer">작성자</option>
				<option value="subject">제목</option>
				<option value="content">내용</option>
			</select> <input type="text" name="keyword"> <input type="submit"
				value="검색">

		</form>
	</>
</body>
</html>