package it.mamino84.dor.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import it.mamino84.dor.component.RootComponent;

@RestController
public class AppRestService {

	public AppRestService() {
	}

	@GetMapping("/app")
	@ResponseBody
	public String getComponent(@RequestParam String tag) {
		
		//RootComponent root = new RootComponent();
		
		return null;//root.getComponent();
	}

	@PostMapping("/app")
	public Object postEvent(Object object) {
		return null;
	}
}
