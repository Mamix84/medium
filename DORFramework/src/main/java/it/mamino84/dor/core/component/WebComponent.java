package it.mamino84.dor.core.component;

import java.lang.annotation.Annotation;

@BaseComponent(tag = "", html = "", css = "")
public abstract class WebComponent {

	public abstract String receiveEvent(String event);

	public abstract String getHTML();

	public abstract String getCSS();

	public String getComponent() {

		String tag = "";
		String html = "";
		String css = "";

		Class<BaseComponent> obj = (Class<BaseComponent>) this.getClass();

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
