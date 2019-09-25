/**
 * 
 * 요청정보 모듈화
 * 
 * 
 * 
 * 
 */
package net08.net;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import web.util.HttpServletRequest;



public class Test06 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8000);
			while(true) {
				Socket client = server.accept();
				
				//http://localhost:8000/board/delete.do?no=100&commentNo=1
				/*
				 *   요청 메서드 : GET
				 *   요청 URI : /board/delete.do
				 *   쿼리스트링 no=100&commentNo=1
				 *   no : 100
				 *   commentNo : 1
				 *   name : null
				 */
				
				//사용자의 정보를 파싱하고 처리해야하는 클래스. 
				HttpServletRequest request= new HttpServletRequest(client.getInputStream());
				//스트림을 주면 자동적으로 파싱했을 꺼야
				String method = request.getMethod();
				String requestURI = request.getRequestURI(); //사용빈도 높음
				String queryString = request.getQueryString();
				String no = request.getParameter("no");//사용빈도 높음
				String commentNo = request.getParameter("commentNo");
				String name = request.getParameter("name");
				
				StringBuffer sb = new StringBuffer();
				sb.append("<div>요청 메서드 : "+method+"</div>");
				sb.append("<div>요청 URI : "+requestURI+"</div>");
				sb.append("<div>쿼리스트링 : "+queryString+"</div>");
				sb.append("<div>파라미터 </div>");
				sb.append("<div>no : "+no+"</div>");
				sb.append("<div>commentNo : "+commentNo+"</div>");
				
				String msg = "<!DOCTYPE html>"
					    +"<html>"
					    +"  <head>"
					    +"      <meta charset='utf-8'>"
					    +"      <title>웹서버 구현</title>"
					    +"  </head>"
					    +"  <body>"   //시작라인 정보
					    + 		 sb.toString()
					    +"  </body>"
					    +"</html>";
			
			String startLine = "HTTP/1.1 200 OK\r\n";
			
			String header = "Content-Type: text/html;charset=utf-8\r\n"
						+ "Content-Length: " + msg.getBytes("utf-8").length + "\r\n\r\n"; //공백을 위해 줄넘김 두번
			String sendData = startLine + header + msg;

			OutputStream out = client.getOutputStream();
			out.write(sendData.getBytes("utf-8"));
			out.close();
				
				
				
				
			}
		} catch (Exception e) {
			
		}
		

	}

}
