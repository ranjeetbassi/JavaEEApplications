package Sheridan;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/*
 * Name: Ranjeet Bassi
 * Assignment 3
 * Due Date: November 17,2012
 */
public class AddressBook {

	public ArrayList<Contact> contactList;
	private Document domAddressBookDocument;

	public AddressBook() {
		contactList = new ArrayList<Contact>();
	}

	public ArrayList<Contact> getContactList() {
		return contactList;
	}

	public void load(String fullFilePath) throws ParserConfigurationException,
			SAXException, IOException {
		// create the DOM parser
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder parser = docBuilderFactory.newDocumentBuilder();
		InputSource xmlFileSource = new InputSource("file:///" + fullFilePath);

		// ask the parser to parse file and store it in memory
		domAddressBookDocument = parser.parse(xmlFileSource);
		// go through the DOM and read contact information
		// and create contact model objects to encapsulate it
		fillContactList();
	}

	private void fillContactList() {
		// get all of the nodes (or elements or tags) called "contact"
		NodeList contactNodeList = domAddressBookDocument
				.getElementsByTagName("contact");
		// loop through all the contact nodes in the XML document
		for (int iContact = 0; iContact < contactNodeList.getLength(); iContact++) {
			Element contactElem = (Element) contactNodeList.item(iContact);
			// read the ID and TYPE attributes (potentially useful for
			// Assignment 3)
			int id = Integer.parseInt(contactElem.getAttribute("id"));
			byte type = Byte.parseByte(contactElem.getAttribute("type"));
			// read the name child element using the child index
			// index is 1 because the first child is a text data child
			Element nameElem = (Element) contactElem.getChildNodes().item(1);
			String name = nameElem.getTextContent();

			// Another way to get a child node
			Element emailElem = (Element) contactElem.getElementsByTagName(
					"email").item(0);
			String email = emailElem.getTextContent();

			// phone
			Element phoneElem = (Element) contactElem.getElementsByTagName(
					"phone").item(0);
			String phone = phoneElem.getTextContent();

			// address
			Element addressElem = (Element) contactElem.getElementsByTagName(
					"address").item(0);
			String address = addressElem.getTextContent();
			Contact contact = new Contact();
			contact.setName(name);
			contact.setEmail(email);
			contact.setPhone(phone);
			contact.setAddress(address);
			contactList.add(contact);
		}
	}

	public void changeContactEmail(String name, String newEmail,
			String newPhone, String newAddress) {
		// locate the contact element that needs to be changed
		NodeList contactNodeList = domAddressBookDocument
				.getElementsByTagName("contact");
		for (int i = 0; i < contactNodeList.getLength(); i++) {
			Element contact = (Element) contactNodeList.item(i);
			NodeList nodes = contact.getChildNodes();
			Element nameElement = (Element) nodes.item(1);
			NodeList nameList = nameElement.getChildNodes();
			Text nameText = (Text) nameList.item(0);
			String oldname = nameText.getData();
			if (oldname.equals(name)) {
				// remember - In the contact nodes it goes
				// #text:<name></name>:#text:<email></email>!
				// the parser sees whitespace even if we don’t
				Element emailElement = (Element) nodes.item(3);
				NodeList emailList = emailElement.getChildNodes();
				Text emailText = (Text) emailList.item(0);
				if (!newEmail.isEmpty())
					emailText.setData(newEmail);
				Element phoneElement = (Element) nodes.item(5);
				NodeList phoneList = phoneElement.getChildNodes();
				Text phoneText = (Text) phoneList.item(0);
				if (!newPhone.isEmpty())
					phoneText.setData(newPhone);
				Element addressElement = (Element) nodes.item(7);
				NodeList addressList = addressElement.getChildNodes();
				Text addressText = (Text) addressList.item(0);
				if (!newAddress.isEmpty())
					addressText.setData(newAddress);
				break;
			}
		}
		refreshContactList();
	}

	private void refreshContactList() {
		contactList.clear();
		fillContactList();
	}

	public void save(String fullFilePath) throws FileNotFoundException,
			TransformerFactoryConfigurationError, TransformerException {
		TransformerFactory transFactory = TransformerFactory.newInstance();
		Transformer transformer = transFactory.newTransformer();
		// setup the DOM source
		DOMSource domSource = new DOMSource(domAddressBookDocument);
		// setup the destination for the transformation
		StreamResult xmlStream = new StreamResult(new PrintWriter(
				new FileOutputStream(fullFilePath)));
		// execute the transformation
		transformer.transform(domSource, xmlStream);

	}

}
