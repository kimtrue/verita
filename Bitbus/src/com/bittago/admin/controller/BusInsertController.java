package com.bittago.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittago.common.db.SqlConfig;
import com.bittago.repository.dao.AdminDAO;
import com.bittago.repository.vo.Bus;

@WebServlet("/admin/businsert.do")
public class BusInsertController extends HttpServlet{
	private AdminDAO dao;
	public BusInsertController() {
		dao = SqlConfig.getSqlSessionInstance().getMapper(AdminDAO.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Bus bus = new Bus();
		String grade = req.getParameter("busGrade");
		bus.setBusLicense(req.getParameter("busLicense"));
		bus.setBusGrade(grade);
		String maxSeatCnt;
		if(grade == "일반") {
			maxSeatCnt = "28";
		} else {
			maxSeatCnt = "19";
		}
		bus.setMaxSeatCnt(maxSeatCnt);
		dao.insertBus(bus);
		res.sendRedirect("buslist.do");
	}
	
}
