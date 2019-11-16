package it.mamino84.dor.core.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.mamino84.dor.core.dispatcher.impl.GetComponentDispatcher;
import it.mamino84.dor.core.dispatcher.impl.PostEventDispatcher;

//import it.mamino84.dor.component.RootComponent;

@RestController
public class RootRestService {

	public RootRestService() {
	}

	@GetMapping("/app")
	@ResponseBody
	public String getComponent(@RequestParam String tag) {
		
		GetComponentDispatcher rDispatcher = new GetComponentDispatcher();
		
		return (String) rDispatcher.dispatch(tag);
	}

	@PostMapping("/app")
	public Object postEvent(Object object) {
		PostEventDispatcher peDispatcher = new PostEventDispatcher();
		
		return peDispatcher.dispatch(object);
	}
}
