package com.bittago.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittago.common.db.SqlConfig;
import com.bittago.repository.dao.ReservationDAO;

@WebServlet("/reservation/check.do")
public class ReservationCheckController extends HttpServlet {
	
	private ReservationDAO dao;
	
	public ReservationCheckController() {
		this.dao = SqlConfig.getSqlSessionInstance().getMapper(ReservationDAO.class);
		
	}
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		req.setAttribute("adultPrice", req.getParameter("adultPrice"));
		req.setAttribute("kidPrice", req.getParameter("kidPrice"));
		req.setAttribute("adulsCnt", req.getParameter("adulsCnt"));
		req.setAttribute("kidsCnt", req.getParameter("kidsCnt"));
		req.setAttribute("seatNo", req.getParameterValues("seatNo"));
		req.getRequestDispatcher("/jsp/reservation/reservationCheck.jsp").forward(req, res);
		
	}
}
