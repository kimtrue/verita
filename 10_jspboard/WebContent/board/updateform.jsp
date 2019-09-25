<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.co.mlec.repository.vo.Board"%>
<%@page import="kr.co.mlec.common.db.MyAppSqlConfig"%>
<%@page import="kr.co.mlec.repository.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

  BoardDAO dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
  Board b = dao.selectOneBoard(Integer.parseInt(request.getParameter("no")));
  request.setCharacterEncoding("utf-8");
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>자유게시판</h2>
   <form method="post" action="update.jsp">
      <div>
       <label>제목</label>
       <input type="text" name="title"  value="<%=b.getTitle() %>"/>
      </div>
      <div>
       <label>글쓴이</label>
       <input type="text" name="writer" value="<%=b.getWriter() %>"/>
      </div>
      <div>
       <label>내 용</label>
       <textarea name="content" rows="3"><%=b.getContent() %></textarea>
      </div>
      <div>
        <button>수정</button>
        <button type="button" onclick="location.href='list.jsp'">
                 목록
        </button>
      </div>
      <input type="hidden" name="no" value="<%=b.getNo() %>"/>
   </form>

</body>
</html>