package net08.net.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz01 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8000);
			while(true) {
				Socket client = server.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream(), "utf-8"));
				String arr = br.readLine().split(" ")[1].split("\\?")[0];
				String msg = " ";  
				switch(arr) {
				  case "/board/list" : msg = "게시판 목록 페이지 요청"; break;
				  case "/board/delete" : msg = "게시판 삭제 페이지 요청"; break;
				  case "/board/update" : msg = "게시판 수정 페이지 요청"; break;
				  case "/board/writeForm" : msg = "게시판 등록폼 페이지 요청"; break;
				  default : msg = "요청페이지 없음"; return;
			   }
				  String sMsg = "<!DOCTYPE html>"
						    +"<html>"
						    +"  <head>"
						    +"      <meta charset='utf-8'>"
						    +"      <title>웹서버 구현</title>"
						    +"  </head>"
						    +"  <body>"   //시작라인 정보
						    + msg
						    +"  </body>"
						    +"</html>";
				
				String startLine = "HTTP/1.1 200 OK\r\n";
				
				String header = "Content-Type: text/html;charset=utf-8\r\n"
							+ "Content-Length: " + sMsg.getBytes("utf-8").length + "\r\n\r\n"; //공백을 위해 줄넘김 두번
				String sendData = startLine + header + sMsg;

				OutputStream out = client.getOutputStream();
				out.write(sendData.getBytes("utf-8"));
				out.close();
				 
				  
				  
				  
				
			}
			
			
		   
			
		} catch (Exception e) {
			
		}
		
		
		
	}

}
