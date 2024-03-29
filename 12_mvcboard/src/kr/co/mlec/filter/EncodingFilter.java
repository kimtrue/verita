package kr.co.mlec.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {
	//doFilter가 사용하기 위해서
	private String charset;
	
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest hRequest = (HttpServletRequest)request;
		if("POST".equals(hRequest.getMethod())) {
			request.setCharacterEncoding(charset);
		}
		chain.doFilter(request, response);
	}


}
