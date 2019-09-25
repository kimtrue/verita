<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //데이터 공유는 일반적으로 서블릿(자바)에서 하는 거지만 지금은 테스트를 위해 여기서 하겠다
  pageContext.setAttribute("msg", "Let me go home");
  pageContext.setAttribute("name", "hong");
  request.setAttribute("name", "justin");  
  
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>객체찾기 - 2공유영역</h2>
     <div>msg : ${msg}</div>
     <%--
       JSP 2.2ver 부터 객체의 메서드를 직접 호출 가능 
      --%>
     <div>name : ${name}</div>
     <div>name.lenghth() : ${name.length()}</div>
     <%--request의 공유영역을 접근하고싶다면 --%>
     <div>request의  name : ${requestScope.name}</div>
     <div>request의  name.substring(1) : ${requestScope.name.substring(1)}</div>
</body>
</html>