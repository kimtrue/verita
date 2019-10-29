package kr.co.mlec.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.WebConstants;

import com.google.gson.Gson;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;
import kr.co.mlec.repository.vo.Comment;

public class CommentListAjaxController implements Controller {
	public ModelAndView service(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//ajax로 가져올 때 한글처리
		
//		BoardDAO dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
		BoardService service = new BoardService();
		int no = Integer.parseInt(req.getParameter("no"));
		
		// 댓글 목록 공유
//		service.selectComment(no);
		
		return new ModelAndView(WebConstants.AJAX + new Gson().toJson(service.selectComment(no)));
	}
}










