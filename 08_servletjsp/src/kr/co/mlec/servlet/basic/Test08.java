/**
 * 클라이언트에서 GET/POST 호출
 * 파라미터 받아서 확인
 * 
 */
package kr.co.mlec.servlet.basic;

import java.io.IOError;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/basic/test08.do")
public class Test08 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse rps) throws ServletException, IOException {
		System.out.println("GET메서드 호출 성공");
		//msg 란 이름으로 넘어온 파라미터 꺼내서 확인하기
		
		String msg = req.getParameter("msg");
		System.out.println(msg);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse rps) throws ServletException, IOException {
		System.out.println("POST메서드 호출 성공");
		//한글깨짐 확인
		//POST 경우만 한글 처리하기
		//파라미터를 꺼내기 전에 처리해줘야한다
		req.setCharacterEncoding("utf-8");
		String msg = req.getParameter("msg");
		System.out.println(msg);
	}

}
