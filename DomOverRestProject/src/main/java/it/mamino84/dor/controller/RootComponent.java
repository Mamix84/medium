package it.mamino84.dor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mamino84.dor.core.BaseComponent;
import it.mamino84.dor.core.WebComponent;

@RestController
@BaseComponent(tag="root", html="app-root.html", css="app-root.css")
public class RootComponent extends WebComponent {

	public RootComponent() {
	}

	@RequestMapping("/app-root")
	@Override
	public String getComponent() {
		//return "<style>" + getCSS() + "</style>" + getHTML();
		return super.loadComponent();
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
