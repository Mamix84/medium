package it.mamino84.dor.core.dispatcher.impl;

import it.mamino84.dor.core.dispatcher.IDispatcher;

public class PostEventDispatcher implements IDispatcher {

	public PostEventDispatcher() {
		super();
	}

	@Override
	public Object dispatch(Object request) {
		System.out.println("POST EVENT OK");
		
		
		
		
		return "ok";
	}

}
