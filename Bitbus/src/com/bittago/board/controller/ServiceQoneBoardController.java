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


@WebServlet("/board/questionOneBoard.do")
public class ServiceQoneBoardController extends HttpServlet{
	private BoardDAO dao;
	
	public ServiceQoneBoardController() {
		dao = SqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(req.getParameter("no"));
//		int boardNo = 18;
		
		System.out.println("질문게시판 글번호는 : " +  boardNo);
		
		dao.updateViewCnt(boardNo);
		Board qboard = dao.selectOneBoard(boardNo);
		
		if (qboard !=null) {
			req.setAttribute("qboard", qboard);
		}
		req.getRequestDispatcher("/jsp/board/questionOneboard.jsp").forward(req, res);
	}
	
	
}
