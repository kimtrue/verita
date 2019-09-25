package net07.app;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client01 {
	public static void main(String[] args) {
		try {
			//1. (서버의 주소 , 동작하고 있는 포트 번호)
			Socket client = new Socket("203.236.209.10", 10001);
			System.out.println("서버접속 성공");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}

}
