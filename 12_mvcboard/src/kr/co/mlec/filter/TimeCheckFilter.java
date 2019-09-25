package kr.co.mlec.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


public class TimeCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//시작부터 끝날때 까지 걸리는 시간을 알아보기위해
		long s = System.currentTimeMillis();
		chain.doFilter(request, response);
		
		double time = (System.currentTimeMillis() - s) / 1000d;
		HttpServletRequest hRequest = (HttpServletRequest)request;
		//사용자가 요청한 uri페이지
		String uri = hRequest.getRequestURI();
		System.out.println(uri + "실행시간 : " + time+ "초");
		
		
	}

}
