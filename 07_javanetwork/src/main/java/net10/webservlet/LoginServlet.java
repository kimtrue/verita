package net10.webservlet;

import java.io.PrintWriter;

import web.util.FileUtil;
import web.util.HttpServeletResponse;
import web.util.HttpServlet;
import web.util.HttpServletRequest;
import web.util.ServletException;

public class LoginServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServeletResponse response) throws ServletException {
		try {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			System.out.println(id);
			System.out.println(password);
			
			//마이바티스... 넘겨준다....
			
			//다시 로그인폼 페이지로 보내기
			response.setContentType("text/html; charset=uft-8");
			PrintWriter out = response.getWriter();
			out.print(FileUtil.readFile("WebContent/html/loginform.html"));
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
          
		
	}

}
