package net07.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client02 {
	public static void main(String[] args) {
		try {
			Socket client = new Socket("localhost", 10001);
			InputStream in = client.getInputStream();
			// 인풋 스트림으로 들어온것이 바이트 이기 때문에 깨진다. 리더로 읽어서 깨짖 ㅣ않게 해줘라
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			System.out.println("서버의 메세지 대기중");
			String msg = br.readLine();
			System.out.println("서버에서 전송된 데이터 : " + msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
	}

}
