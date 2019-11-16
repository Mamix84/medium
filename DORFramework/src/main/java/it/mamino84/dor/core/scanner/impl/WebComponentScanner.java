package it.mamino84.dor.core.scanner.impl;

import it.mamino84.dor.core.scanner.IScanner;
import it.mamino84.dor.core.util.Utility;

public class WebComponentScanner implements IScanner {

	@Override
	public Object search(Object component) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object searchComponent(String tag) {

		String className = Utility.resolveClassComponent(tag);

		return className;
	}

}
