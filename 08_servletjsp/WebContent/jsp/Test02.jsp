<!-- 
  	       문     법
   < %--     --%  >  : JSP 주석문. JSP엔진이 인식하는 주석문
   < %@        %  >  : 지시문 Directive. 페이지가 해석되어야 할 정보를 알려주는 것
   < %!        %  >  : 선언문. 거의 사용하지 않는다. JSP는 service()안에 들어가는데 메서드 안에 메서드를 선언X. 서비스 밖에 선언된다.
   < %=        %  >  : 표현식 out.println() 역할을 한다. 출력.
   < %        %  >   : 실행문. 기존의 자바코드를 다 넣으면 된다. 
   

 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%-- JSP주석문. JSP엔진이 주석처리(.java 변환 내용에 포함되지X)
                   => 따라서 브라우저로 주석내용이 전송되지 않는다 --%>
    <!-- 콘텐츠 주석문은 브라우저로 전송은 되지만 브라우저에 출력은 안된다 -->
    <h2>주석문 테스트</h2>               

</body>
</html>