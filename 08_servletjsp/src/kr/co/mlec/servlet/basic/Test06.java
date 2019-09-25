/**
 * HttpServletResponse 클래스의 주요 메서드
 * 
 * setContentType("브라우저에게 전송되는 문서의 타입을 알려준다");
 * setContentType("text/htm; charset=utf-8");
 * 
 * 전송할 내용을 출력하기 위해서
 * PrintWriter pw = getWriter();
 * 
 */
package kr.co.mlec.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

@WebServlet("/servlet/basic/test06.do")
public class Test06 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		res.setContentType("text/plain; charset=utf-8"); //out.println("<h1>성공-success</h1>"); 내용이 간다
		res.setContentType("text/xml; charset=utf-8");
		//오타로 브라우져가 해석할 수 없으면 다운로드 시켜준다.
//		res.setContentType("taxt/html; charset=utf-8");
		PrintWriter out = res.getWriter();
//		out.println("<h1>성공-success</h1>");
		out.println("<family><me>짱구</me></family>");
		out.close();
		//send() 는 톰캣이 해준다.

	}

	

}
