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

public class CommentRegistController implements Controller {

	private BoardDAO dao;
	
	public CommentRegistController() {
		dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	
	public ModelAndView service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		int no = Integer.parseInt(request.getParameter("no"));
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		Comment comment = new Comment();
		comment.setNo(no);
		comment.setContent(request.getParameter("content"));
		comment.setWriter(request.getParameter("writer"));
		
		// 게시물 저장 처리 부탁..
		dao.insertComment(comment);
		
		// 댓글 목록 공유
		List<Comment> commentList = dao.selectComment(no);
		
		return new ModelAndView(WebConstants.AJAX + new Gson().toJson(commentList));
	}
}











