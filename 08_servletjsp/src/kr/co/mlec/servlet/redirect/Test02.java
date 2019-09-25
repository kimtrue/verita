package kr.co.mlec.servlet.redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/redirect/test02.do")
public class Test02 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/**
		 * writeform  
		 *   
		 *   
		 */
		System.out.println("데이터공유  서블릿");
		//재요청시 없을 거다..
		req.setAttribute("msg", "공유안됨...");
		res.sendRedirect("test02.jsp");
//		res.sendRedirect("/08_servletjsp/servlet/redirect/test01.jsp");
		res.sendRedirect(req.getContextPath() + "/servlet/redirect/test02.jsp");
//		res.sendRedirect("test01.jsp");
		
		
		
	}
	
	

}
