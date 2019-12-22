package it.mamino84.dor.core.dispatcher.impl;

import java.lang.annotation.Annotation;

import org.springframework.context.ApplicationContext;

import it.mamino84.dor.core.component.WebComponent;
import it.mamino84.dor.core.dispatcher.IDispatcher;
import it.mamino84.dor.core.dto.AppRestResponse;
import it.mamino84.dor.core.reader.impl.CSSResourceReader;
import it.mamino84.dor.core.reader.impl.HTMLResourceReader;
import it.mamino84.dor.core.resolver.impl.HTMLVariableResolver;
import it.mamino84.dor.core.resolver.impl.IDAttributeResolver;
import it.mamino84.dor.core.scanner.impl.WebComponentScanner;

public class GetComponentDispatcher implements IDispatcher {

	private ApplicationContext appContext;

	public GetComponentDispatcher(ApplicationContext appContext) {
		super();
		this.appContext = appContext;
	}

	@Override
	public Object dispatch(String tag) {
		WebComponentScanner webComponentScanner = new WebComponentScanner();

		String classComponentName = (String) webComponentScanner.searchComponent(tag);
		String view = "";
		String html = "";

		Class<WebComponent> obj = (Class<WebComponent>) appContext.getBean(classComponentName).getClass();

		AppRestResponse appRestResponse = new AppRestResponse();

		// TODO: add Exception for obj null
		if (obj.isAnnotationPresent(WebComponent.class)) {
			Annotation annotation = obj.getAnnotation(WebComponent.class);
			WebComponent baseComponentInfo = (WebComponent) annotation;

			tag = baseComponentInfo.tag();
			html = baseComponentInfo.html();
			String css = baseComponentInfo.css();

			HTMLResourceReader rReader = new HTMLResourceReader();
			html = rReader.readResource(html);

			CSSResourceReader cReader = new CSSResourceReader();
			css = cReader.readResource(css);

			HTMLVariableResolver vResolver = new HTMLVariableResolver();
			html = vResolver.variableResolve(appContext.getBean(classComponentName), html);

			IDAttributeResolver idResolver = new IDAttributeResolver();
			view = idResolver.setIdAttribute(appContext.getBean(classComponentName), html);

			appRestResponse.setId("app-root");

			if (css == null || css.isEmpty()) {
				view = html;
			} else {
				view = "<style>" + css + "</style>" + html;
			}

			appRestResponse.setHtml(view);

		}

		return appRestResponse;
	}

	@Override
	public Object dispatch(String tag, Object request) {
		// TODO Auto-generated method stub
		return null;
	}

	public ApplicationContext getAppContext() {
		return appContext;
	}

	public void setAppContext(ApplicationContext appContext) {
		this.appContext = appContext;
	}

}
