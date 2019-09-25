<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%--
        실행문 : 실행할 자바코드를 작성하는 스크립트문
        표현식 : 출혁할 부분을 명시   
    String msg = "ads"; 를 자바라고 알려주고 싶을 때
   --%>
   <%
    String msg = "Hi";
    String cmsg = "Hello";
    System.out.println("msg: " + cmsg);
   %>
   <%-- 
            브라우져에 찍고싶을 때
      java -> html      
    --%>
   <%= msg %>

</body>
</html>