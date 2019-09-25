package net04_xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test02 {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse("data/data2.xml");
			NodeList list = doc.getElementsByTagName("family");
			for (int i = 0; i < list.getLength(); i++) {
				Node family = list.item(i);
				NodeList cList = family.getChildNodes();
//				System.out.println(cList.getLength()); //7개가 나온다. enter까지 노드에 포함되어서.. 패밀리 다음 엔터 파더 엔터 마더 엔터 앤 미
				for (int k = 0; k < cList.getLength(); k++) {
					Node cNode = cList.item(k);
					String name = cNode.getNodeName();
					if (cNode.getNodeName().equals("#text")) continue; // 노드네임으로 보면 공백은 #text로 나온다
					System.out.println(name + " - " + cNode.getTextContent());

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
