package Sheridan;

import java.io.IOException;
import java.io.PrintWriter;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * Name: Ranjeet Bassi
 * Assignment 3
 * Due Date: November 17,2012
 */
public class MySAXContentHandler extends DefaultHandler {

	private Locator loc;
	private PrintWriter out;
	StringBuffer globalData = new StringBuffer();

	public MySAXContentHandler(PrintWriter writer) throws IOException {
		out = writer;
	}

	public void msg(Object o) {
		out.print(o);
	}

	public void setDocumentLocator(Locator locator) {
		loc = locator;
		msg("Location:" + loc.getLineNumber() + ":" + loc.getColumnNumber()
				+ "<br/>");
	}

	public void characters(char[] ch, int start, int length) {
		// this method may be called many times because
		// character data may not arrive all at once
		String seen = new String(ch, start, length).trim();
		globalData.append(seen);
	}

	public void endDocument() throws SAXException {
		msg("endDocument fired<br/>");
	}

	public void endElement(String ns, String localName, String qName)
			throws SAXException {
		if (globalData.length() > 0) {
			msg("Data=" + globalData.toString() + "<br />");
			globalData.delete(0, globalData.length());
		}
		msg("<br />End element: Namespace URI=" + ns + "<br />");
		msg("Simple name=" + localName + "<br />");
		msg("Qualified name with prefix=" + qName + "</blockquote>");
	}

	public void endPrefixMapping(String prefix) {
		msg("Name space end scope:" + prefix);
	}

	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		msg("Ignorable white space:[" + new String(ch, start, length)
				+ "]<br/>");
	}

	public void processingInstruction(String target, String data) {
		msg("PI:" + target + "=" + data);
	}

	public void skippedEntity(String name) {
		msg("Skipped entity:[" + name + "]<br/>");
	}

	public void startDocument() throws SAXException {
		msg("startDocument fired<br/>");
	}

	public void startElement(String ns, String localName, String qName,
			Attributes attrs) throws SAXException {
		if (globalData.length() > 0) {
			msg("Data=" + globalData.toString() + "<br />");
			globalData.delete(0, globalData.length());
		}
		msg("<blockquote>Start element: Namespace URI=" + ns + "<br />");
		msg("Simple name=" + localName + "<br />");
		msg("Qualified name with prefix=" + qName + "<br />");
		if (attrs.getLength() > 0) { // has attributes
			for (int i = 0; i < attrs.getLength(); ++i) {
				msg("Attribute:" + attrs.getLocalName(i) + "="
						+ attrs.getValue(i) + ":" + attrs.getType(i) + "<br />");
			}
			msg("<br />");
		}
	}

	public void startPrefixMapping(String prefix, String uri) {
		msg("Name space open scope:" + prefix + "=" + uri);
	}

}
