package net08.net;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test03 {
	public static void main(String[] args) throws Exception {
		
		/**
		 * 디코딩 : 변화된 데이터를 원 데이터로 바꾸기
		 * 서버에서 사용자가 한글로 보내줬다면 
		 * 인코딩 된 것을 원상태로 돌리기
		 * 
		 */
		
		
		String msg = "자바";
		String encode = URLEncoder.encode(msg, "utf-8");
		System.out.println(encode);
		
		
		//디코딩하기
		String decode = URLDecoder.decode(encode, "utf-8");
		System.out.println(decode);
		
		
		
	}

}
