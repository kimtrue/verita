package kr.co.mlec.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;
import kr.co.mlec.util.FileUtil;

@WebServlet("/board/writeform.do")
public class WriteFormBoardController extends HttpServlet {

	private String loginId = "hong";
	private BoardDAO dao;

	public WriteFormBoardController() {
		this.dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//html을 전송
		res.setContentType("text/html; charset=utf-8"); 
		//보내기 위한 출력객체
		PrintWriter out = res.getWriter();
		
		//전송할 내용..
		
		
		
		out.print(
				FileUtil.readFile(req.getServletContext().getRealPath("/board/writeform.html"))
				);
		out.close();
		
		
		/*
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title"); 
		String content = req.getParameter("content");
		*/		
		// 로그인 정보에 있는 이름으로 작성자를 설정한다.
//		b.setWriter(loginId);
//		
//		dao.insertBoard(b);

	
	}
}
