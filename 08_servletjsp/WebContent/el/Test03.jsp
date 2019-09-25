<%--
  - EL에서 객체찾기
  ${id}
  ${param}
  
  
  -객체(id, param...) 찾는 순서
   1. EL에서 제공하는 기본객체에서 동일한 이름을 찾는다.
      (jsp에서도 있다. request, context, ...)
      pageContext(jsp에서 제공되는 내장객체와 동일) : 다른 내장객체에 접근 할 수 있게한다 
     <Scope=공유영역과 관련>
      pageScope : pageContext의 내장객체가 아니라 걔가 갖고있는 공유영역을 접근
      requestScope : request 공유 영역에 접근
      sessionsScope : session의 공유영역 접근
      applicationScope : application의 공유영역에 접근
      param - request.getParameter를 대체
      paramValues - request.getParameterValues 대체
      cookie - 상태정보 관리 Cookie 객체를 접근
      ...
   2. 1번에서 찾이못한 경우 넘어온다
      JSP가 관리하는 4개의 공유영역에 설정된 값에서 찾는다
            만약 null이면(값이 없을 때) null처리를 안해도 자동으로 빈 화면을 보여준다
     
     el 객체를 공유영역에서 찾는 순서 :   
      - pagecontext->request->session->application 순으로 찾는데 앞에 있으면 거기서 멈춘다 
      - 만약, 여러 공유 영역에 동일한 이름으로 등록되어 있다면, 각각의 공유영역에 접근하는 EL 기본객체를 이용해서 원하는 공유 영역(Scope)에 접근한다.
      
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
    <h2>객체 찾기 - 1</h2>
    <div> id : <%=request.getParameter("id")%></div>
    <div> id : ${param.id}</div>
</body>
</html>