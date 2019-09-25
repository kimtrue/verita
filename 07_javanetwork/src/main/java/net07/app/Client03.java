package net07.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client03 {
	public static void main(String[] args) {
		try {
			Scanner keyboard = new Scanner(System.in);
			//server 접속
			Socket client = new Socket("localhost", 10001);
			 DataInputStream dis = new DataInputStream(client.getInputStream());
			 //한글을 보내거나 쓸 때 바이트단위 처리시키기
			 DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			while(true) {
				System.out.println("메세지(종료:quit)>");
				String msg = keyboard.nextLine();
				dos.writeUTF(msg);
				if(msg.equals("quit")) break;
				String echo = dis.readUTF();
				System.out.println("서버(echo) :" + echo);
				
			}
			
			
		} catch(Exception e) {
			
		}
		
		
		
	}
	


}
	