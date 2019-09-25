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
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import web.util.HttpServeletResponse;
import web.util.HttpServletRequest;



public class Test07 {
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
					String msg = "<!DOCTYPE html>"
								+"<html>"
								+"  <head>"
								+"      <meta charset='utf-8'>"
								+"      <title>웹서버 구현</title>"
								+"  </head>"
								+"  <body>"
								+"     <h2>응답 결과 보내기 모듈화</h2>"
								+"  </body>"
								+"</html>";
				HttpServeletResponse response = new HttpServeletResponse(client.getOutputStream());
				// 사용자에게 전송할 문서의 타입을 설정
				response.setContentType("text/html;charset=utf-8");

			    //사용자에게 출력할 내용을 저장할 출력객체
				PrintWriter out = response.getWriter();
			    //출력할 문자를 직접 주면 알아서 출력
				out.println(msg);
				out.close();	
				// 사용자가 설정한 msg를 화면으로 전송
				response.send();

			}
		} catch (Exception e) {

		}

	}

}