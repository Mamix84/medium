package it.mamino84.dor.core.dispatcher;

public interface IDispatcher {

	public Object dispatch(String tag);
	
	public Object dispatch(String tag, Object request);
}
