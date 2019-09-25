/**
 * URL
 * HttpURLConnection
 * 
 * URL 의 형태
 * 
 * http:// www.naver.com:8888/search.naver?where=1&query=java
 * 
 * 프로토콜 : http
 * 호 스 트  : www.naver.com
 * 포      트 : 8888  
 * 패 스(path): /search.naver   html의 action과 연결.. /로 시작하면 상대경로. /로 시작하지 않는것. http로 시작하지 않으면 절대경로
 * ? 는 패스와 쿼리를 구분짓기 위한 것
 * 파라미터, 쿼리스트링 : where=1&query=java
 */
package net02.url;

import java.net.MalformedURLException;
import java.net.URL;

public class Test01 {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.abc.com:888/test.do?msg=hello");
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			//port : -1. 포트 번호를 주지 않을 때의 값
			System.out.println(url.getPort()); 
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
		} catch (Exception e) {
			/*
			 * MalformedURLException : http:// 도메인 주소가 잘못됐을 때 잡겠다
			 */
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
