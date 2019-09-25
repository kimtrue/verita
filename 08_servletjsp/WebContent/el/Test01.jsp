<%--
  EL : Expression Language
    - jsp 스크립트 요소(스크립트릿, 표현식, 선언문)
    - 표현식(<%= %>)를 대신 사용
    - 자바 클래스의 메서드를 호출하거나 집합 객체(리스트, 배열,...vo...)에대한 접근 가능하다
    - jsp에서 제공하는 내장객체 중에서 공유영역과 연관된 4가지 객체를 사용한다.
      request - 한 번의 요청에 대한 공유
      pageContext 현재 내 페이지에서만 사용
      session 사용자 별 공유(브라우저별)
      application 프로젝트(웹어플리케이션) 전체 공유
      
   - 구문
     ${}, 
     #{} - jsp 2.1ver부터 사용가능   
         당신의 이름은 ${name} 입니다.
         
   - 연산자
    : 산술연산자 ( +, - * /, %(mod) )
    : 비교연산자 ( ==(eq), =!(ne), <=(le), >=(ge), <(lt), >(gt) )
    : 논리연산자( &&(and), ||(or), !(not) )  
    : 삼항연산자( ? : )  
    : empty 연산자
     - null은 참, not null이면 false
     - null이 아닌데도 참을 주는 경우 : 
     - 문자열일 경우 길이가 0인경우 참( "" )
     - 배열이나 리스트의 크기가 0인경우 참
    
     

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
       <h2>EL 사용하기</h2>
       <div>5 + 5 = <%= 5 + 5 %></div>
       <div>5 + 5 = ${5 + 5}</div>
       <div>5 % 2 = ${5 % 2}</div>
       <div>5 mod 2 = ${5 mod 2}</div>
       <div>5 == 2 = ${5 == 2}</div>
       <div>5 eq 2 = ${5 eq 2}</div>
       <div>empty "a" = ${empty "a"}</div>
       <div>empty "" = ${empty ""}</div>
       <div>not empty "a" = ${not empty "a"}</div>
       <div>not empty "" = ${not empty ""}</div>
</body>
</html>