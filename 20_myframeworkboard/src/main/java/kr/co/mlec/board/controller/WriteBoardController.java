package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.WebConstants;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;
import kr.co.mlec.repository.vo.Board;

public class WriteBoardController implements Controller {
	private BoardDAO dao;
	public WriteBoardController() {
		this.dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	public ModelAndView service(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
//		HttpSession session = req.getSession();
//		Member member = (Member)session.getAttribute("member");
		dao.insertBoard(
				new Board().setTitle(req.getParameter("title"))
						   .setWriter(req.getParameter("writer"))
//						   .setWriter(member.getId())
						   .setContent(req.getParameter("content"))
		);
		return new ModelAndView(WebConstants.REDIRECT + "list.do");
	}
}














