package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.WebConstants;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;
import kr.co.mlec.repository.vo.Board;

public class UpdateBoardController implements Controller {
	
	private BoardDAO dao;
	
	public UpdateBoardController() {
		dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	
	
	public ModelAndView service(HttpServletRequest request, HttpServletResponse res) throws Exception {
		// 파라미터 정보를 읽어 데이터베이스에 저장하기
		Board board = new Board();
		board.setNo(Integer.parseInt(request.getParameter("no")));
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		dao.updateBoard(board);
		
		return new ModelAndView(WebConstants.REDIRECT + "list.do");

	}
}










