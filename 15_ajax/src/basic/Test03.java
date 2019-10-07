package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basic/test03.do")
public class Test03 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     //결과값 보내주기 공유개념 X
		/**
		 * 자바스크립트에서 사용할 수 있는 문자열로 바꿔서 보내줘야한다
		 * printWriter로 보낸다
		*/
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		//테이블에 넣어줘야할때
		out.println("안녕,좋은,아침");
		out.close();
		
	}
	

}
