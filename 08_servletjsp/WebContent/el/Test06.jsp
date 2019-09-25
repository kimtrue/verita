<%--
    EL의 객체 표현 이해하기
           객체.이름
           객체의 타입이 VO 또는 맵 클래스인 경우
     board.no -> board.getNo()
     board.title -> board.getTitle()
     
     Map인 경우
     boardMap.no -> boardMap.get("no");   키값이 no인거로 바뀐다
     
     
 --%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--EL의 기본조건. 공유가 되어있어야한다 --%>
<%
    Map<String, String> data = new HashMap<>();  
    data.put("id", "justin");
    data.put("name", "bieber");
    data.put("msg", "Love yourself");
    
    //공유영역에 올려줌
    pageContext.setAttribute("data", data);

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>Map 객체표현</h2>
    <div>data : ${data}</div>
    <div>data.id : ${data.id}</div>
    <div>data.msg : ${data.msg}</div>
    <div>data.name : ${data.name}</div>
</body>
</html>