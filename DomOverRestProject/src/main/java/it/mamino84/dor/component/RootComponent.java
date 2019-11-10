package it.mamino84.dor.component;

import org.springframework.stereotype.Controller;

import it.mamino84.dor.core.BaseComponent;
import it.mamino84.dor.core.WebComponent;

@Controller
@BaseComponent(tag = "app-root", html = "app-root.html", css = "app-root.css")
public class RootComponent extends WebComponent {

	public RootComponent() {
	}

	@Override
	public String getHTML() {
		return "/views/app-root.html";
	}

	@Override
	public String getCSS() {
		return "";
	}

	@Override
	public String receiveEvent(String event) {
		// TODO Auto-generated method stub
		return null;
	}

}
