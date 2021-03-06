<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>  
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/jsp/include/cssScript.jsp" %>
</head>
<body>
<c:import url="/jsp/include/leftmenu.jsp" />
     <div class="container">
	 <h2>자유게시판</h2>
	 <form method='post' action='update.do'>
	 	<input type="hidden" name="no" value="${board.no}" />
	 	<div>
  		   제목 : <input type='text' name='title' size='70' 
  		              value='<c:out value="${board.title}" />' />	 	
	 	</div> 
	 	<div>
		     글쓴이 : <input type='text' name='writer' size='30' value="${board.writer}" readonly="readonly" />
	 	</div>
	 	<div>
	            내용 : <textarea name='content' rows='7' cols='70'><c:out value="${board.content}" /></textarea>
	 	</div>
	    <button type='submit'>수정</button>
	 </form>
	 </div>
</body>
</html>