/**
 * URL을 통해서 연결된 사이트의 데이터를 읽기
 * 
 */
package net02.url;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Test02 {
	private static void test01() throws Exception {
		URL url = new URL("http://www.naver.com");
		/*stream 데이터를 주고받는 통로
		  url이 연결한 주소를 읽겠다
		  html이 text로 넘어온다
		*/
		InputStream in = url.openStream();
		/*
		 * 한글이 깨지기때문에 InputStreamReader로 읽어준다 
		 */
		InputStreamReader isr = new InputStreamReader(in);
		while(true) {
			int ch = in.read();
			if(ch == -1) {
				break;
			}
			System.out.print((char)ch);
	
		}
	}

	private static void test02() throws Exception {
		/*
		 * 한글이 깨지기때문에 InputStreamReader로 읽어준다
		 */

		URL url = new URL("https://www.naver.com");
		InputStream in = url.openStream();
		InputStreamReader isr = new InputStreamReader(in);
		while (true) {
			int ch = isr.read();
			if (ch == -1) {
				break;
			}
			System.out.print((char)ch);

		}
	}
		private static void test03() throws Exception {
			/*
			 * BufferedReader를 사용해 속도향상
			 * readLine();으로 한 줄 읽기
			 */
			
			URL url = new URL("https://www.naver.com");
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader bfr = new BufferedReader(isr);
			while (true) {
				String line = bfr.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
				
			}
			
			
		
		
		
		
//		InputStream in2 = new FileInputStream("a.txt");
		
	}
	
	public static void main(String[] args) {
		try {
//			test01();
//			test02();
			test03();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
