package kr.co.mlec.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.BoardDAO;
import kr.co.mlec.repository.vo.Board;
import kr.co.mlec.repository.vo.Member;
import kr.co.mlec.util.FileUtil;
import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/board/write.do")
public class WriteBoardController extends HttpServlet {
	private BoardDAO dao;

	public WriteBoardController() {
		this.dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(BoardDAO.class);
	}

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//login안했을 때 처리
		HttpSession session = req.getSession();
		Member member = (Member)session.getAttribute("member"); 

		dao.insertBoard(new Board().setTitle(req.getParameter("title"))
				                   .setWriter(member.getId())
				                   .setContent(req.getParameter("content")));

		res.sendRedirect("list.do");
	}
}














