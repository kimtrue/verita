package net.url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*path 경로
 * http://localhost:8000/07_javaweb/net/url/test03
 */
@WebServlet("/net/url/test04")
public class Test04 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("클라이언트 요청옴..");
		
		String id = req.getParameter("id");
		
		resp.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>연습</title></head>");
		out.println("<body><h2>id : "+id+"</h2></body>");
		
		out.println("</html>");
	}
	

}
