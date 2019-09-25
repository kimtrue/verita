/**
 * Filter가 되기위해서는
 *   filter interface를 상속받아야한다
 *   호출되는 상황을 지정해줘야 한다
 *   
 * - 주요 메서드
 *      init  : 메모리에 올라갈대 최초 한 번만 실행. Tomcat이 웹어플리케이션을 메모리에 로딩 시(구동될 때 같이) 메모리에 올라간다
 *  do filter : 호출시마다 실행 (service()와 비슷)
 *  
 * 특정 서블릿 또는 특정 URL pattern과 연결해서 사용 (설정이 필요함)
 *  - web.xml 에 등록하여 사용 
 *  - annotation을 활용 
 *  
 *  
 * -web.xml에 등록하는 방법 
 *   
 *  
 */
package kr.co.mlec.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

//web.xml <filter-name>Four</filter-name>
@WebFilter(
		//하나만 있을 경우  value 사용
		urlPatterns = "/*",
		initParams = {
				@WebInitParam(name="id", value="aaaa"),
				@WebInitParam(name="pass", value="1111")
		}
		
		)
public class Four implements Filter{

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Four-init 호출됨...");
		System.out.print("id : " + config.getInitParameter("id") +":::" + "pass : " + config.getInitParameter("pass"));
		
	}
	
	
	public void doFilter(
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain 
			) throws IOException, ServletException {
		/**
		 * 연결된 다음 실행될 자원(필터 or 서블릿)을 호출
		 * chain.doFilter(request, response); 
		 * 필터가 갖고있는 다음 페이지 호출
		 * 
		 * 필터는 xml에 등록된 순서대로 
		 */
		
		System.out.println("Four-doFilter 시작");
		//연결된 다음 실행될 자원(필터 or 서블릿)을 호출
		chain.doFilter(request, response);
		System.out.println("Four-doFilter 종료");
		
	}


}
