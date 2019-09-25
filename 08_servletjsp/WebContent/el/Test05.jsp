<%--
    EL의 객체 표현 이해하기
        객체 VO 인 것      
     
     
 --%>
<%@page import="kr.co.mlec.el.Memo"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--EL의 기본조건. 공유가 되어있어야한다 --%>
<%
    Memo memo = new Memo();
    memo.setNo(1);
    memo.setStatus("d");
    memo.setContent("사학루등 - 상속자들");
    pageContext.setAttribute("memo", memo);
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>VO 객체표현</h2>
    <div>memo : ${memo}</div>
    <div>memo.no : ${memo.no}</div>
    <div>memo.content : ${memo.content}</div>
<%-- title은 존재하지 않으므로 에러발생    <div>memo.title : ${memo.title}</div> --%>
   
</body>
</html>