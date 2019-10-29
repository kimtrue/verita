package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;

import kr.co.mlec.board.service.BoardService;

public class ListBoardController implements Controller {
	
	private BoardService service;
	
	public ListBoardController() {
		this.service = new BoardService();
	}

	public ModelAndView service(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setView("/jsp/board/list.jsp");
		mav.addObject("list", service.list());
		
		// 데이터를 구하고 공유
//		req.setAttribute("list", dao.selectBoard());
		// 사용할 화면으로 이동하기
		// 
		/**
		 * 반환타입에 뷰와 공유할 데이터가 있다면 한번에 넘겨주고 싶다
		 * 	초기 spring에서는 public String 자리의 
		 * 	String대신 한번에 넘겨 주게 Map을 사용해서 넘겨줬다
		 *  
		 */
		return mav;
	}
}







