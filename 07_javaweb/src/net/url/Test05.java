package net.url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*path 경로
 * http://localhost:8000/07_javaweb/net/url/login
 */
@WebServlet("/net/url/login")
public class Test05 extends HttpServlet {

	@Override //포스트 타입만 부를거다
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("클라이언트 요청옴..");
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		//헤더값 꺼내기
		String myId = req.getHeader("my-id");
		System.out.println("myId : " + myId);
		resp.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>연습</title></head>");
		out.println("<body><h2>id : "+id+ ", pass : "+ pass + "</h2></body>");
		
		out.println("</html>");
	}
	

}
