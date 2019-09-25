/**
 * 웹서버와 통신하기 위한 규약
 * http 프로토콜(protocol) 서로 간의 약속
 *  a : 클라이언트 /  b: 서버
 * 1. a - > b  : 요청보냄
 *  Request(요청) 
 *  요청시 약속
 *   : 3가지 파트로 구분된다
 *   - 첫 줄 시작 파트 : 
 *   - 헤더 : 
 *   - 데이터 파트  : 작성한 html  
 *     
 * 2. b - > a : 응답     
 *  Response(응답)
 *  응답시 약속
 *  - 시작 라인 파트는 첫 줄이다. 
 *    a
 *    b
 *    c
 *    d
 *  - 줄이 있다면 a가 시작 나머지는 헤더. 
 *  - 헤더는 여러줄이 될 수 있다
 *  - 헤더와 데이터를 구분 짓기 위해 비어있는 한 줄을 준다
 *  - 빈 줄 이후에 나오는 것은 데이터
 *  
 *    
 * 3. 시작 라인 !     프로토콜버전(HTTP1.1)공백 상태코드 공백 응답메세지
 *  - 먼저, 프로토콜 버전이 나와야 한다
 *  - 공백을 주고 응답이 제대로 되는지 응답상태코드를 줘야한다. (정상 : 200/ 에러 : 500/ page not found : 404)
 *  - 상태코드에 대한 응답 메세지를 줘야한다  
 *  
 *  => HTTP/1.1 200 ok
 *  
 * 4. 헤더
 *   어떠한 정보가 있는지 서버에 알려준다
 *   브라우져에 보이지 않으니 숨기고 싶은 내용을 담는다.
 *    
 *     
 *  => key이름:값  
 *  
 *  
 */
package net08.net;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test01 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8000);
			while(true) {
				System.out.println("사용자 요청 대기중...");
				Socket client = server.accept();
				System.out.println("사용자 접속 됨...");
				String msg = "<!DOCTYPE html>"
						    +"<html>"
						    +"  <head>"
						    +"      <meta charset='utf-8'>"
						    +"      <title>웹서버 구현</title>"
						    +"  </head>"
						    +"  <body>"
						    +"      <h2> 직접 만든 서버에서 응답...</h2>"
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
				System.out.println(sendData);
				OutputStream out = client.getOutputStream();
				out.write(sendData.getBytes("utf-8"));
				out.close();
			}
		} catch (Exception e) {
			
		}
		
		
	}

}
