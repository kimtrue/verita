/**
 *  출력형식 >
 *
 *   제목    ㄹ ㅣㅇ크       내용
 * ------------------------
 *   ..     ...     ...
 *   ..     ...     ...
 *   ..     ...     ...
 *   
 *
 */
package net04_xml.exam;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Quiz01 {
	public static void main(String[] args) {
		try {
			//한글로 된 것 인코딩작업 해주기. URLEncoder.encode("처리할단어", "처리할방식?utf-8")
//			System.out.println(URLEncoder.encode("자바", "utf-8"));
		   /*
			consol 자바 = %EC%9E%90%EB%B0%94
			naver 자바 = %EC%9E%90%EB%B0%94
			*/
			String blogUrl = "https://openapi.naver.com/v1/search/blog.xml";
			//query=한글 넘어가지 않는다. 한글을 인코딩해줘야한다.
			String text = URLEncoder.encode("자바", "utf-8");
			String query = "query="+text+"&display=3&start=1&sort=date";
			String blogPage = blogUrl + "?" + query;
			System.out.println(blogPage);
			//blog페이지 부르기
			URL url = new URL(blogPage);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			//사용자 인증시 사용
			con.setRequestProperty("X-Naver-Client-Id", "qbd8haQjeTzrzafAPufQ");
			con.setRequestProperty("X-Naver-Client-Secret", "bSFnEmT_jd");
			
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse(con.getInputStream());
			NodeList lList = doc.getElementsByTagName("item");
			
			List<QuizVO> qList = new ArrayList<>();
			for (int i = 0; i < lList.getLength(); i++) {
				QuizVO quiz = new QuizVO();
				Node cNode = lList.item(i);
				NodeList iList = cNode.getChildNodes();

				for (int j = 0; j < iList.getLength(); j++) {
					Node iNode = iList.item(j);
					if (iNode.getNodeName().equals("title")) { 
						if(iNode.getTextContent().contains("b")) continue;
						quiz.setTitle(iNode.getTextContent());
					} else if (iNode.getNodeName().equals("link")) {
						quiz.setLink(iNode.getTextContent());
					} else if (iNode.getNodeName().equals("description")) {
						quiz.setDescription(iNode.getTextContent());
					}
				}
				qList.add(quiz);
			}

			System.out.println(" 제목   링크     내용");
			for(QuizVO q : qList) {
				System.out.println(
						q.getTitle() + "\t" + q.getLink() + "\t" + q.getDescription()
						);
			}
			
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	
		
		
		
	}

}
