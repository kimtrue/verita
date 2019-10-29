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

public class CommentRegistController implements Controller {

//	private BoardDAO dao;
	private BoardService service;
	
	public CommentRegistController() {
//		dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
		this.service = new BoardService();
	}
	
	public ModelAndView service(
			HttpServletRequest req, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=utf-8"); 
		int no = Integer.parseInt(req.getParameter("no"));
		/*
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		Comment comment = new Comment();
		comment.setNo(no);
		comment.setContent(req.getParameter("content"));
		comment.setWriter(req.getParameter("writer"));
		*/
		// 게시물 저장 처리 부탁..
//		service.insertComment((Comment)WebUtil.getVoToParameter(Comment.class, req));
		
		// 댓글 목록 공유
//		List<Comment> commentList = dao.selectComment(no);
		
		return new ModelAndView(WebConstants.AJAX + new Gson().toJson(
				service.insertComment(
						(Comment)WebUtil.getVoToParameter(Comment.class, req)
						)
				)
				);
	}
}











