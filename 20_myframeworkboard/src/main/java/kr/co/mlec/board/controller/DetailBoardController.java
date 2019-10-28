package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;

//@WebServlet("/board/detail.do")
public class DetailBoardController implements Controller {

	private BoardDAO dao;
	
	public DetailBoardController() {
		dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	
	public ModelAndView service(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 게시물 상세 정보 조회하기
		int no = Integer.parseInt(req.getParameter("no"));
		dao.updateViewCnt(no);
		/*
		Board board = dao.selectOneBoard(no); 
		req.setAttribute("board", board);
		*/
		ModelAndView mav = new ModelAndView();
		mav.setView("/jsp/board/detail.jsp");
		mav.addObject("board", dao.selectOneBoard(no));
		
		return mav;
	}
}











