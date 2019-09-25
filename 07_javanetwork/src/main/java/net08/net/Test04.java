package net08.net;

public class Test04 {
	public static void main(String[] args) {
		/**
		 * 요청 URI 파싱
		 * 
		 */
		
		String startLine = "GET /board/delete.do?no=10&commentNo=1 HTTP:1.1";
		
		/*
		 * 요청 메서드 : GET
		 * 요청 페이지 : /board/delete.do
		 * 요청 파라미터
		 *  no : 10
		 *  commentNo : 1
		 * 
		 */
		
		String[] method = startLine.split(" ");
		System.out.println("요청메서드 : " + method[0]);
		
		String uri = method[1];
		// ?는 정규표현식이라
		String[] uriArr = uri.split("\\?");
		String path = uriArr[0];
		
		String parameter = uriArr[1];
		
		/*
		String[] noArr = parameter.split("&");
		String no = noArr[0];
		String[] num = no.split("=");
		System.out.println(num[1]);
		*/
		
		
		
		System.out.println("요청 페이지 : " + path );
		System.out.println("요청 파라미터 " + parameter);
		for(String param : uriArr[1].split("&")) {
//			System.out.println(param);
			String[] pArr = param.split("=");
			System.out.println(pArr[0] + " : " + pArr[1]);
		}
		
		
		
		
	}

}
