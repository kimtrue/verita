package net04_xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test03 {
	public static void main(String[] args) {
		/**
		 * VO 를 만들어서 List에 담기
		 * 
		 */
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse("data/data2.xml");
			NodeList list = doc.getElementsByTagName("family");
			
			
			//List<family> 형태에 xml의 정보를 담는다
			List<Family> fList = new ArrayList<>();
			for (int i = 0; i < list.getLength(); i++) {
				Family fa = new Family();
				Node family = list.item(i);
				NodeList cList = family.getChildNodes();
//				System.out.println(cList.getLength()); //7개가 나온다. enter까지 노드에 포함되어서.. 패밀리 다음 엔터 파더 엔터 마더 엔터 앤 미
			
	            
				for (int k = 0; k < cList.getLength(); k++) {
					Node cNode = cList.item(k);
					String name = cNode.getNodeName();
			
					if (cNode.getNodeName().equals("#text")) continue; // 노드네임으로 보면 공백은 #text로 나온다
					
					switch(name) {
					case "father" : fa.setFather(cNode.getTextContent()); break;
					case "mother" : fa.setMother(cNode.getTextContent()); break;
					case "me" : fa.setMe(cNode.getTextContent()); break;
    				}

				}
				fList.add(fa);
			}
			
			//List<family>의 내용을 아래의 형식으로 출력
			/*
			 *   father      mother       me
			 * ------------------------------
			 *   다스베ㅐ이더       파드메              루크 
			 *    
			 * 
			 * ------------------------------
			 */
			
			System.out.println("  father  mother   me ");
			System.out.println("-----------------------------------");
			for(Family f : fList) {
				System.out.println(
						f.getFather() + " \t" + f.getMother() + " \t" + f.getMe()
						);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
