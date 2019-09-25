<%@page import="kr.co.mlec.repository.vo.Board"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.mlec.common.db.MyAppSqlConfig"%>
<%@page import="kr.co.mlec.repository.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
    BoardDAO dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
    List<Board> list = dao.selectBoard();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<head>
		<meta charset="utf-8">
		<title>TodoMVC</title>
		<link rel="stylesheet" href="css/memo/base.css">
		<link rel="stylesheet" href="css/memo/index.css">
		<link rel="stylesheet" href="css/memo/app.css">
	</head>
	<body>
		<section class="todoapp">
			<header class="header">
				<h1>todos</h1>
				<form action="write.jsp" method="post">
					<input type="text" class="new-todo" placeholder="오늘의 할일을 적으세요?" name="content" autofocus>
				</form>
			</header>
			<section class="main">
				<ul class="todo-list">
				<% for(Board b : list) { %>
					<li>
						<div class="view">
							<label><%=b.getContent() %></label>
							<a href="delete.jsp?no=<%=b.getNo() %>" class="destroy"></a>
						</div>
						<input class="edit" value="<%=b.getContent() %>">
						
					</li>				
				     
				<% } %>
					
				</ul>
			</section>
			<footer class="footer">
				<span class="todo-count">전체 <strong><%=list.size() %></strong>개</span>
				<a href="deleteallboard.jsp" class="clear-completed">전체 지우기</a>
			</footer>
		</section>
	</body>
</body>
</html>