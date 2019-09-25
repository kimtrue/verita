/**
 * 크롤링 : 웹사이트가 제공하지 않는 정보를 가져올때 사용하는 기술
 *       웹페이지는 html로 되어있어서 파싱해서 가져온다 
 *       https://mvnrepository.com/search?q=jsoup 제일 최신버전을 받는다
 * 
 */
package net06.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test01 {
	public static void main(String[] args) {
		String html = "<html>"
				    +  " <head>"
				    +  "     <title>JSOUP 연습</title>"
				    +  "  </head>"
				    + "   <body>"
				    + "        <p>Parse HTML</p>"
				    + "         <div class = 'a'>클래스 접근</div>"
				    + "        <p id='b'>아이디 접근</p>"
				    + "         <div>"
				    + "           <p>div 안에 있는 p</p>"
				    + "           <a href='#1'>위로</a>"
				    + "           <a href='#2'>아래로</a>"
				    + "           <a href='#3'>중간</a>"
				    + "           <a href='http://www.naver.com'>네이버</a>"
				    + "         </div>"
				    + "   </body>"
				    + "</html>";
		
		
		Document doc = Jsoup.parse(html);
		//id 속성값으로 접근
		/*
		Element e = doc.getElementById("b");		    
		System.out.println(e.html());
		*/
		
		
		/*
		//Elements : list 배열 개념
		Elements list = doc.select("#b");
		//list니까 반복을 돌릴 수 있다
		for(Element e : list) {
			System.out.println(e.html());
		}
		
		Element list = doc.selectFirst("#b");
		System.out.println(list.html());
		
		//div 하위에 있는 a 태그들의 내용을 화면에 출력
		Elements eList = doc.select("div > a");
		for(Element e : eList) {
			System.out.println(e.html());
		}
		 */
		
		
		//a태그의 href 속성의 값이 .com으로 끝나는 것 a태그의 내용 출력
		Element e = doc.selectFirst("a[href$=.com]");
		System.out.println(e.html());
		/* 네이버 실검...
 		#PM_ID_ct > div.header > div.section_navbar 
		          > div.area_hotkeyword.PM_CL_realtimeKeyword_base
		          > div.ah_list.PM_CL_realtimeKeyword_list_base 
		          > ul:nth-child(5) > li:nth-child(1) > a.ah_a > span.ah_r
		*/
	}

}
