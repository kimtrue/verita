<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
     프로젝트의 경로를 동적으로 갖고오는 방법:
     1. java 를 통해서. request.getContextPath();
     2. EL을 통해서.
        -request를 내장 객체를 먼저 얻어야 한다. 
        request는 pageContext.getRequest()
     3. JSTL 을 통해서
        <c:url value="/board/list.do" />  
                 상대경로일 땐 프로젝트 경로를 주지 않는다(앞에 /가 없다) 
         
        
 --%>
 <%
//     pageContext.getRequest().getContextPath(*) pageContext.request.contextPath
    
 %>
 
 <div><%=request.getContextPath()%>/board/list.do</div>
 <div>${pageContext.request.contextPath}/board/list.do</div>
 <div><c:url value="/board/list.do" /></div>
 <div><c:url value="list.do" /></div>

</body>
</html>