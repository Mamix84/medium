package it.mamino84.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mamino84.spring.core.WebComponent;

@RestController
public class InputComponent extends WebComponent{

	public InputComponent() {
	}

	@GetMapping("/app-input")
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
}
