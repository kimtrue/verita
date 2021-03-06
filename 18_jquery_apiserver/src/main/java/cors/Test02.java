package cors;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cors/test02.do")
public class Test02 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("API 서버 클라이언트 요청 들어옴");
		res.setContentType("text/html; charset=utf-8");
		
		//cors 관련 헤더 추가하기
		res.setHeader("Access-Control-Allow-Origin", "http://localhost");
		
		PrintWriter out = res.getWriter();
		//누군가 요청하면 넘겨줄 데이터
		out.write("<h2>Ajax 호출 성공 </h2>");
		out.close();
	}
	

}
