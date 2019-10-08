package com.bittago.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittago.common.db.SqlConfig;
import com.bittago.repository.dao.AdminDAO;
import com.bittago.repository.vo.Page;
import com.bittago.util.PageResult;

@WebServlet("/admin/buslist.do")
public class BusListController extends HttpServlet{
	private AdminDAO dao;
	public BusListController() {
		this.dao = SqlConfig.getSqlSessionInstance().getMapper(AdminDAO.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String sPageNo = req.getParameter("pageNo");
		
		int pageNo = 1;
		if (sPageNo != null) {
			pageNo = Integer.parseInt(sPageNo);
		}
		String listSize = req.getParameter("listSize");
		Page page = null;
		if (listSize != null) {
			page = new Page(pageNo, Integer.parseInt(listSize));
		} else {
			page = new Page(pageNo);
		}
		
		req.setAttribute("listCnt", listSize); // 페이지당 게시글 개수를 jsp의 select default 값으로 보내준다.
		req.setAttribute("busList", dao.selectBus(page));
		req.setAttribute("pr", new PageResult(pageNo, dao.selectBusCount()));
		req.getRequestDispatcher("buslist.jsp").forward(req, res);
	}
	
}
