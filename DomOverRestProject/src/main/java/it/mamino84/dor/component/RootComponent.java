package it.mamino84.dor.component;

import org.springframework.stereotype.Controller;

import it.mamino84.dor.core.component.WebComponent;

@Controller
@WebComponent(tag = "app-root", html = "app-root.html", css = "app-root.css")
public class RootComponent {

	private String label = "COMPONENT DEMO";
	
	public RootComponent() {
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
