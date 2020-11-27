package dataDriven.XMLDriven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dataDriven.UserData;

public class XmlDataObjectGenerator {
	String file;
	List<UserData> users = new ArrayList<UserData>();
	HashMap<String, String> userValues = new HashMap<String, String>();

	public XmlDataObjectGenerator(String file) {
		this.file = file;
	}

	public XmlDataObjectGenerator makeDataObjectsFromXml() throws Exception {			
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(file);
			NodeList nodeList = document.getElementsByTagName("person");
			
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					
					
					userValues.put("lastFirst", eElement.getElementsByTagName("l_name").item(0).getTextContent()
							+ "," + eElement.getElementsByTagName("f_name").item(0).getTextContent());
					
					
					
					NodeList subjects = ((Element) eElement.getElementsByTagName("subjects").item(0)).getElementsByTagName("subject");
					List<String> subjectNames = new ArrayList<String>();
					for(int j = 0; j < subjects.getLength(); j++) {
						subjectNames.add(subjects.item(j).getTextContent());
					}
					userValues.put("subjects", String.join(";", subjectNames));
					
					
					
					
					String gender = eElement
							.getElementsByTagName("gender")
							.item(0)
							.getTextContent().equals("male") ? "M" : "F";
					userValues.put("gender", gender);
					
					
					
					String date = eElement
							.getElementsByTagName("dob")
							.item(0).getAttributes()
							.getNamedItem("month")
							.getTextContent()
							.substring(0, 3)
							+ " " + 
							eElement
							.getElementsByTagName("dob")
							.item(0).getAttributes()
							.getNamedItem("day")
							.getTextContent()
							+ " " +
							eElement
							.getElementsByTagName("dob")
							.item(0).getAttributes()
							.getNamedItem("year")
							.getTextContent();
					userValues.put("dob", date);
					
					
					
					
					NodeList contacts = eElement.getElementsByTagName("contact");
					for(int j = 0; j < contacts.getLength(); j++) {
						if(contacts.item(j)
								.hasAttributes() 
								&& 
								contacts.item(j)
								.getAttributes()
								.getNamedItem("type")
								.getTextContent()
								.equals("mobile")) {
							userValues.put("mobile", contacts.item(j).getTextContent());
						}
					}
					
					
					
					
					Node hobbies = eElement.getElementsByTagName("hobbies").item(0);
					NodeList hobbyList = hobbies != null ? ((Element) hobbies).getElementsByTagName("hobby") : null;
					String userHobby = hobbyList != null && hobbyList.getLength() > 0 ? hobbyList.item(0).getTextContent() : "";
					userValues.put("hobby", userHobby);
					
					
					
					
					Node addressInfo = eElement.getElementsByTagName("address").item(0);
					Element address = (Element) addressInfo;
					userValues.put("houseNumber", address.getElementsByTagName("house").item(0).getTextContent());
					userValues.put("street", address.getElementsByTagName("street").item(0).getTextContent());
					userValues.put("city", address.getElementsByTagName("city").item(0).getTextContent());
					userValues.put("state", address.getElementsByTagName("state").item(0).getTextContent());
					userValues.put("postalCode", address.getElementsByTagName("postalCode").item(0).getTextContent());
				}
				
				
				users.add(new UserData(userValues));
			}


			return this;

		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		throw new Exception();
	}

	public List<UserData> getUsers() {
		return users;
	}
}
