package com.bittago.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittago.common.db.SqlConfig;
import com.bittago.repository.dao.AdminDAO;

@WebServlet("/admin/reservationcntchart.do")
public class ReservationCntChartController extends HttpServlet{
	private AdminDAO dao;
	public ReservationCntChartController() {
		dao = SqlConfig.getSqlSessionInstance().getMapper(AdminDAO.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("yearList", dao.selectYearReservationCnt());
		req.setAttribute("monthList", dao.selectMonthReservationCnt());
		req.getRequestDispatcher("chart.jsp").forward(req, res);
	}
	
	
}
