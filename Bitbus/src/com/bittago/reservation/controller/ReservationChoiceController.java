package com.bittago.reservation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittago.common.db.SqlConfig;
import com.bittago.repository.dao.ReservationDAO;
import com.bittago.repository.vo.Terminal;


@WebServlet("/reservation/reservationChoice.do")
public class ReservationChoiceController extends HttpServlet {

	private ReservationDAO dao;
	
	public ReservationChoiceController() {
		this.dao = SqlConfig.getSqlSessionInstance().getMapper(ReservationDAO.class);
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setAttribute("list", dao.terminalName());
		String sNo = req.getParameter("no");
		int no = 0;
		if (sNo != null) {
			no = Integer.parseInt(sNo);
		}
		req.setAttribute("arrivalList", dao.arrivals(no));
		req.setAttribute("dNo", no);
		
		req.getRequestDispatcher("/jsp/reservation/reservationChoice.jsp").forward(req, res);
	
		
	}
	
	
	
}
