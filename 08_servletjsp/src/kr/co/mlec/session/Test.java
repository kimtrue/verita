package kr.co.mlec.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/test.do")
public class Test extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//처음에 요청하면 서버를 만들어 id값을 줘야한다
		res.setContentType("text/html; charset=utf-8");
		
		//세션꺼내기
		//맨처음 요청이면 세션을 만들어준다
		//두번째 요청이면 기존의 것을 준다
		
		HttpSession session = req.getSession();
		//세션의 아이디 얻기
		String id = session.getId();
		
		
		//유지되는 시간 바꾸기 초단위
		session.setMaxInactiveInterval(3);
		PrintWriter out = res.getWriter();
		out.println("<h2>JESESSIONID : " + id + "</h2>");
		
	}
	

}
