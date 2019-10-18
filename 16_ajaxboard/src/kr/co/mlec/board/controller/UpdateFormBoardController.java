package kr.co.mlec.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;
import kr.co.mlec.repository.vo.Board;

@WebServlet("/board/updateform.do")
public class UpdateFormBoardController extends HttpServlet {

	private BoardDAO dao;
	
	public UpdateFormBoardController() {
		dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 게시물 상세 정보 조회하기
		/*
		int no = Integer.parseInt(req.getParameter("no"));
		Board board = dao.selectOneBoard(no);
		req.setAttribute("board", board);
		RequestDispatcher rd = req.getRequestDispatcher("updateform.jsp");
		rd.forward(req, res);
		*/
		
		req.setAttribute(
			"board", dao.selectOneBoard(Integer.parseInt(req.getParameter("no")))
		);
		req.getRequestDispatcher("/jsp/board/updateform.jsp").forward(req, res);
	}
}











