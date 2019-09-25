<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 String name = request.getParameter("name");
 String phone = request.getParameter("phone");
 String major = request.getParameter("major");
 String[] sub = request.getParameterValues("class");
 String msg = "선택없음";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table {
   width: 200px;
   height: 300px;
}
.tg  {border-collapse:collapse;border-spacing:0;}
.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}
.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}
.tg .tg-cly1{text-align:left;vertical-align:middle}
.tg .tg-0lax{text-align:left;vertical-align:top}
</style>

<title>Insert title here</title>
</head>
<body>
<table class="tg">
  <tr>
    <th class="tg-cly1" colspan="2">입사지원내용</th>
  </tr>
  <tr>
    <td class="tg-cly1">이름</td>
    <td class="tg-cly1"><%=name %> </td>
  </tr>
  <tr>
    <td class="tg-cly1">핸드폰</td>
    <td class="tg-cly1"></td>
  </tr>
  <tr>
    <td class="tg-cly1">이메일 주소</td>
    <td class="tg-cly1"></td>
  </tr>
  <tr>
    <td class="tg-0lax">학과</td>
    <td class="tg-0lax"></td>
  </tr>
  <tr>
    <td class="tg-0lax">이수 과목</td>
    <td class="tg-0lax">
    <%
     if(sub!=null){
    	 for(String ss : sub) {%>
    	 <%= ss %>
  <%  		 
    	 }
     } 
     else if(sub == null){%> <%= msg %>
   <%  }%>
    
    </td>
  </tr>
  <tr>
    <td class="tg-0lax">정보 발송 방법</td>
    <td class="tg-0lax"></td>
  </tr>
  <tr>
    <td class="tg-0lax">정보 발송 여부</td>
    <td class="tg-0lax"></td>
  </tr>
</table>

</body>
</html>