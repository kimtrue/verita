package cors;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cors/test04.do")
public class Test04 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//jsonp 방식
		res.setContentType("text/html; charset=utf-8");
		String callback = req.getParameter("callback");

		System.out.println(callback);
	
		PrintWriter out = res.getWriter();
		out.write(callback + "('<h2>Ajax 호출 성공 </h2>')");
		out.close();
		
	}

}
