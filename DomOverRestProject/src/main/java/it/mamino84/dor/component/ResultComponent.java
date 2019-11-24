package it.mamino84.dor.component;

import org.springframework.stereotype.Controller;

import it.mamino84.dor.core.component.WebComponent;

@Controller
@WebComponent(tag = "app-result", html = "app-result.html", css = "app-result.css")
public class ResultComponent {

	private String labelResult = "BEFORE EVENT";

	public ResultComponent() {
	}

	public String getLabelResult() {
		return labelResult;
	}

	public void setLabelResult(String labelResult) {
		this.labelResult = labelResult;
	}

}
