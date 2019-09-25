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

import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			//클라이언트의 요청에 응답하기
			//누군가 서버에 접속했을 때 구동한다
			System.out.println("사용자 요청 대기중..");
			while(true) {
			//접속한 사용자 알아보기
				Socket client = server.accept();
				System.out.println(client.getInetAddress());
			
			System.out.println("사용자 요청 들어옴..");
			}
			//커맨드 창  cls 화면 다 정리하기

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
