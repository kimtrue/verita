<%@page import="kr.co.mlec.common.db.MyAppSqlConfig"%>
<%@page import="kr.co.mlec.repository.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 BoardDAO dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
  %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>자유게시판</h2>
   <form method="post" action="write.jsp">
      <div>
       <label>제목</label>
       <input type="text" name="title" />
      </div>
      <div>
       <label>글쓴이</label>
       <input type="text" name="writer" />
      </div>
      <div>
       <label>내 용</label>
       <textarea name="content" rows="3"></textarea>
      </div>
      <div>
        <button onclick="location.href='write.jsp'">등록</button>
        <button type="button" onclick="location.href='list.jsp'">
                 목록
        </button>
      </div>
   </form>

</body>
</html>