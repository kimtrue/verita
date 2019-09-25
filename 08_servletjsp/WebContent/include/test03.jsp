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
   jstl을 이용한 include(동적인 include와 유사)
   다른  사이트의 내용도 포함 시킬 수 있다
   호출해서 결과값만 가져온다
   변수공유  X, 파라미터의 결과값을 넘길 수 있다
 --%>  
 <h2>test03.jsp</h2>
 <hr />
   <c:import url="sample.jsp" />
 <hr />
   <c:import url="sample.jsp">
      <c:param name="msg1" value="test" />
      <c:param name="msg2" value="테스트" />
   </c:import>
 <hr />

</body>
</html>