package it.mamino84.dor.core.dispatcher.impl;

import java.lang.annotation.Annotation;

import it.mamino84.dor.core.component.BaseComponent;
import it.mamino84.dor.core.dispatcher.IDispatcher;
import it.mamino84.dor.core.scanner.impl.WebComponentScanner;

public class GetComponentDispatcher implements IDispatcher {

	public GetComponentDispatcher() {
		super();
	}

	@Override
	public Object dispatch(Object request) {
		String tag = (String) request;

		System.out.println(tag);

		WebComponentScanner webComponentScanner = new WebComponentScanner();

		String classComponentName = (String) webComponentScanner.searchComponent(tag);

		String html = "";
		String css = "";

		Class<BaseComponent> obj = null;
		try {
			obj = (Class<BaseComponent>) Class.forName(classComponentName).newInstance().getClass();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// TODO: add Exception for obj null
		if (obj.isAnnotationPresent(BaseComponent.class)) {
			Annotation annotation = obj.getAnnotation(BaseComponent.class);
			BaseComponent baseComponentInfo = (BaseComponent) annotation;

			tag = baseComponentInfo.tag();
			html = baseComponentInfo.html();
			css = baseComponentInfo.css();
		}

		return html;
	}

}
