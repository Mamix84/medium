package it.mamino84.dor.component;

import org.springframework.stereotype.Controller;

import it.mamino84.dor.core.component.WebComponent;

@Controller
@WebComponent(tag = "app-input", html = "app-input.html", css = "app-input.css")
public class InputComponent {

	public InputComponent() {
	}

}
