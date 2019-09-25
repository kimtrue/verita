<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.co.mlec.repository.vo.Board"%>
<%@page import="kr.co.mlec.common.db.MyAppSqlConfig"%>
<%@page import="kr.co.mlec.repository.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  BoardDAO dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
  
Board board = dao.selectOneBoard(Integer.parseInt(request.getParameter("no")));
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>

        .board {
            display: grid;
            width: 800px;
            height: 500px;
            margin: auto;
            border: 1px solid slateblue;
            grid-template-rows: 100px 1fr 1fr;
          
        }

        div h3{
            margin-left: 20px;
        }
        .boardup {
            display: grid;
            grid-template-columns: 300px 1fr;
        }
        .boardup>h3 {
            border-right: 1px dotted black;
        }
         #bigtitle {
            text-align: center;
        }
        
        .button {
        margin : auto;
        }
       .bbb {
            display: grid;
            grid-template-columns: 300px 300px;
            margin: 20px;
           margin-left: 40%;
        }
    </style>
</head>
<body>
     <h2 id="bigtitle">자유게시판</h2>
     <div class="board">
        <div class="boardup">
            <h3>번호: <%=board.getNo()%></h3>
         
            <h3>제목: <%=board.getTitle()%></h3>
 
        </div>
        <div>
            <hr>
            <h3>작성일: <%=sdf.format(board.getRegDate())%></h3>
            <h3>작성자: <%=board.getWriter()%></h3>
            <hr>
        </div>
        <div>
            
            <h3>내용: <%=board.getContent()%></h3>
        </div>s
     </div>
         <div class="bott">
         <div class="bbb">
            <button type="button" style="width: 50px; height: 30px;" onclick="location.href='updateform.jsp?no=<%=board.getNo()%>'">수정</input>
           
            <button type="button" style="width: 50px; height: 30px;" onclick="location.href='delete.jsp?no=<%=board.getNo()%>'">삭제</input>
          </div>
     </div>
    
</body>
</html>