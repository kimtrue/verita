package net06.crawling.exam;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Quiz01 {
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://www.daum.net/").get();
			Elements list = doc.select("ul.list_weather>li");
//			System.out.println(list.size());
			for (Element e : list) {
				System.out.println(e.select("span.txt_part").html() 
						+ "\t" + e.select("span.txt_temper").html()
						+ e.select(".ir_wa").html());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
