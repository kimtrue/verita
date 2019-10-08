package com.bittago.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittago.common.db.SqlConfig;
import com.bittago.repository.dao.AdminDAO;
import com.bittago.repository.vo.Terminal;
@WebServlet("/admin/businsertform.do")
public class BusInsertFormController extends HttpServlet{
	private AdminDAO dao;
	public BusInsertFormController() {
		dao = SqlConfig.getSqlSessionInstance().getMapper(AdminDAO.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Terminal terminal = new Terminal();
		req.setAttribute("terminalList", dao.selectTerminal());
		
		req.getRequestDispatcher("businsertform.jsp").forward(req, res);
	}
	
}
