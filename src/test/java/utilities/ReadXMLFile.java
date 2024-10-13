package utilities;

import java.io.File;
import java.util.HashMap;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class ReadXMLFile {
	public HashMap<String, Object> testData = new HashMap<String, Object>();
	public String user;
	public HashMap<String, Object> readXMLValue(String xmlFilePath) {
		try {
			File fXmlFile = new File(xmlFilePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("user");
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				try {
					Element eElement = (Element) nNode;
					if(eElement.getAttribute("name").toString().equals(user)) {
						testData.put("name", eElement.getAttribute("name"));
						testData.put("password",eElement.getElementsByTagName("password")
								.item(0).getTextContent());
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testData;
	}
}
