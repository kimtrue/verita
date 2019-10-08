package com.bittago.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittago.common.db.SqlConfig;
import com.bittago.repository.dao.ReservationDAO;

@WebServlet("/reservation/reservationEnd.do")
public class ReservationEndController extends HttpServlet {

	private ReservationDAO dao;
	
	public ReservationEndController() {
		this.dao = SqlConfig.getSqlSessionInstance().getMapper(ReservationDAO.class);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		System.out.println(req.getParameter("payment"));
		String[] seatNo = req.getParameterValues("seatNo");
		System.out.println(seatNo);
		
		req.setAttribute("adulsCnt", req.getParameter("adulsCnt"));
		req.setAttribute("kidsCnt", req.getParameter("kidsCnt"));
		req.setAttribute("payment", req.getParameter("payment"));
		req.setAttribute("seatNo", req.getParameterValues("seatNo"));
		req.getRequestDispatcher("/jsp/reservation/reservationEnd.jsp").forward(req, res);
	
	}

	
	
}
