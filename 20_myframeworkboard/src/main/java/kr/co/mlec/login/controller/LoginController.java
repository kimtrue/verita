package kr.co.mlec.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.WebConstants;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.LoginDAO;
import kr.co.mlec.repository.vo.Member;

public class LoginController implements Controller {
	private LoginDAO dao;
	public LoginController () {
		dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(LoginDAO.class);
	}
	
	public ModelAndView service(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		Member m = new Member();
		m.setId(id);
		m.setPass(pass);
		Member member = dao.selectLogin(m);
		ModelAndView mav = new ModelAndView();
		// 로그인 실패
		if (member == null) {
			mav.setView(WebConstants.REDIRECT + "loginform.do");
			return mav;
		}
		// 로그인 성공 시 메인페이지 이동
		HttpSession session = req.getSession();
		mav.setView(WebConstants.REDIRECT + req.getContextPath() + "/main.do");
		mav.addObject("member", member);
		return mav;
	}
}












