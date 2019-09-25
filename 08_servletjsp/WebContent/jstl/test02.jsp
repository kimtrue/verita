<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
  출력 태그 : out
  
 --%>
 <h2>출력 : out</h2>
 <div><c:out value="i'm hungry" /></div>
 <%--
       사용자가 입력하는 값은 EL로 사용X 보안에 취약함 
    EL로 한다면 <script> 등 사용했을 때 다른 사이트로 넘어가게도 할 수 있고 
        다른 언어가 실행되어서 해킹의 위험이 있다  
 --%>
 <div>${"i'm hungry"}</div>
 <div>
 	<c:set var="msg" value="<h2>hello</h2>" />
     <div><c:out value="${msg}" /></div>
     <!-- EL -->
     <div>${msg}</div>
     
     <!-- 값이 없을 시 default 대체된다 -->
     <div><c:out value="${homepage}" default="등록된 홈페이지가 없습니다" /></div>
     
 </div>
 

</body>
</html>