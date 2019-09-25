/**
 *    http://localhost:8000/board/list.do
 *    http://localhost:8000/board/writeform.do
 *    http://localhost:8000/board/write.do
 *    
 * 
 * 
 */
package net10.webservlet;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import web.util.FileUtil;
import web.util.HttpServeletResponse;
import web.util.HttpServlet;
import web.util.HttpServletRequest;

public class Test01 {
	public static void main(String[] args) {
		http://localhost:8000/test.do?name=chloe&msg=it%27sgoodtoseeyou
		try {
			ServerSocket server = new ServerSocket(8000);
			while (true) {
				Socket client = server.accept();
				HttpServletRequest request = new HttpServletRequest(client.getInputStream());
				HttpServeletResponse response = new HttpServeletResponse(client.getOutputStream());
				
				String uri = request.getRequestURI();
				if(uri == null) continue;
				System.out.println("요청 URI : " + uri);
				
				if("/favicon.ico".equals(uri)) continue;
				
				//css에 대한 요청
				if (uri.endsWith(".css")) {
					response.setContentType("text/css; charset=utf-8");
					PrintWriter out = response.getWriter();
					// 슬래쉬 자르고 경로를 읽어야해서
					out.println(FileUtil.readFile(uri.substring(1)));
					out.close();

					response.send();
					continue;

				}
				//이미지에대한 요청
				if (uri.endsWith(".jpg") || uri.endsWith(".jpeg") || uri.endsWith(".png") || uri.endsWith(".gif")) {
					response.setContentType("image/jpeg");
					
					byte[] buffer = FileUtil.readByteFile(uri.substring(1));
					response.sendByte(buffer);
					continue;
					
				}
				
				//부모 관계로 받아...
				HttpServlet servlet = null;
				switch(uri) {
				case "/login/loginform.do" : 
					servlet = new LoginformServlet();
					break;
				case "/login/login.do" :
					servlet = new LoginServlet();
					break;
					
				}
				if(servlet == null) {
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.println("<h1>404-FileNotFound</h1>");
					out.close();
					response.send();
					
					continue;
				}
				servlet.service(request, response);
				response.send();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
