<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--else if 구조 --%>
	<%-- <c:set var="auth" value="S" /> --%>
	<c:set var="auth" value="U" />
	 <c:set var="auth" value="Z" />

	<%-- choose --%>
	<c:choose>
		<c:when test="${auth eq 'S'}">
			<h2>관리자입니다</h2>
		</c:when>
		<c:when test="${auth eq 'U'}">
			<h2>일반사용자입니다</h2>
		</c:when>
		<c:otherwise>
			<h2>권한이 없습니다</h2>
		</c:otherwise>
	</c:choose>


</body>
</html>