package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basic/test05.do")
public class Test05 extends HttpServlet {

	@Override
	//get방식
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		//파라미터 msg가 오는지 확인..
		String msg = req.getParameter("msg");
		PrintWriter out = res.getWriter();
		//테이블에 넣어줘야할때
		out.println("<h2>GET응답</h2>");
		out.println("<h2>msg : "+ msg + "</h2>");
		out.close();
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		String msg = req.getParameter("msg");
		PrintWriter out = res.getWriter();
		//테이블에 넣어줘야할때
		out.println("<h2>POST응답</h2>");
		out.println("<h2>msg : "+ msg + "</h2>");
		out.close();
		
	}
	

}
