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

public class WriteBoardController implements Controller {
	private BoardDAO dao;
	private BoardService service;
	public WriteBoardController() {
//		this.dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
		this.service = new BoardService();
	}
	public ModelAndView service(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
//		HttpSession session = req.getSession();
//		Member member = (Member)session.getAttribute("member");
		//object 타입 반환이라 형변환
//		dao.insertBoard((Board)WebUtil.getVoToParameter(Board.class, req));
		service.insertBoard((Board)WebUtil.getVoToParameter(Board.class, req));
		return new ModelAndView(WebConstants.REDIRECT + "list.do");
	}
}














