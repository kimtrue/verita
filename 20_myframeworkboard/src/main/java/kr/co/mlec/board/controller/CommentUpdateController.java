package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.WebConstants;
import org.springframework.web.servlet.WebUtil;

import com.google.gson.Gson;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.repository.vo.Comment;

public class CommentUpdateController implements Controller {

	private BoardService service;
	
	
	public CommentUpdateController() {
//		dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
		this.service = new BoardService();
	}
	
	
	public ModelAndView service(
			HttpServletRequest req, HttpServletResponse response) throws Exception {
		/*
		Comment comment = new Comment();
		comment.setContent(req.getParameter("content"));
		comment.setCommentNo(Integer.parseInt(req.getParameter("commentNo")));
		*/
//		List<Comment> commentList = service.commentDelete(comment);
	
		return new ModelAndView(
				WebConstants.AJAX + new Gson().toJson(
						service.updateComment((Comment)WebUtil.getVoToParameter(Comment.class, req))));
	}



	
}











