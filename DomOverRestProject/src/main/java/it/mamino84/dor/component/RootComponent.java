package it.mamino84.dor.component;

import org.springframework.stereotype.Controller;

import it.mamino84.dor.core.component.WebComponent;

@Controller
@WebComponent(tag = "app-root", html = "app-root.html", css = "app-root.css")
public class RootComponent {

	public RootComponent() {
	}

}
