package xml.assignment;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.*;

import org.w3c.dom.Document;

//import org.w3c.dom.NodeList;
//import org.w3c.dom.Node;
//import org.w3c.dom.Element;
//import org.w3c.dom.xpath.*;

public class transformer {

	public static void main(String argv[]) {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		try {
			File stylesheet = new File(argv[0]);
			File datafile = new File(argv[1]);


			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(datafile);

            TransformerFactory tFactory = TransformerFactory.newInstance();
			StreamSource stylesource = new StreamSource(stylesheet);
			Transformer trans = tFactory.newTransformer(stylesource);

            StreamResult result = new StreamResult(System.out);
            trans.transform(stylesource, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// try {
// DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
// DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
// File xmlFile = new File("src/xml/assignment/site.xml");
// Document doc = dBuilder.parse(xmlFile);
// doc.getDocumentElement().normalize();
// String r = doc.getDocumentElement().getNodeName();
// System.out.println(r); // --> "views"
//
// String site_i = doc.getDocumentElement().getAttribute("id");
// String site_n = doc.getDocumentElement().getAttribute("name");
//
//
// System.out.println(site_i);
// System.out.println(site_n);
// NodeList views;
// views = doc.getElementsByTagName("views");
//
// int viewCount = views.getLength();
//
// for (int i = 0; i < viewCount; i++) {
//
// Node viewNode = views.item(i);
// short nodeType = viewNode.getNodeType();
// if (nodeType == Node.ELEMENT_NODE) {
// Element view = (Element) viewNode;
//
// String id = view.getAttribute("id");
// String name = view.getAttribute("name");
//
// Node dNode = view.getElementsByTagName("description").item(0);
// Node c1Node = view.getElementsByTagName("component").item(0);
// Node c2Node = view.getElementsByTagName("component").item(1);
//
// Element desc = (Element) dNode;
// Element comp1 = (Element) c1Node;
// Element comp2 = (Element) c2Node;
//
// String d = desc.getTextContent();
// String c1 = comp1.getTextContent();
// String c2 = comp2.getTextContent();
//
// System.out.println(d);
// System.out.println(c1);
// System.out.println(c2);
//
//
// }
//
// }
//
// } catch (Exception e) {
// e.printStackTrace();
// }
//
// }
// }
