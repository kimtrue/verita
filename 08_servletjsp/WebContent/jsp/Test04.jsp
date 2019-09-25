<%--
      지시문 <%@  %>
   1. page    : <%@ page name="value"....
                - contentType : 서블릿 변환시. response.setContentType("이곳에 설정");
                - import : java의 import 문을 대체. 맨 앞쪽에 선언되어야한다.
   2. include : <%@ include
   3. taglib  : <%@ taglib
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--List, ArrayList import 시키기 --%>
<%@ page import="java.util.List" %>   
<%@ page import="java.util.ArrayList" %>  
    
<%--자바실행문 --%>
<%
   List<String> list = new ArrayList<>();
   list.add("one");
   list.add("two");
   list.add("three");
   
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
    for (String data : list){
    %>	
    	<%= data %>
    <%	
    }
    %>

</body>
</html>