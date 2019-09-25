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

@WebServlet("/board/updateform.do")
public class UpdateFormBoardController extends HttpServlet {
	private BoardDAO dao;
	
	public UpdateFormBoardController() {
		this.dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}

	public void service(HttpServletRequest rqs, HttpServletResponse rsp) throws ServletException, IOException {
		
		rqs.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(rqs.getParameter("no"));
		System.out.println(no);
		Board board = dao.selectOneBoard(no);
		
		rsp.setContentType("text/html; charset=utf-8");
		PrintWriter out = rsp.getWriter();
		
		ServletContext context = rqs.getServletContext();
		String path = context.getRealPath("/board/update.html");
	    String content = FileUtil.readFile(path);	
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    

        content = content.replace("#title", board.getTitle());
        content= content.replace("#content", board.getContent());
        content= content.replace("#writer", board.getWriter());
        content= content.replace("#regDate", sdf.format(board.getRegDate()));
        content= content.replace("#no", String.valueOf(board.getNo()));
        
        System.out.println(content);
        
        
        
		out.println(content);
		out.close();
		

	}
}
