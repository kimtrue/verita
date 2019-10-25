package cors;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cors/test03.do")
public class Test03 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//jsonp 방식
		System.out.println("API 서버 클라이언트 요청 들어옴");
		res.setContentType("text/html; charset=utf-8");
		
		
		PrintWriter out = res.getWriter();
		//html에서 부르면 함수 실행하기
		out.write("cb('<h2>Ajax 호출 성공 </h2>')");
		out.close();
		
	}
	

}
