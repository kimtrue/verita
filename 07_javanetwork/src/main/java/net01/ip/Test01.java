/**
 * 용어
 * 
 * - 소켓 (Socket)
 *  : 컴퓨터가 연결된 통신의 끝점
 *   ▶ 소켓에 쓰는 일은 연결된 상대방에게 데이터를 전달하는 역할
 *   ▶ 소켓에서 읽는 일은 상대가 전송한 데이터를 수신
 *   ▶ 대표적인 자바에서 사용하는 소켓의 종료(TCP- 전화 신뢰성이 높다. 연결을 계속 갖고있어야하기 때문에 부하가 걸릴 수 있다, 
 *                              UDP - 편지 상대방이 없으면 중간에 데이터가 손실될 위험이 있다)
 *   ▶ TCP는 HTTP 프로토콜이 사용하는 소켓
 *   => 데이터를 주고받을 때 주 역할.. TCP 방식을 사용하게 될 것이다
 *    
 * - 호스트 (Host)
 *  : 하나의 컴퓨터에 할당된 고유 이름
 *   ▶ 인터넷에서 IP(xxx.xxx.xxx...)주소나 도메인(www.naver.com) 명
 * 
 * - 포트 (Port)
 *  : 하나의 컴퓨터에는 여러개의 서비스 제공이 가능
 *   ▶ 서비스를 구분하기 위해 포트번호를 사용
 *   ▶ 포트번호의 범위는 0~65535번 까지 가능하다(이 중 0~1024번까지는 일반적으로 시스템 포트번호)
 *   ▶  권장하는 사용 포트번호는 5000번 이후
 *   
 *   호스트는 대표전화 포트는 내선번호 
 *   
 * - java.net 패키지에서 다룰 클래스
 *  : 주소 관련(InetAddress)
 *    url관련 (URL, HttpURLConnection)
 *    TCP 소켓(ServerSocket, Socket)
 *   
 * 
 * - ip
 * - url : openapi(xml, json), 크롤링(crawling)
 * - server : mini webserver 구현해보기
 * 
 * 
 */
package net01.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {
	public static void main(String[] args) {
		//현재 내 컴퓨터의 주소 메서드 InetAddress 변수명 = InetAddress.getLocalHost();  
		try {
			InetAddress local = InetAddress.getLocalHost();
			//주소정보 toString으로 출력.btcsc-PC/203.236.209.143
			System.out.println(local);
			//주소만 출력
			System.out.println(local.getHostAddress());
			//이름만 출력
			System.out.println(local.getHostName()); 
			
			//외부사이트의 주소 얻기
			InetAddress jun = InetAddress.getByName("www.jun2food.com");
			System.out.println(jun);
			
			//사이트의 여러개의 주소를 얻고싶을때
			InetAddress[] navers = InetAddress.getAllByName("www.naver.com");
			for(InetAddress naver : navers) {
				System.out.println(naver);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
		
		
	}
	
	

}
