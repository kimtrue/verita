package kr.co.mlec.servlet.redirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/redirect/test01.do")
public class Test01 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/**
		 * redirect?
		 * - 응답객체를 활용한다
		 * 
		 * res.sendRedirect("이동할 페이지 주소");
		 *  
		 * !forward와 다른 점!
		 * - "/"로 페이지를 설정할 경우 "/웹어플리케이션 경로" 를 포함해줘야 한다
		 * - 경로가 같다면 뒤의 확장자명만 써줘도 된다
		 *   res.sendRedirect("/08_servletjsp/servlet/redirect/test01.jsp");
		 *   res.sendRedirect("test01.jsp");
		 *   프로젝트 명이 다를 수 있으니 웹프로젝트명을 동적으로 포함시켜야 한다. 
		 *   res.sendRedirect(req.getContextPath() + "/servlet/redirect/test01.jsp");
		 *   
		 *   sendRedirect를 하면
		 *   1. 응답코드를 302번을 준다 
		 *   2. location 이라는 헤더값을 준다(sendRedirect에 설정한 페이지 주소를 설정)
		 *   
		 *   요청이 두 번온다. 
		 *   servlet 한 번, jsp 한 번
		 *   나는 한 번, 브라우저는 두 번.
		 *   
		 * => 공유가 안된다.  
		 * 
		 * 
		 * forward     URL 바뀌지X   공유 O
		 * -------------------------------
		 * redirect    URL 바뀜           공유 X
		 * 
		 * 사용자가 write.do를 했다.
		 * 서버에 write.do를 처리하는 서블릿이 있다
		 * 등록 한 다음 목록으로 가야한다
		 * list.do 이 때  redirect 방식으로 가야  URL이 바뀐다
		 * list.do는 forward로 list.jsp를 부른다 
		 * => redirect와 forward가 한 번에 일어나는 방식
		 * 
		 * 글삭제
		 * delete.do - redirect-> list.do 
		 *   
		 * 공유가 필요한 것은 forward.
		 * 특정한 케이스. URL이 바껴야 한다면 redirect로 .. jsp는 못갖고오는 것을 알 고 있어야한다
		 *  
		 *   
		 */
		System.out.println("페이지 이동  서블릿");
//		res.sendRedirect("/08_servletjsp/servlet/redirect/test01.jsp");
		res.sendRedirect(req.getContextPath() + "/servlet/redirect/test01.jsp");
//		res.sendRedirect("test01.jsp");
		
		
		
	}
	
	

}
