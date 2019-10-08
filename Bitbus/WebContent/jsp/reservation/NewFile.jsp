<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method='post' action="<c:url value="/reservation/check.do" />" >
	<input type="text" name="kidPrice" />
	<input type="text" name="adultPrice" />
	<input type="text" name="adulsCnt" />
	<input type="text" name="kidsCnt" />
	
	<input type="checkbox" name="seatNo" value="14"/>
	<input type="checkbox" name="seatNo" value="27"/>
	<button>버튼</button>
	</form>
</body>
</html>