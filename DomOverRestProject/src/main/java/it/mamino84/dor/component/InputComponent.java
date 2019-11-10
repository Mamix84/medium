package it.mamino84.dor.component;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mamino84.dor.core.BaseComponent;
import it.mamino84.dor.core.WebComponent;

@RestController
@BaseComponent(tag="app-input", html="app-input.html", css="app-input.css")
public class InputComponent extends WebComponent{

	public InputComponent() {
	}

	@GetMapping("/app-input")
	@Override
	public String getComponent() {
		return "<style>"+getCSS()+"</style>"
				+ getHTML();
	}
	
	@Override
	public String getHTML() {
		return "<h1>INPUT</h1>"
				+ "<input id=\"inputText\"></input>";
	}

	@Override
	public String getCSS() {
		return "#app-input h1{color:red;}";
	}

	@Override
	public String receiveEvent(String event) {
		// TODO Auto-generated method stub
		return null;
	}	
}
