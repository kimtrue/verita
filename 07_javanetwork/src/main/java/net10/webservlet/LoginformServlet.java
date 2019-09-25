package net10.webservlet;

import java.io.PrintWriter;

import web.util.FileUtil;
import web.util.HttpServeletResponse;
import web.util.HttpServlet;
import web.util.HttpServletRequest;
import web.util.ServletException;

public class LoginformServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServeletResponse response) throws ServletException {
		try {
		String content = FileUtil.readFile("WebContent/html/loginform.html");
		//사용자가 이름고ㅏ 메세지를 보내겠다
		//HTML파일을 전송한다
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(content);
		out.close();
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		


	}

}
