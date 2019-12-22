package it.mamino84.dor.component;

import org.springframework.stereotype.Controller;

import it.mamino84.dor.core.component.DOREvent;
import it.mamino84.dor.core.component.WebComponent;

@Controller
@WebComponent(tag = "app-input", html = "app-input.html", css = "app-input.css")
public class InputComponent {

	private String value = "OK";

	public InputComponent() {
	}

	@DOREvent
	public void eventHandler(String value) {
		this.value = value;
		System.out.println("INPUT :" + this.value);
	}

}
