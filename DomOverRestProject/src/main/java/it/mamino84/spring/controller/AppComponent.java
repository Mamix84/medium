package it.mamino84.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mamino84.spring.core.WebComponent;

@RestController
public class AppComponent extends WebComponent{

	public AppComponent() {}
	
	@GetMapping("/app")
	public String getComponent() {
		return "<style>"+getCSS()+"</style>"
				+ getHTML();
	}

	@Override
	public String getHTML() {
		return "<app-input id=\"app-input\"></app-input>";
	}

	@Override
	public String getCSS() {
		return "";
	}	
	
}
	
