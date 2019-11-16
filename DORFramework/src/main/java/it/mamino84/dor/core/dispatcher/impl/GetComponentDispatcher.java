package it.mamino84.dor.core.dispatcher.impl;

import java.lang.annotation.Annotation;

import it.mamino84.dor.core.component.WebComponent;
import it.mamino84.dor.core.dispatcher.IDispatcher;
import it.mamino84.dor.core.reader.impl.CSSResourceReader;
import it.mamino84.dor.core.reader.impl.HTMLResourceReader;
import it.mamino84.dor.core.scanner.impl.WebComponentScanner;

public class GetComponentDispatcher implements IDispatcher {

	public GetComponentDispatcher() {
		super();
	}

	@Override
	public Object dispatch(Object request) {
		String tag = (String) request;

		WebComponentScanner webComponentScanner = new WebComponentScanner();

		String classComponentName = (String) webComponentScanner.searchComponent(tag);

		String html = "";
		String css = "";

		String view = "";

		Class<WebComponent> obj = null;
		try {
			obj = (Class<WebComponent>) Class.forName(classComponentName).newInstance().getClass();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// TODO: add Exception for obj null
		if (obj.isAnnotationPresent(WebComponent.class)) {
			Annotation annotation = obj.getAnnotation(WebComponent.class);
			WebComponent baseComponentInfo = (WebComponent) annotation;

			tag = baseComponentInfo.tag();
			html = baseComponentInfo.html();
			css = baseComponentInfo.css();

			HTMLResourceReader rReader = new HTMLResourceReader();
			html = rReader.readResource(html);

			CSSResourceReader cReader = new CSSResourceReader();
			css = cReader.readResource(css);

			if (css == null || css.isEmpty()) {
				view = html;
			} else {
				view = "<style>" + css + "</style>" + html;
			}
		}

		return view;
	}

}
