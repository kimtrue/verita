<%--
   JSTL(JSP Standard Tag Library)
   - JSP 자체 제공되는 문법 아님
   - 개발자들이 개별적으로 태그를 만들어 사용(커스텀 태그)
   - 초창기에는 없었는데 자바에서 사용하는 주요기능들을 표준으로 만들었다.
   
   - JSTL을 프로젝트에서 사용하기 위해서
     jar로 배포한다.
          라이브러리를 다운 받아서 WEB-INF/lib 폴더에 넣는다
     https://mvnrepository.com/artifact/javax.servlet/jstl/1.2 에서 jar 다운받아라.
   
   - 문제점 : 
           태그의 이름이 동일하다면. 어느 개발자가 만들었는지 구분이 되지 않는다.
   - 해결 :
             태그 사용시 라이브러리의 위치를 알려주는 prefix를 붙여서 사용한다.(nameSpace)
             커스텀 태그는 태그를 사용할 때 명시해줘야한다. 
     ex)<a:Time /> a라이브러리의 Time 태그 <b:Time /> b라이브러리의 Time태그  
   - Tag 의 prefix를 사용하기 위해서 taglib 지시자를 이용해 선언이 되어야 한다.
          
   - JSTL 태그의 종류(기능별)
     1. core : 기능 구현 시 필수로 사용되는 것들을 묶었다. (if, for, switch, 변수선언... 98%정도)
     2. fmt : 날짜(SimpleDateFormat 역할), 숫자, 다국어 처리
     3. function : String 클래스의 기능.. JSP가 버전이 올라가면서 호출이 가능해져서 별로 사용하지않는다
     4. sql - 거의 사용 안함(xml 라이브러리로 대체되었다. DAO...)
     5. xml - 거의 사용 안함( javascript...)
   
   
      
 --%>
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
   <h2>코어태그 - 데이터 공유 태그</h2>
   <%--
     pageContext.setAttribute("aaa", "bbb");
     
     set 태그
      - 동작되기 위해서는 변경되는 값을 표현 할 수 있어야한다("aaa", "bbb", pageContext, request..)
      scope : pageContext | request | session | application 
                           속성을 주지 않으면 default = page
      var : aaa
      value : bbb
      
     
    --%>
    <c:set scope="page" var="msg" value="쉬는시간" />
    <div>msg: ${msg}</div>
    <h2>page 영역에 cnt 이름으로 1을 설정</h2>
    <c:set scope="page" var="cnt" value="1" />
    <div>cnt: ${cnt} </div>
    <h2>request 영역에 cnt 이름으로 100을 설정</h2>
    <c:set scope="request" var="cnt" value="100"/>
    <div>request cnt: ${requestScope.cnt}</div>
    <h2>page 영역에 cnt의 값을 1증가시킨다</h2>
    <c:set scope="page" var="cnt" value="${cnt + 1}" />
    <div>page cnt : ${cnt}</div>
    
    
    
    
</body>
</html>