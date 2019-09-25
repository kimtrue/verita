package kr.co.mlec.servlet.basic;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/basic/test10.do")
public class Test10 extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse rps) throws ServerException, IOException {
			
		/*
		 * 사용자가 넘겨준 id와 password값을 확인하고 싶다.
		 * 그렇지만 파라미터의 정보를 모른다.
		 * 파라미터의 이름만 가져오기..
		 * Request
		 */
		req.setCharacterEncoding("utf-8");
		
		Enumeration<String> names = req.getParameterNames();
        while(names.hasMoreElements()) {
        	String name = names.nextElement();
        	System.out.println(name);
        	String[] val1 = req.getParameterValues(name);
        	for(String value : val1) {
        		System.out.println("value : " + value);
        	}

        	
        }
	}

}
