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

@WebServlet("/board/comment_list.do")
public class CommentListAjaxController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BoardDAO dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
		//게시글 no를 가져오기위한
		int no = Integer.parseInt(req.getParameter("no"));
		
		// 댓글 목록 공유
		List<Comment> commentList = dao.selectComment(no);
//		req.setAttribute("commentList", commentList);
		//ajax로 넘기기
		PrintWriter out = res.getWriter();
		out.println(new Gson().toJson(commentList));
		
		// js의 xhr.responseText 로 갔을꺼다
		
		out.close();
		
	}
	
	

}
