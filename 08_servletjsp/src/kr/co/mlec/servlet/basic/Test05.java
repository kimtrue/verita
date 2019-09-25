/**
 * HttpServlet 상속
 * HttpServlet은 GenericServlet을 상속받았다
 * 오류가 나지 않는 이유 :  HttpServlet가 GenericServlet 을 다 재정의했다
 * init() in GenericServlet , but Service is HttpServlet
 */
package kr.co.mlec.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/basic/test05.do")
public class Test05 extends HttpServlet {

	

	

	/*
	 * 405에러. HTTP 메소드 GET은 이 URL에 의해 지원되지 않습니다.
	 * 
	 * HttpServlet의 service는 두 가지가 존재한다
	 * service(SR , SR )
	 * service(HSR, HSR) if GET방식이면 doGet(HttpservletRequest, HttpservletResponse) 메서드 호출
	 *                  else if POST 면 doPost(HttpservletRequest, HttpservletResponse)메서드 호출
	 * 아무것도 정의하지 않고 브라우져에서 호출하면 
	 *  HttpServlet의 
	 *  init(), 
	 *  -> service(ServletRequest , ServletResponse) 
	 *  -> service(HttpservletRequest, HttpservletResponse) 
	 *  -> doGet(HttpservletRequest, HttpservletResponse)    => 405에러         
	 *                  
	 * 재정의하는 세가지 방법. 
	 * 1. service(ServletRequest , ServletResponse) 를 재정의
	 * 2. service(HttpservletRequest, HttpservletResponse) 재정의
	 * 3. doGet, doPost 재정의  
	 * 
	 * 
	 * 보통  doGet, doPost 를 재정의한다
	 * service(HSR, HSR)과 doGet, doPost 세가지를 동시에 재정의 하는 경우는 없다
	 * 상황에따라 재정의 해야 할 것은 다르다.
	 * 두가지의 방식을 사용하겠다면 doGet, doPost 둘 다 재정의해줘도 된다.
	 * 
	 */
	
	/*
	//1. service(ServletRequest , ServletResponse) 를 재정의. but 재정의 하는 경우는 별로 없다
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("serviece - req,res ");
	}
	*/
	
	/*
	//2.service(HttpservletRequest, HttpservletResponse) 재정의
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service - HttpServletRequest, HttpServletResponse");

	}
	*/
	
	/*
	//3.doGet(HttpservletRequest, HttpservletResponse), doPost(HttpservletRequest, HttpservletResponse) 재정의  
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println("doGet 호출");
	}
	*/
	
	/*
	//3.doPost(HttpservletRequest, HttpservletResponse), doPost(HttpservletRequest, HttpservletResponse) 재정의  
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 호출");
	}
	*/
	
	//doGet doPost 둘 다 재정의 하면 된다.
	
	


}
