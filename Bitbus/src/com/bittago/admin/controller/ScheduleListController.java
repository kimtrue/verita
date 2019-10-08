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

@WebServlet("/admin/schedulelist.do")
public class ScheduleListController extends HttpServlet {
	private AdminDAO dao;

	public ScheduleListController() {
		this.dao = SqlConfig.getSqlSessionInstance().getMapper(AdminDAO.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/*
		String sPageNo = req.getParameter("pageNo");
		int pageNo = 1;
		if (sPageNo != null) {
			pageNo = Integer.parseInt(sPageNo);
		}
		
		String sListSize = req.getParameter("listSize");
		int listSize = 10;
		if (sListSize != null) {
			listSize = Integer.parseInt(sListSize);
		}
		
		Page page = new Page(pageNo, listSize, req.getParameter("searchType"), req.getParameter("keyWord"));
		req.setAttribute("pr", new PageResult(pageNo, dao.selectScheduleCount(), listSize));
		
		
		req.setAttribute("listSize", listSize); // 페이지당 게시글 개수를 jsp의 select default 값으로 보내준다.
		 */
		req.setAttribute("scheduleList", dao.selectSchedule());
		req.getRequestDispatcher("schedulelist.jsp").forward(req, res);
	}

}
