/**
 * HttpURLConnection 을 이용한 다양한 처리하기
 * 
 * - post 방식의 호출
 * - 헤더 값을 설정해야 할 때
 * 
 * 
 */
package net02.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test05 {
	public static void main(String[] args) {
		try {
			/*클라이언트*/
			/*
			 * 오류메세지 Server returned HTTP response code: 405
			 * 메서드가 올바르지 않다. 
			 */
			URL url = new URL(
					"http://localhost:8000/07_javaweb/net/url/login"
					);
			/*
			 * url 클래스는 post 방식의 요청이 없음
			 * HttpURLConnection 클래스 사용
			 */
			// URL커넥션은  HttpURL의 부모라 형변환 시켜준다
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			
			//POST 방식으로 요청하겠다 
			conn.setRequestMethod("POST");
			
			//헤더 설정하기 : 오픈 API가 주로 사용하는 방식 헤더값을 달라고 한다..
			conn.setRequestProperty("my-id", "abc123");
			
			
			//post type은 parameter가 body에 붙어간다
			//내가 전송한 아웃풋을 사용할 수 있게하겠다
			conn.setDoOutput(true);
			
			//출력하기 위한 출력객체 보내겠다
			OutputStream out = conn.getOutputStream();
			//OutputStream은 바이트만 받는다 . 문자열을 바이트로 바꿔줘야한다             
			out.write("id=test&pass=1111".getBytes("utf-8"));
			
			
			//서버의 실행된 응답코드 가져오기
			//정상이라면 code = 200
			int code = conn.getResponseCode();
			System.out.println("응답코드" + code);
			
			
			                                               //얻어오겠다
			InputStreamReader isr = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				
				
				System.out.println(line);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
