<%@page import="kr.co.mlec.el.Memo"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   List<Memo> list = new ArrayList<>();
   Memo m = new Memo();
   m.setContent("성공");
   list.add(m);
   pageContext.setAttribute("list", list);
   
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%--실행시 화면에 "성공" 이 뜨도록 코드 작성 --%>
    ${list[0].content}
</body>
</html>