<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
  if문 대체
  
  if(조건) {
             실행문
  }
  test : 조건
  
  if(auth == "S") {
     System.out.print("관리자입니다")
  }
  if(auth == "U") {
     System.out.print("사용자입니다")
  }
  if(auth != "S" && auth != "U") {
     System.out.print("잘못된 사용자입니다")
  }
  
 --%>
 <c:set var="auth" value="S" />
 <c:set var="auth" value="U" />
 <c:set var="auth" value="Z" />
 <c:if test="${auth eq 'S'}" >
        <h2>관리자입니다</h2> 
 </c:if>
 <c:if test="${auth eq 'U'}" >
        <h2>일반사용자입니다</h2> 
 </c:if>
 <c:if test="${auth ne 'U' and auth ne 'S'}" >
        <h2>권한이 없습니다</h2> 
 </c:if>
 
</body>
</html>