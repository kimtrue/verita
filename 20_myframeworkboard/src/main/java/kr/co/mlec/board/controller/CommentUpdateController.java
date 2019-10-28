package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.WebConstants;

import com.google.gson.Gson;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;
import kr.co.mlec.repository.vo.Comment;

public class CommentUpdateController implements Controller {

	private BoardDAO dao;
	
	public CommentUpdateController() {
		dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	
	
	public ModelAndView service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Comment comment = new Comment();
		comment.setContent(request.getParameter("content"));
		comment.setCommentNo(Integer.parseInt(request.getParameter("commentNo")));
		dao.updateComment(comment);
		
	
		return new ModelAndView(WebConstants.AJAX + new Gson().toJson(dao.selectComment(Integer.parseInt(request.getParameter("no")))));
	}



	
}











