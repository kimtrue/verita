package kr.co.mlec.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.common.db.MyAppSqlConfig;

@WebServlet("/session/login.do")
public class LoginController extends HttpServlet {
	private LoginDAO dao;
	public LoginController () {
		dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(LoginDAO.class);
	}
	

	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		//db에 넣기
		Member m = new Member();
		m.setId(id);
		m.setPass(pass);  
		
		
		Member member = dao.selectLogin(m);
		//login fail
		if(member == null) {
			res.sendRedirect("loginform.do");
			return;
		}
		//login 성공
		//로그인 성공했다는 정보가 남아야 한다. 어떤 페이지에서 호출해도 다 공유되어야한다
		HttpSession session = req.getSession();
		session.setAttribute("member", member); //로그인을 했다
		res.sendRedirect("main.do");
		
		
		
	}

}
