package com.bittago.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittago.common.db.SqlConfig;
import com.bittago.repository.dao.UserDAO;
import com.bittago.repository.vo.User;

@WebServlet("/findemail.do")
public class FindEmailController extends HttpServlet {

	private UserDAO userDAO;
	
	public FindEmailController () {
		this.userDAO = SqlConfig.getSqlSessionInstance().getMapper(UserDAO.class);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		
		User user = new User();
		
		user.setUserName(req.getParameter("name"));
		user.setUserName(req.getParameter("phone"));
		userDAO.selectFindUser(user);
		
	
	
	}
}
