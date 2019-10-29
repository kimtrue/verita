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

public class CommentDeleteController implements Controller {
	private BoardService service;
	public CommentDeleteController() {
		this.service = new BoardService();
	}
	
	public ModelAndView service(HttpServletRequest req, HttpServletResponse response) throws Exception {

//		Comment comment = (Comment)WebUtil.getVoToParameter(Comment.class, req);
		// 댓글 목록 공유
//		List<Comment> commentList = service.commentDelete(comment);
		//한 번만 사용하니까 합쳐줬다
		return new ModelAndView(
				WebConstants.AJAX + new Gson().toJson(
						service.commentDelete(
								(Comment)WebUtil.getVoToParameter(Comment.class, req)
								)
						)
				);
		
		
		
	}
}











