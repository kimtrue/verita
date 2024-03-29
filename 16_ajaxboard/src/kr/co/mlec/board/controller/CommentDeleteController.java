package kr.co.mlec.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;
import kr.co.mlec.repository.vo.Comment;

@WebServlet("/board/comment_delete.do")
public class CommentDeleteController extends HttpServlet {

	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
		int no = Integer.parseInt(request.getParameter("no"));
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));	
		dao.deleteComment(commentNo);
		
//		response.sendRedirect("detail.do?no=" + no); ajax 이기때문에 X 	
		//화면에서 내가 삭제한 댓글만 지우고 목록을 보여주거나, 전체 댓글 목록 자체를 갱신해서 보여준다
		
		//댓글목록 공유 
		List<Comment> commentList = dao.selectComment(no);
		
		PrintWriter out = response.getWriter();
		out.println(new Gson().toJson(commentList));
		out.close();
	}
}











