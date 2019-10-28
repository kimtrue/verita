package kr.co.mlec.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;

public class LoginFormController implements Controller {

	public ModelAndView service(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return new ModelAndView("/jsp/login/loginform.jsp");
	}
		
}











