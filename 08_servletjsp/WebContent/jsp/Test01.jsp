<!--
  JSP(Java Server Page) = 스크립트(동적) + html 정적 자바 기능을  html을 더해 사용할 수 있게 했다
  
  jsp는 결국 servlet
  .jsp -> .java(서블릿파일) -> .class => 올바르게 되었다면 객체가 생성 -> init() -> service() 실행됨.
  --------- JSP Engine---------------- 하는 일 => jsp java class 로 컴파일 하는 
   
   
   .jsp의 내용은 변환된 서블릿 파일의 service 메서드 안에 포함된다 
   service 메서드에 선언된 변수를 .jsp 파일 내에서 접근해서 사용할 수 있다
   
   
   내장 객체 : JSP에서 선언없이 사용할 수 있는 변수
		     변수 부분에서 선언되어있는 것은 JSP에서도 선언 없이 사용 할 수 있다
   service(HSR, HSR) {
            변수
       .    
       .     
     
      JSP  
   }
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
   
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2>JSP 페이지 호출하기</h2>

</body>
</html>