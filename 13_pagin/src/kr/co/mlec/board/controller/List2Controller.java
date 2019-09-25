package kr.co.mlec.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;
import kr.co.mlec.repository.vo.Board;
import kr.co.mlec.repository.vo.Page;

@WebServlet("/board/list2.do")
public class List2Controller extends HttpServlet {
	private BoardDAO dao;
	
	

	public List2Controller() {
		dao = MyAppSqlConfig.getSqlSession().getMapper(BoardDAO.class);
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청한 페이지 번호 가져오기
		String sPageNo = request.getParameter("pageNo"); //페이지 번호가 없이 들어오는 것은 1페이지를 보여달라는 것.. sPage가  null이면 1페이지로 바꿔
		//요청한페이지를 1페이지로 설정
		int pageNo = 1;
		if(sPageNo != null) {
			pageNo = Integer.parseInt(sPageNo);
		}
		Page page = new Page(pageNo);
		System.out.println("요청한 페이지 번호 : " + pageNo);

		// 목록데이터 구하기
		List<Board> list = dao.selectBoard(page);
		//(page-1) * list.size + 1

		// 전체 게시물 갯수 갖고오기(페이징 처리를 위해)
		int count = dao.selectBoardCount();
		
		
		
		//마지막 페이지
		int lastPage = (int)Math.ceil(count / (double)page.getListSize());
		
		
		//전체 게시물 목록
		request.setAttribute("list", list);
		// 전체 게시물 수
		request.setAttribute("count", count);
		// 전체 게시물 중 마지막 페이지
		request.setAttribute("lastPage", lastPage);
		// 사용자가 요청한 현재페이지
		request.setAttribute("pageNo", pageNo);
		
		//목록하단 페이지 블럭 구해보자
		//현재 페이지 블럭넘버 구하기
		int tabSize = 10;
		int currTab = (pageNo - 1 ) / tabSize + 1; 
		int beginPage = (currTab - 1) * tabSize + 1;
		int endPage = currTab * tabSize;
		if(endPage > lastPage) endPage = lastPage;
		
		//1페이지 일 때 전으로 가면 안되고
		boolean prev = beginPage != 1;
		//마지막 페이지 일때 다음으로 넘기면 안되니까
		boolean next = endPage != lastPage;
		
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev); //이전이 있는지
		request.setAttribute("next", next); //다음이 있는지

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/board/list2.jsp");
		rd.forward(request, response);
	}

}










