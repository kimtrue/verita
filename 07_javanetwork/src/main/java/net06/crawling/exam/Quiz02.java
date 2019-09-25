package net06.crawling.exam;

import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Quiz02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("---------------------------");
			System.out.println("1. 영화 랭킹");
			System.out.println("2. 영화인 랭킹");
			System.out.println("0. 종료");
			System.out.println("---------------------------");
			System.out.print("선택 : ");
			int no = Integer.parseInt(sc.nextLine());
			try {
			switch(no) {
			case 1: 
				Document doc = Jsoup.connect("https://movie.naver.com/movie/sdb/rank/rmovie.nhn").get();
				Elements list = doc.select("tbody");
			
			

			
			
			
			
					
			case 2: Document mDoc = Jsoup.connect("https://movie.naver.com/movie/sdb/rank/rpeople.nhn").get();
					Elements pList = mDoc.select("tbody>tr");
					
					for (int i = 1; i < 11; i++) {
						Element e = pList.get(i);
						System.out.println(
//								i + bList.get(i).html() +  nList.get(i).html()
							i +	e.selectFirst("tbody tr>td.birth").text() + e.selectFirst("td.title > a").text()

						);
					}
								
			case 0: System.out.println("프로그램을 종료합니다");
				    System.exit(0);
				
				
			default : System.out.println("잘못된 번호입니다"); continue;	
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
		
	}

}
