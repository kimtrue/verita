package kr.co.mlec.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.WebConstants;

import com.google.gson.Gson;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;
import kr.co.mlec.repository.vo.Comment;

public class CommentDeleteController implements Controller {
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
		int no = Integer.parseInt(request.getParameter("no"));
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		dao.deleteComment(commentNo);
		
		// 댓글 목록 공유
		List<Comment> commentList = dao.selectComment(no);
		return new ModelAndView(WebConstants.AJAX + new Gson().toJson(commentList));
	}
}











