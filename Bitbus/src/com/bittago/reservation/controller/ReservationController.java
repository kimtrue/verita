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
import com.bittago.repository.vo.Line;
import com.bittago.repository.vo.Search;


@WebServlet("/reservation/reservation.do")
public class ReservationController extends HttpServlet {

	private ReservationDAO dao;
	
	public ReservationController() {
		this.dao = SqlConfig.getSqlSessionInstance().getMapper(ReservationDAO.class);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("list", dao.terminalName());
		String sDNo = req.getParameter("dNo");
		String sANo = req.getParameter("aNo");
		int dNo = 0;
		int aNo = 0;
		if (sDNo != null && sANo != null) {
			dNo = Integer.parseInt(sDNo);
			aNo = Integer.parseInt(sANo);
		}
		Search search = new Search(dNo, aNo);
		
		List<Line> dept_arrv_list = dao.lineSelect(search);
		req.setAttribute("dept_arrv_list", dept_arrv_list);
		req.setAttribute("dName", dao.tName(dNo));
		req.setAttribute("aName", dao.tName(aNo));
		
		
		req.getRequestDispatcher("/jsp/reservation/reservationSearch.jsp").forward(req, res);
	}

	
	
}
