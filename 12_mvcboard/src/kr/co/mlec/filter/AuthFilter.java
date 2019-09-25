package kr.co.mlec.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.repository.vo.Member;

public class AuthFilter implements Filter {
	private List<String> list = new ArrayList<>();
	
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		String[] pages = config.getInitParameter("pages").split(";");
	   for(String page : pages) {
		   System.out.println(":::"+ page.trim() +":::");
		   list.add(page.trim());//로그인 안해도 볼 수 있는 페이지
	   }
	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		//로그인이 필요한 페이지만 체크해야한다.
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//사용자가 요청한 uri
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		uri = uri.substring(contextPath.length()); //프로젝트경로는 항상같으니
		
		//로그인이 필요한지 Path에 속하는지 체크
		int index = list.indexOf(uri);
		//-1은 로그인이 필요한 페이지. list에 담긴것은 login 안필요한 페이지다
		if (index == -1) {
			HttpSession session = req.getSession();
			Member member = (Member) session.getAttribute("member");
			if (member == null) {
				res.sendRedirect(req.getContextPath() + "/login/loginform.do");
				return;
			}
		}
		//로그인 체크가 통과된 경우
		chain.doFilter(request, response);
		
	}
	/**
	 *  login이 필요한 페이지가 로그인 상태로 들어왔는지 체크
     *	로그인이 되지 않았다면 로그인 form 페이지로 이동시킨다
	 */

	

}
