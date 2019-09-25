/**
 * 이미지를 브라우저로 전송하기
 * 이미지는 byte 데이터다
 * getWriter() (X) - 문자출력
 * getOutputStream()
 * 
 */
package kr.co.mlec.servlet.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/basic/test07.do")
public class Test07 extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전송할 문서의 타입을 설정 - 브라우저에게 알려준다
		resp.setContentType("image/jpg");
		//얻어올 객체 
		OutputStream out = resp.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);
		
		FileInputStream fis = new FileInputStream("C:\\java\\workspace\\08_servletjsp\\src\\kr\\co\\mlec\\servlet\\basic\\jj01.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis);
		while(true) {
			int ch = bis.read();
			if(ch == -1) break;
			
			bos.write(ch);
			
		}
		bis.close();
		bos.close();
		fis.close();
		out.close();
		
		
		}
	

}
