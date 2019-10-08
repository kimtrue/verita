package com.bittago.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bittago.common.db.SqlConfig;
import com.bittago.repository.dao.UserDAO;
import com.bittago.repository.vo.User;


@WebServlet("/signin.do")
public class SignInController extends HttpServlet {
	
	private UserDAO userDAO;
	
	public SignInController() 
	{
		this.userDAO = SqlConfig.getSqlSessionInstance().getMapper(UserDAO.class);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		req.setCharacterEncoding("UTF-8");
		
		User user = new User();
		
		user.setUserEmail(req.getParameter("email")); 
		user.setUserPass(req.getParameter("password"));
		
		user = userDAO.selectSignIn(user);
		if(user != null) 
		{	
			HttpSession session = req.getSession();
			session.setAttribute("userNo", user.getUserNo());
			
			if(user.getUserEmail().contains("@bustago.com")) 
			{
				session.setAttribute("grade", "admin");
				resp.sendRedirect("/admin");
			}
				
			
			session.setAttribute("grade", "normal");
		}
		
		resp.sendRedirect("/");
		
	}
	
}


















