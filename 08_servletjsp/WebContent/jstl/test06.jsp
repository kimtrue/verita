<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
  List<String> list = Arrays.asList(new String[]{"one","two","three"});
  pageContext.setAttribute("list", list);
  

%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%--
    for(String msg : list) { } 
   --%>
   <h2>forEach 향상된 for 방식</h2>
   <c:set var="cnt" value="1"/>
   <c:forEach var="msg" items="${list}">
    <c:if test="${1 != cnt}">, </c:if> 
      ${msg}
   <c:set var="cnt" value="${cnt + 1}"/>
   </c:forEach>


  <br />     
   <!-- 
    for(String msg : list) 
           향상된 for문은 msg의 순서값을 모른다.
           해결을 하기위해..
      varStatus="loop" loop라는 VO를 만들어준 개념 
      index 순서
      count 반복의 횟수       
      first 첫번째
      last 마지막 
   -->
   <c:forEach var="msg" items="${list}" varStatus="loop">
    <div></div>
    <div>${loop.index}:::${loop.count}:::${loop.first}:::${loop.last}:::</div>
      ${msg}
  
   </c:forEach>
   
   <br />   
   
   <c:forEach var="msg" items="${list}" varStatus="loop">
      <c:if test="${loop.first == false}">,</c:if>
      ${msg}
   </c:forEach>
   
   

</body>
</html>