package kr.co.mlec.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/board/update.do")
public class UpdateBoardController extends HttpServlet{
	private BoardDAO dao;
	
	public UpdateBoardController() {
		this.dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	
	public void service(HttpServletRequest rqs, HttpServletResponse rps) throws ServletException, IOException{
		//파라미터한글처리
		rqs.setCharacterEncoding("utf-8");
		
		//파라미터를 보내기 전에 이름을 뭐로 넘겨줬는지 확인해라
		/*
		Board board= new Board();
		String title = rqs.getParameter("title");
		String writer = rqs.getParameter("writer");
		String content = rqs.getParameter("content");
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		*/
		//Board도 처리해주고 싶다...
		Board board = new Board();
		board.setTitle(rqs.getParameter("title"));
		board.setWriter(rqs.getParameter("writer"));
		board.setContent(rqs.getParameter("content"));
		board.setNo(Integer.parseInt(rqs.getParameter("no")));
		//db에 넣어주기위해 보드에 담아서 넣어준다
		dao.updateBoard(board);
		//처리페이지를 만들어준다.
		//등록되었다고...
		
		rps.setContentType("text/html; charset=utf-8");
		PrintWriter out = rps.getWriter();
		
		ServletContext context = rqs.getServletContext();
		String path = context.getRealPath("/board/result.html");
		String content = FileUtil.readFile(path);
		
		content = content.replace("#msg", "수정되었습니다");
		
		out.println(content);
		out.close();
	}

}
