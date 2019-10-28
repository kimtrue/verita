package org.springframework.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//dispatcher에서 클래스를 담는 타입을 사용할 것이다.
public interface Controller {
	public ModelAndView service(HttpServletRequest req, HttpServletResponse res) throws Exception;

}
