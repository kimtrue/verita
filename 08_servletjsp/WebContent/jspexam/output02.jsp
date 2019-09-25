<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String dan = request.getParameter("gugudan");
  int in = 0;
  int sum = 0;
  int dd = Integer.parseInt(dan);
  
  for(int i = 1; i < 10; i++){
	  in++;
	  sum = in*dd; %>
	  <%=dd%> X <%=in %> = <%=sum%> 
<% 	  
  }
  %>  
	  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>