package it.mamino84.dor.component;

import org.springframework.stereotype.Controller;

import it.mamino84.dor.core.component.WebComponent;

@Controller
@WebComponent(tag = "app-button", html = "app-button.html", css = "app-button.css")
public class ButtonComponent {

	public ButtonComponent() {
		super();
	}

	public String clickButton() {
		return "OK";
	}

}
