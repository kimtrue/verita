<%@page import="kr.co.mlec.repository.vo.Board"%>
<%@page import="kr.co.mlec.common.db.MyAppSqlConfig"%>
<%@page import="kr.co.mlec.repository.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 BoardDAO dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);

 dao.deleteBoard(Integer.parseInt(request.getParameter("no")));
 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="2; url=list.jsp">
<title>Insert title here</title>
</head>
<body>
<h2>삭제되었습니다</h2>
    <h2>2초뒤 목록 페이지로 이동합니다.</h2>
    <a href="list.jsp">목록</a>
</body>
</html>