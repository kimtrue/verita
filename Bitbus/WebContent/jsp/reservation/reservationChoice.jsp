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
	
	<h2>출발지 목록</h2>
		<div>
			<table>
				<tbody>
				<c:forEach var="t" items="${list}">
				<tr>
					<td><a href="reservationChoice.do?no=${t.terminalNo}">${t.terminalName}</a></td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>

	<h2>도착지 목록</h2>
		<div>
			<table>
				<tbody>
				<c:forEach var="t" items="${arrivalList}">
				<tr>
					<td><a href="reservation.do?dNo=${dNo}&aNo=${t.terminalNo}">${t.terminalName}</a></td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>

</body>
</html>