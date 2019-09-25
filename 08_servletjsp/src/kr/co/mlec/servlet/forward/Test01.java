package kr.co.mlec.servlet.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/forward/test01.do")
public class Test01 extends HttpServlet {

	  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
    	  /*
    	   * forward 방식 사용
    	   * 1.RequestDispatcher 객체 얻기(HttpServletRequest 객체의 메서드 활용)
    	   *   - req.getRequestDispatcher(이동하고자 하는 페이지 주소)
    	   *   - 페이지를 이동하기위해 사용. 페이지 주소를 줄때 상대경로로 "/"로 설정할 경우. 웹어플리케이션(프로젝트) 경로를 제외하고 적는다  
    	   *
    	   * 2. 페이지를 이동하는 기능 사용
    	   *   - RequestDispatcher.forward(req, res)
    	   * 
    	   */
		  // /servlet/forward/test01.do 호출하기 위해서
		  // http://localhost:port/프로젝트경로/servlet/forward/test01.do
		  //  /servlet/forward/test01.jsp 를 호출하기 위해서
		  // http://localhost:port/프로젝트경로/servlet/forward/test01.jsp
		  // test01.do에서 호출하려는 페이지가 url이 뒤에만 다르다면 이렇게 줘도 된다
//		  RequestDispatcher rd = req.getRequestDispatcher("test01.jsp"); 
		  //page가 이동하기전 서블릿이 호출되었나 확인
		   System.out.println("서블릿호출됨.");
		  //1.
		  RequestDispatcher rd = req.getRequestDispatcher("/servlet/forward/test01.jsp");
		  //2.
		  rd.forward(req, res);
		  
		  
      }

}
