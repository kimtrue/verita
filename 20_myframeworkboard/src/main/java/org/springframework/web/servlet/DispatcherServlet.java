package org.springframework.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

	private URLHandlerMapping uhm;
	//생성자 말고, init 도 한 번만 호출. init 은 값을 넘겨줄 수 있다
	public void init(ServletConfig config) {
		uhm = new URLHandlerMapping();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {

			/*
			 * /main.do 요청이 오면 MainController에게 작업처리 요청을 맡긴다(클래스 호출)
			 * ---------------------------- 사용자 요청 uri 정보 req에 있다
			 * ---------------------------- req.getRequestURI() =
			 * /20_myframeworkboard/main.do /20_myframeworkboard 프로젝트 이름 잘라주기
			 *
			 */
			// 프로젝트 이름 찾기
			String contextPath = req.getContextPath(); // contextPath = '/20_myframeworkboard'
			// 프로젝트 이름은 같으니 프로젝트 이름 얻기
			String requestURI = req.getRequestURI();
			// 경로에서 요청한 주소만 받기. 프로젝트 이름 자르기위해 substring
			requestURI = requestURI.substring(contextPath.length());
//			System.out.println(requestURI);
			

			
			// requestURI에 따라 작업클래스 부르기 위해 switch
			// switch 문은 URLHandler 로
			// uhm을 호출했을 때 안의 내용을 다 호출하지 않고 매번 호출된다. 그래서 위의 생성자에 넣어준다
//			URLHandlerMapping uhm = new URLHandlerMapping();
			
			Controller controller = uhm.getContoController(requestURI);
			
			//controller가 사용자가 요청한 uri가 맵에 등록되지 않았을 때(관리되지 않는 uri), null 일 경우 문제가 생긴다
			if(controller == null) {
				throw new ServletException("잘못된 URL을 호출하였습니다");
			}
			
				
			/**
			 * 요청하는 부분을 DispatcherServlet이 하게.
			 * 
			 */
//			String view = controller.service(req, res);
			ModelAndView mav = controller.service(req, res);
			
			/**
			 * view가 Redirect 또는 forward로 보내기위해 구분을 해줘야한다
			 * Redirect에 구분자를 넣어준다 WebConstants 클래스 gg
			 * 
			 * ModelAndView 공유할 데이터가 담겨온다
			 */
			String view = mav.getView();
	
			if (view.startsWith(WebConstants.AJAX)) {
				res.setContentType("application/json; charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println(view.substring(WebConstants.AJAX.length()));
				out.close();
			} else if (view.startsWith(WebConstants.REDIRECT)) {
				res.sendRedirect(view.substring(WebConstants.REDIRECT.length()));
			} else {
				/**
				 * forward 는 ModelAndView 맵의 데이터를 화면에 공유하는 작업을 해야한다
				 */
				Map<String, Object> model = mav.getModel();
				//맵의 모든 키에 해당하는 값을 공유
				Set<String> keys = model.keySet(); //key값만 먼저 꺼내기
				for(String key: keys) {
					req.setAttribute(key, model.get(key));
				}

				req.getRequestDispatcher(view).forward(req, res);
			}

		} catch (Exception e) {
			// 예외가 났을 때 e의 예외정보를 주기위해 같이 준다.
			throw new ServletException(e);
		}
		
	}


}
