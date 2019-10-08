package com.bittago.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bittago.common.db.SqlConfig;
import com.bittago.repository.dao.BoardDAO;
import com.bittago.repository.vo.Board;
import com.bittago.repository.vo.Page;
import com.bittago.util.PageResult;

@WebServlet("/board/questionboard.do")
public class ServiceQboardController extends HttpServlet{
	private BoardDAO dao;
	
	public ServiceQboardController() {
		dao = SqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				req.setCharacterEncoding("utf-8");
				
				// 요청한 페이지 번호 가져오기
				String sPageNo = req.getParameter("pageNo");
				String searchType = req.getParameter("searchType");
			    String keyWord =  req.getParameter("keyWord");
				
			    
				// 요청 페이지를 1페이지로 변경
				int pageNo = 1;
				if (sPageNo != null) {
					pageNo = Integer.parseInt(sPageNo);
				}
				System.out.println(pageNo + ":::" + searchType + ":::" + keyWord);
				Page page = new Page(pageNo, searchType, keyWord);
				
			
				
				// 검색 키워드 가져오기
							
				List<Board> list = dao.selectSearch(page);

				req.setAttribute("list", list); // 게시물 목록
				
				// 현재 게시물이 몇페이지까지 있는지..(전체게시물 갯수)
				int count = dao.selectBoardCount(); 
						
				if (list == null) System.out.println("널이라네 친구");
				System.out.println(dao.selectBoardCount());
				
				PageResult pr = new PageResult(pageNo, count);
				req.setAttribute("pr", pr); // 전체 게시물 갯수
				
		
		
				req.getRequestDispatcher("/jsp/board/questionBoard.jsp").forward(req, res);
	}

	
}
