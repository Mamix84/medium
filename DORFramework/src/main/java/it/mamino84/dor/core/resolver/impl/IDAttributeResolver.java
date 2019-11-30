package it.mamino84.dor.core.resolver.impl;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import it.mamino84.dor.core.resolver.IResolver;

public class IDAttributeResolver implements IResolver {

	public IDAttributeResolver() {
		super();
	}

	public String setIdAttribute(Object webComponent, String html) {
		

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InputSource is = new InputSource(new StringReader(html));
		
		Document doc = null;
		try {
			doc = dBuilder.parse(is);
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		
		

		return html;
	}
}
