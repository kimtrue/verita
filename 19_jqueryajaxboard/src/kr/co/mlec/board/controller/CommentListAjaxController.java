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
public class CommentListAjaxController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
		int no = Integer.parseInt(req.getParameter("no"));
		
		// 댓글 목록 공유
		List<Comment> commentList = dao.selectComment(no);
		
		PrintWriter out = resp.getWriter();
		out.println(new Gson().toJson(commentList));
		out.close();
	}
}










