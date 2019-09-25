/**
 *  서버 사이드 :
 *  서버에서 실행한 다음 결과를 클라이언트로 전송
 *  servlet , jsp, js(nodejs)...
 *  
 *  클라이언트 사이드 : 
 *  클라이언트에서(브라우저)에서 실행하는 것
 *  html, css, js...
 *  
 *  
 *  서버 사이드를 위한 서블렛의 규칙
 *  - .java 인 javaClass
 *  - 서버에서 호출되기 위해서는 servlet 인터페이스 타입이 되어야한다
 *     MyClass가 Servlet과 상속관계를 만들어야한다
 *     public class MyClass implements Servlet  //Servlet은 인터페이스니까
 *  - 서블릿인터페이스를 상속한 클래스를 상속받으면 된다(GenericServlet, HttpServlet both abstract class)
 *    public class MyClass Extends GenericServlet    or     public class MyClass Extends HttpServlet
 *    
 *    
 *    
 *  Servlet <- GenericServlet <- HttpServlet
 *  
 *  Servlet : 을 상속받으면 모든 메서드를 다 재정의 해야한다  이것은 불필요.. 그래서 나온게 GenericServlet 
 *  GenericServlet : 중요 메서드만 재정의하면 된다   
 *  HttpServlet : GenericServlet에 하나 더 정의했다. http 프로토콜과 연관된 메서드가 정의되어있다 (get post)
 *  
 *  
 *  사용자의 URI 정보와 Test01 서블릿을 연결하는 방법
 *  2가지 방식 제공
 *  1. web.xml 파일에 등록
 *  2. @webServlet 이라는 어노테이션 활용
 *    
 *    
 */
package kr.co.mlec.servlet.basic;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Test01 implements Servlet {

	@Override
	public void destroy() {}

	@Override
	public ServletConfig getServletConfig() { return null;}

	@Override
	public String getServletInfo() { return null; }

	@Override
	public void init(ServletConfig arg0) throws ServletException {}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("서비스 호출됨");
	}

}
