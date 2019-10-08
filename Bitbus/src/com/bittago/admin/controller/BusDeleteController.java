package com.bittago.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittago.common.db.SqlConfig;
import com.bittago.repository.dao.AdminDAO;

@WebServlet("/admin/busdelete.do")
public class BusDeleteController extends HttpServlet{
	private AdminDAO dao;
	public BusDeleteController() {
		dao = SqlConfig.getSqlSessionInstance().getMapper(AdminDAO.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		dao.deleteBus(Integer.parseInt(req.getParameter("busNo")));
		res.sendRedirect("buslist.do");
	}
	
}
