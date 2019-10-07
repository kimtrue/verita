package basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/basic/test04.do")
public class Test04 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     //결과값 보내주기 공유개념 X
		/**
		 * 자바스크립트에서 사용할 수 있는 문자열로 바꿔서 보내줘야한다
		 * printWriter로 보낸다
		*/
		res.setContentType("text/html; charset=utf-8");
		List<String> list = new ArrayList<>();
		list.add("mark");
		list.add("jay");
		list.add("john");
		
		req.setAttribute("list", list);
		RequestDispatcher rd = req.getRequestDispatcher("test04.jsp");
		rd.forward(req, res);
		

	}
		
	

}
