/**
 * open API의 결과(xml)를 받아서 원하는 데이터를 추출하기 DOM parser를 이용해서 
 * 
 */
package net04_xml;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Test04 {
	public static void main(String[] args) {
		try {

			String text = "https://developers.naver.com/notice";
            String apiURL = "https://openapi.naver.com/v1/util/shorturl.xml?url=" + text;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", "qbd8haQjeTzrzafAPufQ");
			con.setRequestProperty("X-Naver-Client-Secret", "bSFnEmT_jd");
			
			
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			//inputStream 을 통해서 별도로 저장해서 읽는 작업이 필요 없다
			Document doc = parser.parse(con.getInputStream());
			//단축 url 정보 .
			/*
			 * url의 이름을 갖고있는 노드리스트 의 0번째의 것의 내용을 뽑는다
			 * 
			 */
			System.out.println(doc.getElementsByTagName("url").item(0).getTextContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
