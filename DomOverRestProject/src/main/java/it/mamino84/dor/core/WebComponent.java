package it.mamino84.dor.core;

@BaseComponent(tag="", html="", css="")
public abstract class WebComponent {

	public abstract String getComponent();

	public abstract String receiveEvent(String event);

	public abstract String getHTML();

	public abstract String getCSS();
	
	public String loadComponent() {
	    Class<?> clazz = this.getClass();
	    if (!clazz.isAnnotationPresent(BaseComponent.class)) {

	    }

		return null;
	}
}
