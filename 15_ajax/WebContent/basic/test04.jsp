<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- test04 서블릿 -->
<table>
  <c:forEach var="data" items="${list}">
     <tr><td>${data}</td></tr>
  </c:forEach>
</table>