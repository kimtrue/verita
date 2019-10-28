package kr.co.mlec.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.WebConstants;

public class LogoutController implements Controller {
	public ModelAndView service(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		// 세션을 무효화시킨다.
		session.invalidate();
		return new ModelAndView(WebConstants.REDIRECT + req.getContextPath() + "/main.do");
	}
}









