package kr.co.mlec.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

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

@WebServlet("/board/list.do")
public class ListBoardController extends HttpServlet {
	
	private BoardDAO dao;
	
	public ListBoardController() {
		this.dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}

	//get방식이다
	public void service(HttpServletRequest req, HttpServletResponse rps) throws ServletException, IOException {		
		rps.setContentType("text/html; charset=utf-8");
		PrintWriter out = rps.getWriter();
		
		
		
		
		List<Board> list = dao.selectBoard();
		int count = list.size();
		StringBuffer sb = new StringBuffer();
		if (list.isEmpty()) {
			sb.append("<tr><td colspan='5'>게시물이 없습니다.</td></tr>");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (Board b : list) {
			sb.append("<tr>");
			sb.append("  <td>"+b.getNo()+"</td>");
			sb.append("  <td>"+"<a href='detail.do?no="+b.getNo()+"'>"+b.getTitle()+"</a></td>");
			sb.append("  <td>"+b.getWriter()+"</td>");
			sb.append("  <td>"+b.getViewCnt()+"</td>");
			sb.append("  <td>"+sdf.format(b.getRegDate())+"</td>");
			sb.append("</tr>");
		}
		
		//사람들마다 저장경로가 다를 것..
		
		//톰캣에서 실구동하는 웹어플리케이션 경로를 얻는 받법
		ServletContext context = req.getServletContext();
		//쟤가 있는 리얼경로
		String path = context.getRealPath("/board/list.html");
		System.out.println(path);
		//list.html 파일의 내용을 읽어서 #count, #tdata 부분을 변경한다
		String content = FileUtil.readFile(path);
		content = content.replace("#count", String.valueOf(count));
		content = content.replace("#tdata", sb.toString());
		System.out.println(content);
		out.print(content);
		out.close();
		
	}
}







