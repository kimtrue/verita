package com.bittago.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittago.common.db.SqlConfig;
import com.bittago.repository.dao.BoardDAO;
import com.bittago.repository.vo.Board;
import com.bittago.repository.vo.File;

@WebServlet("/admin/detailBoard.do")
public class DetailBoardController extends HttpServlet{
	private BoardDAO dao;
	
	public DetailBoardController() {
		dao = SqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(req.getParameter("no"));		
		Board list =  dao.selectOneBoard(no);
		File file = dao.selectOneBoardFile(no);
		req.setAttribute("list", list);
		req.setAttribute("file", file);
		req.getRequestDispatcher("/admin/detailboard.jsp").forward(req, res);
		
	}

	
}
