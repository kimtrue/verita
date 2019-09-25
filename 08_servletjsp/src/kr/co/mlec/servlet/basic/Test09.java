/**
 * radio, checkBox 파라미터 이해하기
 * 공통점 : 값을 사용자가 선택하지 않으면 아무런 값도 넘어오지 않는다(parameter가 null로 넘어온다)
 * 
 * 
 */
package kr.co.mlec.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/basic/test09.do")
public class Test09 extends HttpServlet{
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/**
		 * checkbox 는 여러개가 동일한 이름으로 넘어오는 경우 
		 * 문자열 배열인 getParameterValues
		 * 
		 */
		String sms = req.getParameter("sms");
		System.out.println("sms : " + sms);
		
		String[] dinner = req.getParameterValues("dinner");
		if (dinner != null) {
			for (String data : dinner) {
				// null인데 반복돌리면 오류
				System.out.println("dinner : " + data);
			}
		} else {
			System.out.println("저녁메뉴 선택하지 않음");
		}
		
	}
}
