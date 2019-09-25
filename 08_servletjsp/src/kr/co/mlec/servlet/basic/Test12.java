package kr.co.mlec.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//http://localhost:8000/08_servletjsp/servlet/basic/test12.do
@WebServlet("/servlet/basic/test12.do")
public class Test12 extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
		//ServletContext : WebApplication을 표현하는 자바 클래스
		//webapp 경로를 주는 것..
		String web = req.getContextPath();
		System.out.println("contextPath : " + web);
		
		//요청방식 반환
		String method = req.getMethod();
		System.out.println("method : " + method);
		
		//실제 요청한 자원이 누구인지 꺼내려할 때
		String uri = req.getRequestURI();
		System.out.println("uri : " + uri);
		
		
		System.out.println("요청패스 : " + uri.substring(web.length()));
		
	}
	
   
}
