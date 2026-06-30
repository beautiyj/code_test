<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<a href="boardform">글작성</a>
	<br> 글개수 : ${listcount} 개
	<table border=1 width=700 align=center>
		<caption>
			<h3>게시판 목록</h3>
		</caption>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
		</tr>
		<c:set var="num" value="${listcount-(page-1)*10}" />
		<c:forEach var="b" items="${boardlist}">
			<tr>
				<td>${num}<c:set var="num" value="${num-1}" /></td>
				<td><a href="boardcontent?no=${b.no}&page=${page}">
						${b.subject} </a></td>
				<td>${b.writer}</td>
				<td><fmt:formatDate value="${b.regdate}"
						pattern="yyyy-MM-dd HH:mm:ss EEE요일" /></td>
			</tr>
		</c:forEach>
	</table>

	<center>
		<c:if test="${listcount > 0}">
			<c:if test="${empty keyword}">
				<a href="boardlist?page=1&search=${search}&keyword=${keyword}"
					style="text-decoration: none"> < </a>

				<c:if test="${startpage > 10}">
					<a href="boardlist?page=${startpage-10}">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${startpage}" end="${endpage}">
					<c:if test="${i == page}">
						[${i}]
					</c:if>
					<c:if test="${i != page}">
						<a href="boardlist?page=${i}">[${i}]</a>
					</c:if>
				</c:forEach>

				<c:if test="${endpage < pagecount}">
					<a href="boardlist?page=${startpage+10}">[다음]</a>
				</c:if>

				<a href="boardlist?page=${pagecount}" style="text-decoration: none">
					> </a>
			</c:if>
			
			<c:if test="${!empty keyword}">
				<a href="boardlist?page=1&search=${search}&keyword=${keyword}"
					style="text-decoration: none"> < </a>

				<c:if test="${startpage > 10}">
					<a href="boardlist?page=${startpage-10}&search=${search}&keyword=${keyword}">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${startpage}" end="${endpage}">
					<c:if test="${i == page}">
						[${i}]
					</c:if>
					<c:if test="${i != page}">
						<a href="boardlist?page=${i}&search=${search}&keyword=${keyword}">[${i}]</a>
					</c:if>
				</c:forEach>

				<c:if test="${endpage < pagecount}">
					<a href="boardlist?page=${startpage+10}&search=${search}&keyword=${keyword}">[다음]</a>
				</c:if>

				<a href="boardlist?page=${pagecount}&search=${search}&keyword=${keyword}" style="text-decoration: none">
					> </a>
			</c:if>
		</c:if>
	</>
	
	<form action="boardlist">
		<select name="search">
			<option value="writer">작성자</option>
			<option value="subject">제목</option>
			<option value="content">내용</option>
		</select> 
		<input type="text" name="keyword"> 
		<input type="submit" value="확인">
	</form>

</body>
</html>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<a href="boardform">글작성</a>
	<br> 글개수 : ${listcount } 개
	<table border=1 width=700 align=center>
		<caption>
			<h3>게시판 목록</h3>
		</caption>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
		</tr>

		<c:set var="num" value="${listcount-(page-1)*10}" />
		<c:forEach var="b" items="${boardlist}">
			<tr>
				<td>${num}<c:set var="num" value="${num-1}" />
				</td>
				<td><a href="boardcontent?no=${b.no}&page=${page}">
						${b.subject} </a></td>
				<td>${b.writer}</td>
				<td><fmt:formatDate value="${b.regdate}"
						pattern="yyyy-MM-dd HH:mm:ss EEE요일" /></td>
			</tr>
		</c:forEach>
	</table>

	<!-- 페이지 처리 -->
	<center>
		<c:if test="${listcount > 0}">
			<c:if test="${empty keyword}">
				<!-- 1page로 이동 -->
				<a href="boardlist?page=1&search=${search}&keyword={keyword}"
					style="text-decoration: none"> < </a>

				<!-- 이전 블럭으로 이동 -->
				<c:if test="${startpage > 10}">
					<a href="boardlist?page=${startpage-10}">[이전]</a>
				</c:if>

				<!-- 각 블럭에 10개의 페이지 출력 -->
				<c:forEach var="i" begin="${startpage}" end="${endpage}">
					<c:if test="${i == page}">
						<!-- 현재 페이지 -->
				[${i}]
			</c:if>
					<c:if test="${i != page}">
						<!-- 현재 페이지가 아닌 경우 -->
						<a href="boardlist?page=${i}">[${i}]</a>
					</c:if>
				</c:forEach>

				<!-- 다음 블럭으로 이동 -->
				<c:if test="${endpage < pagecount}">
					<a href="boardlist?page=${startpage+10}">[다음]</a>
				</c:if>

				<!-- 마지막 페이지로 이동 -->
				<a href="boardlist?page=${pagecount}" style="text-decoration: none">
					> </a>
			</c:if>
			<c:if test="${!empty keyword}">

				<a href="boardlist?page=1&search=${search}&keyword={keyword}"
					style="text-decoration: none"> < </a>

				<!-- 이전 블럭으로 이동 -->
				<c:if test="${startpage > 10}">
					<a href="boardlist?page=${startpage-10}&search=${search}&keyword={keyword}">[이전]</a>
				</c:if>

				<!-- 각 블럭에 10개의 페이지 출력 -->
				<c:forEach var="i" begin="${startpage}" end="${endpage}">
					<c:if test="${i == page}">
						<!-- 현재 페이지 -->
				[${i}]
			</c:if>
					<c:if test="${i != page}">
						<!-- 현재 페이지가 아닌 경우 -->
						<a href="boardlist?page=${i}">[${i}]</a>
					</c:if>
				</c:forEach>

				<!-- 다음 블럭으로 이동 -->
				<c:if test="${endpage < pagecount}">
					<a href="boardlist?page=${startpage+10}">[다음]</a>
				</c:if>

				<!-- 마지막 페이지로 이동 -->
				<a href="boardlist?page=${pagecount}" style="text-decoration: none">
					> </a>

			</c:if>
		</>
		<!-- 검색기능 추가 -->
			<form action="boardlist">
				<select name="search">
					<option value="writer">작성자</option>
					<option value="subject">제목</option>
					<option value="content">내용</option>
				</select> <input type="text" name="keyword"> <input type="submit"
					value="확인">
			</form>
</body>
</html> --%>