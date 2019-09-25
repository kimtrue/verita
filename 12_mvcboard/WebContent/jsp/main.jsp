<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="menu">
<html>

<head>

<%-- 
   <link> 에 href를 줄 때 프로젝트 경로를 반드시 줘야한다
   프로젝트 경로 갖고오는 방법 3가지
<%= request.getContextPath() %>
${pagetContext.request.contextPath}
<c:url value="/resources/css/menu.css" />
 --%>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content== "IE=edge "/>
<meta name="google" value="notranslate" />
<title>Side Menu</title>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/menu.css" />">
<link rel="stylesheet" type="text/css"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">

</head>
<body>
	<c:import url="/jsp/include/leftmenu.jsp"/>
	<div class="container">
	    <h2>메인페이지</h2>
	</div>
	</div>



</body>
</html>