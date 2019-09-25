/**
 * 페이지 호출
 * 
 * http://localhost:8000/board/list
 * 
 * Method : GET
 * RequestURI : /board/list
 * Parameter
 * 없음
 * 
 * 
 * http://localhost:8000/login/login?id=abc&pass=1234
 * 
 * Method : GET
 * RequestURI : /login/login
 * Parameter
 * id : abc
 * pass : 1234
 */
package net08.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test05 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8000);
			while(true) {
				 Socket client = server.accept();
				 BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream(), "utf-8"));
			
				 String[] arr = br.readLine().split(" ");
				 String method = arr[0];
				 String uri = arr[1];
				 String[] uriArr = uri.split("\\?");
				 String path = uriArr[0];
				 // ?로 잘랐을 때 2개 이상이 있어야 헤더값이 존재한다는 뜻. 
				StringBuffer param = new StringBuffer();
				 if(uriArr.length != 1) {
					for(String p : uriArr[1].split("&")){
						String[] pArr = p.split("=");
						param.append("<div>" + pArr[0] + ":" + pArr[1] + "</div>");
					}
				 } else {
					 param.append("없음");
				 }
				 String msg = "<!DOCTYPE html>"
						    +"<html>"
						    +"  <head>"
						    +"      <meta charset='utf-8'>"
						    +"      <title>웹서버 구현</title>"
						    +"  </head>"
						    +"  <body>"   //시작라인 정보
						    +"      <h2>Method : "+method+ "</h2>"
						    +"      <h2>RequestURI : "+path+ "</h2>"
						    +"      <h2>Parameter : </h2>"
						    +  param.toString()
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
			e.printStackTrace();
		}
		
	}

}
