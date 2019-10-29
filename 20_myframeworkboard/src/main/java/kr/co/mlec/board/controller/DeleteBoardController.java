package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.WebConstants;

import kr.co.mlec.board.service.BoardService;

public class DeleteBoardController implements Controller {
	
	private BoardService service;
	
	public DeleteBoardController() {
//		dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
		this.service = new BoardService();
	}
	
	
	public ModelAndView service(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 데이터베이스 처리하기
//		dao.deleteBoard(Integer.parseInt(req.getParameter("no"))); 
		service.deleteBoard(Integer.parseInt(req.getParameter("no")));
		return new ModelAndView(WebConstants.REDIRECT + "list.do");
	}
}











