package net06.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test02 {
	public static void main(String[] args) {
		//web 사이트를 직접 접근할 때
		//get을 해 주면 파싱해서 접근이 가능해진다
		
			try {
				Document doc = Jsoup.connect("http://www.naver.com").get();
//				System.out.println(doc.html());
// 갖고오기         <ul class="ah_l"> 
//		         <li class="ah_item"> <a href="#" class="ah_a" data-clk="lve.keyword"> <span class="ah_r">1</span> <span class="ah_k">오퀴즈 천만원이벤트</span> </a> </li>
				Elements list = doc.select("ul.ah_l >  li.ah_item > a[href='#']");
//				System.out.println(list.size());
				for(Element e : list) {
//					System.out.println(e.html());
//					Elements sList = e.select("span");
//					System.out.println(sList.get(0).html() + "\t" + sList.get(1).html());
					System.out.println(e.text());
					
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}
