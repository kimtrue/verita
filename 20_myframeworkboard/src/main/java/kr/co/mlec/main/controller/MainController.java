package kr.co.mlec.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;

public class MainController implements Controller {
//dispatcher 다른 패키지의 클래스가 보려면 public	
	public ModelAndView service(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return new ModelAndView("/jsp/main.jsp");
	}
}








