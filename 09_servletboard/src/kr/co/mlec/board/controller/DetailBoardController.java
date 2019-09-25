package kr.co.mlec.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;
import kr.co.mlec.repository.vo.Board;
import kr.co.mlec.util.FileUtil;

@WebServlet("/board/detail.do")
public class DetailBoardController extends HttpServlet {
	private BoardDAO dao;
	public DetailBoardController() {
		this.dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	
	public void service(HttpServletRequest req, HttpServletResponse rps) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Board board = dao.selectOneBoard(Integer.parseInt(req.getParameter("no")));
		
		
		rps.setContentType("text/html; charset=utf-8");
		PrintWriter out = rps.getWriter();
		
		ServletContext context = req.getServletContext();
		String path = context.getRealPath("/board/detail.html");
	    String content = FileUtil.readFile(path);	
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        content = content.replace("#title", board.getTitle());
        content= content.replace("#writer", board.getWriter());
        content= content.replace("#content", board.getContent());
        content= content.replace("#regDate", sdf.format(board.getRegDate()));
        content= content.replace("#no", String.valueOf(board.getNo()));
        
		out.println(content);
		
	
	}
}
