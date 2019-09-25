/**
 * 요청에 대한 규약
 * 
 * 시작라인    - 메서드 방식. get post
 *           요청메서드(GET/POST) 요청URI(/board/list(?파라미터 - 겟방식일 때)) 프로토콜버전(HTTP/1.1)
 * 헤더          - Key: value
 * ...
 * 헤더
 * 
 * 요청바디(데이터) - 요청할 때 받는 데이터.
 *                 쿼리 스트링(parameter-POST방식일 때), 파일의 내용
 *  
 *  
 */
package net08.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test02 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8000);
			while(true) {
				System.out.println("사용자 요청 대기중...");
				Socket client = server.accept();
				
				
				//사용자 요청 정보 중 시작라인과 헤더 정보 확인하기
				InputStream in = client.getInputStream();
				//줄단위로 읽기 위해
				BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
				String reqStartLine = br.readLine();
				//헤더를 읽는 버퍼를 하나 생성
				StringBuffer reqHeader = new StringBuffer();
				
				//헤더 몇개있는지 모르니까 공백전까지 읽어라
				while(true) {
					String header = br.readLine();
					//공백일 때 그만 읽어라
					if("".equals(header)) break;
					//하나의 헤더마다 줄넘김을 하도록. 구분하기 위해
					reqHeader.append(header+"<br>");
				}
				
				
				
				System.out.println("사용자 접속 됨...");
				String msg = "<!DOCTYPE html>"
						    +"<html>"
						    +"  <head>"
						    +"      <meta charset='utf-8'>"
						    +"      <title>웹서버 구현</title>"
						    +"  </head>"
						    +"  <body>"   //시작라인 정보
						    +"      <h2> "+reqStartLine+ "</h2>"
						    +"      <h2> "+reqHeader.toString()+ "</h2>"
						    +"  </body>"
						    +"</html>";
				//시작라인
				// 줄넘김을 주기 위해 \r\n 을 써준다. 헤더와 데이터를 구분짓기위해
				String startLine = "HTTP/1.1 200 OK\r\n";
				/*
				header의 이름은 정확하게 적어줘야한다 공백 조심
				html도 txt의 일종이다          text 메인타입/html서브타입 
				정보를 더 주고 싶을 때는 ; 세미콜론으로 구분
				Content-Type자리 : 서버가 브라우저에게 전송한 데이터의 정보를 알려주고 브라우저는 이것을 보고 해석한다
				
				두번째 헤더 : 컨텐트의 길이에 대한 정보를 알려줘야한다
				 */
				String header = "Content-Type: text/html;charset=utf-8\r\n"
							+ "Content-Length: " + msg.getBytes("utf-8").length + "\r\n\r\n"; //공백을 위해 줄넘김 두번
				String sendData = startLine + header + msg;
//				System.out.println(sendData);
				OutputStream out = client.getOutputStream();
				out.write(sendData.getBytes("utf-8"));
				out.close();
			}
		} catch (Exception e) {
			
		}
		
		
	}

}
