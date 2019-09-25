package net07.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server03 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10001);
			 while(true) {
				 Socket client = server.accept();
				
				 //한글을 받을 때 바이트단위 처리시키기
				 DataInputStream dis = new DataInputStream(client.getInputStream());
				 //한글을 보내거나 쓸 때 바이트단위 처리시키기
				 DataOutputStream dos = new DataOutputStream(client.getOutputStream());
				 
				 //클라이언트가 quit 할 때 까지 계속 돌아야하니까ㅣ
				 while(true) {
				 String msg = dis.readUTF();
				  if(msg.equals("quit")) break;
				  
				 dos.writeUTF(msg);
				 }
				System.out.println("클라이언트 에코 종료");
				 //빠져나가고 다음 사용자 받기
			 }
			
			
		} catch (Exception e) {
			
		}
	}

}
