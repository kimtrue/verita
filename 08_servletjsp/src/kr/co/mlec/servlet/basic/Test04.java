/**
 * 
 * 사용자 서블릿 최초 호출시
 *  - 서버는  호출한 서블릿이 메모리에 존재하는지 확인하고
 *  - 만약, 존재하지 않는다면 서블릿 객체를 생성(new)한다
 *  - 이닛메서드(init(ServletConfig) method)를 호출 생성 후 
 *  - service 메서드를 호출 후 결과를 사용자에게 전송
 *  - 재요청시 생성된 객체를 찾아서  service 메서드 호출 후 결과를 사용자에게 전송
 * 
 * 서블릿은 서버에 하나의 객체만 생성된다(싱글톤)
 * 서블릿은 메모리에 하나만 생성된다. 사용자들은 하나의 서블릿을 사용하는 것이다
 * 
 * 서블릿의 라이프사이클
 *  : 서블릿이 호출되었을 때, 자동 호출되고 메모리에서 제거될 때 자동호출
 *    -init(ServletConfig) : 서블릿이 메모리에 생성될 때 최초 한 번만 호출됨
 *    -service(ServletRequest, ServletResponse) : 사용자 요청시마다 호출, html로 넘긴다 
 *    -destroy() : servlet이 톰캣에서 제거될때 호출, 서블릿 소스가 변경될 때
 *    
 */
package kr.co.mlec.servlet.basic;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/basic/test04.do")
public class Test04 extends GenericServlet {
	//init() 이 genericservlet에 있다. 확인을 위해 오버라이딩 alt+shift+s -> v 
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init호출됨");
	}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service 호출됨");
	}


}
