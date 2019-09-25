package kr.co.mlec.servlet.forward;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/forward/test02.do")
public class Test02 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    System.out.println("test02서블릿 호출됨.");
	    //공유 데이터 설정하기
	    /* 공유할 때 넘어간 페이지(jsp) 내가 원하는 데이터를 꺼내기 위해서 서블릿에 집어 넣을 때 key(이름)값을 넣어준다
	     * 등록할 때 사용하는 메서드.  setAttribute 1. 실제 관리할  2. 꺼낼 때
	     * 꺼낼 때 사용하는 메서드. getAttribute 1. 설정할때의 이름
	     * req.setAttribute("msg", object type);
	     */
	    //설정만.. 사용은 jsp
	    req.setAttribute("msg", "공유중입니다");
	    req.setAttribute("time", new Date());
	    
	    
	    
		//이동을 위해
		RequestDispatcher rd = req.getRequestDispatcher("test02.jsp");
		rd.forward(req, res);
		
	}
	

}
