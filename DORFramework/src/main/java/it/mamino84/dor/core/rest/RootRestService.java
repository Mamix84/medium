package it.mamino84.dor.core.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.mamino84.dor.core.dispatcher.impl.GetComponentDispatcher;
import it.mamino84.dor.core.dispatcher.impl.PostEventDispatcher;
import it.mamino84.dor.core.dto.AppRestResponse;

//import it.mamino84.dor.component.RootComponent;

@RestController
public class RootRestService {

	Logger logger = LoggerFactory.getLogger(RootRestService.class);

	@Autowired
	private ApplicationContext appContext;

	public RootRestService() {
	}

	@GetMapping("/app")
	@ResponseBody
	public AppRestResponse getComponent(@RequestParam String tag) {
		logger.debug("Start getComponent method");

		GetComponentDispatcher rDispatcher = new GetComponentDispatcher(appContext);
		AppRestResponse response = (AppRestResponse) rDispatcher.dispatch(tag);
		
		logger.debug("End getComponent method");
		return response;
	}

	@PostMapping("/app")
	public String postEvent(Object object) {
		logger.debug("Start postEvent method");
		PostEventDispatcher peDispatcher = new PostEventDispatcher();

		String response = (String) peDispatcher.dispatch(object);
		
		logger.debug("End postEvent method");
		return response;
	}
}
