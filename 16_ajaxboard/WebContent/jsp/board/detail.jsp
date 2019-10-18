<%@page import="kr.co.mlec.repository.vo.Comment"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.co.mlec.repository.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>           
<!DOCTYPE html> 
<html>
<head>
  <meta charset='utf-8'>
  <title>자유게시판</title>
	<%@ include file="/jsp/include/cssScript.jsp" %>
</head>
<body>
	<c:import url="/jsp/include/leftmenu.jsp" />
	
	<div class="container">
		<h2>자유게시판</h2>
		<hr />
		<div>번호 : ${board.no}</div>
		<div>글쓴이 : ${board.writer}</div>
		<div>제목 : <c:out value="${board.title}" /></div>
		<div>내용 : <c:out value="${board.content}" /></div>
		<div>등록일 : <fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd HH:mm:ss" /></div>
		<div>조회수 : ${board.viewCnt}</div>
		<div>
		    <a href='updateform.do?no=${board.no}'>수정</a>
		    <a href='delete.do?no=${board.no}'>삭제</a>
		    <a href='list.do'>목록</a>
		</div>
		<%--
		   ajax는 form을 쓰지만 submit 을 하면 안된다
		   onsubmit을 주고 
		--%> 
		<div id="commentRegistForm">
			<form name="crForm" method="post" action="comment_regist.do" onsubmit="return commentRegistAjax();">
				<input type="hidden" name="no" value="${board.no}" />	
				<table width="70%">
				<tr>
					<td><input type="text" name="writer" /></td>
					<td><textarea name="content" rows="2" cols="60"></textarea></td>
					<td><input type="submit" value="등록" /></td>
				</tr>	
				</table>
			</form>
		</div>
				
		<!-- 댓글목록 처리하기-->

		<!-- 댓글 목록 영역 -->
		<div id="commentList"></div>
		
		<%-- 
		<div id="commentList">
		<form action="comment_update.do" method="post">
			<input type="hidden" name="no" value="${board.no}" />
			<input type="hidden" name="commentNo" value="${param.commentNo}" />		
			
			<table>
			<c:forEach var="comment" items="${commentList}">
				<c:choose>
					<c:when test="${param.commentNo eq comment.commentNo}">
						<tr>
						  <td>${comment.writer}</td>
						  <td>
						  	<textarea name="content" rows="2" cols="60">${comment.content}</textarea>
						  </td>
						  <td colspan="2">
						  	  <input type="submit" value="수정" />
						  	  <a href="detail.do?no=${comment.no}">취소</a>
						  </td>
						</tr>		
					</c:when>
					<c:otherwise>
						<tr>
						  <td>${comment.writer}</td>
						  <td>${comment.content}</td>
						  <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" 
						                      value="${comment.regDate}"/>
						  </td>
						  <td>
						  	  <a href="comment_delete.do?commentNo=${comment.commentNo}&no=${comment.no}">삭제</a>	
						  	  <a href="detail.do?commentNo=${comment.commentNo}&no=${comment.no}">수정</a>	
						  </td>
					    </tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${empty commentList}">
				 <tr>
				    <td colspan='4'>댓글이 존재하지 않습니다.</td>
				 </tr>
			</c:if>	 
			</table>
		</form>	
		</div>	
		--%>
	</div>
	
		
	
	<script>
	//게시글의 번호를 자바스크립트로 가져오기위한 
	let no = ${board.no};
	</script>
	
	<!--프로젝트 경로 붙여주기-->
	<script src="<c:url value='/resources/js/board.js' />" ></script>
	
	
	
	
</body>
</html>







