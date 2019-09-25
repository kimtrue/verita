<%@page import="kr.co.mlec.repository.vo.Board"%>
<%@page import="kr.co.mlec.common.db.MyAppSqlConfig"%>
<%@page import="kr.co.mlec.repository.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
   request.setCharacterEncoding("utf-8");
   BoardDAO dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
   Board board = new Board();
   board.setContent(request.getParameter("content"));
   dao.insertBoard(board);
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="1; url=index.jsp" />
<title>Insert title here</title>
</head>
<body>
</body>
</html>