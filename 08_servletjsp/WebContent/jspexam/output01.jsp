<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
  String id = request.getParameter("id");
  String msg = request.getParameter("msg");
%>
 
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2> <%=id %>님의 메세지 <%=msg %> </h2>

</body>
</html>