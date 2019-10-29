package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.WebConstants;
import org.springframework.web.servlet.WebUtil;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;
import kr.co.mlec.repository.vo.Board;

public class UpdateBoardController implements Controller {
	
	private BoardDAO dao;
	private BoardService service;
	
	public UpdateBoardController() {
		dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
		this.service = new BoardService();
	}
	
	
	public ModelAndView service(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 파라미터 정보를 읽어 데이터베이스에 저장하기
		/*
		Board board = new Board();
		board.setNo(Integer.parseInt(req.getParameter("no")));
		board.setTitle(req.getParameter("title"));
		board.setWriter(req.getParameter("writer"));
		board.setContent(req.getParameter("content"));
		*/
		
//		dao.updateBoard((Board)WebUtil.getVoToParameter(Board.class, req));
		service.updateBoard((Board)WebUtil.getVoToParameter(Board.class, req));
		
		return new ModelAndView(WebConstants.REDIRECT + "list.do");

	}
}










