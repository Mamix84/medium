package it.mamino84.dor.core.reader.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import it.mamino84.dor.core.reader.IReader;

public class CSSResourceReader implements IReader {

	@Override
	public Object read(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readResource(String path) {
		// TODO to be dinamic
		String rootFolder = "static/css/";

		String html = "";

		ClassLoader classLoader = getClass().getClassLoader();

		File file = null;
		URL resource = classLoader.getResource(rootFolder + path);
		if (resource == null) {
			throw new IllegalArgumentException("resources is not found!");
		} else {
			file = new File(resource.getFile());
		}

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line = br.readLine();

			while (line != null) {
				html += line;
				line = br.readLine();
			}

			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return html;
	}

}
