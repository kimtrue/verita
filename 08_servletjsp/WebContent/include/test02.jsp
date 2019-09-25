<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2>test02.jsp</h2>
   <hr />
   <%--
       <jsp:include page="" />
       jsp에서 기본으로 제공하는 include 방식
       
       @include 와 차이점
       page 자체를 갖고오는 것이 아닌 실행된 결과를 갖고와서 포함한다.
              페이지가 호출되면서 같이 동작이 실행된다
              실행된 결과만 갖고오기때문에 그렇기때문에 
                 ※변수가 공유되지 않는다
       sample에 java를 1000줄을 써도 test02.jsp에는 결과 한 줄만 갖고온다
       
              파라미터를 넘길 수 있다. 페이지를 호출하는 것이기 때문에
                  
   --%>
    <jsp:include page="sample.jsp" />
   <hr />
    <jsp:include page="sample.jsp">
        <jsp:param value="test" name="msg1"/>
        <jsp:param value="테스트" name="msg2"/>
    </jsp:include>
   <hr />
</body>
</html>