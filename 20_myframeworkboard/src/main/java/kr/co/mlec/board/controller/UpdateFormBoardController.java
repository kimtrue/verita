package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;
public class UpdateFormBoardController implements Controller {

	private BoardDAO dao;
	
	public UpdateFormBoardController() {
		dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	
	
	public ModelAndView service(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 게시물 상세 정보 조회하기
		/*
		int no = Integer.parseInt(req.getParameter("no"));
		Board board = dao.selectOneBoard(no);
		req.setAttribute("board", board);
		RequestDispatcher rd = req.getRequestDispatcher("updateform.jsp");
		rd.forward(req, res);
		*/
		
		
		ModelAndView mav = new ModelAndView();
		mav.setView("/jsp/board/updateform.jsp");
		mav.addObject("board", dao.selectOneBoard(Integer.parseInt(req.getParameter("no"))));
		return mav;
	}
}











