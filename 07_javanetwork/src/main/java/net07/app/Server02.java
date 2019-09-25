/**
 * 소켓통신 :
 * tcp, udp
 * 
 * TCP 방식
 * Server Socket - 서버
 * Socket - 클라이언트
 * 
 */
package net07.app;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server02 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			while(true) {
			Socket client = server.accept();
			System.out.println(client.getInetAddress() + "접속");
			
			Thread.sleep(1000);
			
			//접속한 사용자에게 메세지 보내기 클라이언트의 어드레스로..
			OutputStream out = client.getOutputStream();
			out.write("반갑습니다".getBytes("utf-8"));
			out.close();
			System.out.println(client.getInetAddress() + "데이터전송 완료");
			
			}
		}catch (Exception e) {
			
		}
		
		
		
	}

}
