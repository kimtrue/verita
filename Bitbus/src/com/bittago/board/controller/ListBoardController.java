package com.bittago.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittago.common.db.SqlConfig;
import com.bittago.repository.dao.BoardDAO;
import com.bittago.repository.vo.Board;

@WebServlet("/admin/listboard.do")
public class ListBoardController extends HttpServlet{
	private BoardDAO dao;
	
	public ListBoardController() {
		dao = SqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		List<Board> list = dao.selectAdminBoard();
		req.setAttribute("list", list);
		
		// 서비스 페이지 호출함
		req.getRequestDispatcher("/admin/listboard.jsp").forward(req, res);
	}

	
}
