<%--
   jsp2.2ver (tomcat7.ver)까지는 문자열 연산이 불가능했음
   jsp 2.3ver EL3.0 부터 +=지원
   
      문자열 연산은 += 로 사용한다
   
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h2>문자열 연산</h2>
     <div>"100" + "200" = ${"100" + "200"}</div>
     <div>"hello" += "java" = ${"hello" += "java"}</div>
</body>
</html>