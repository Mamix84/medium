package it.mamino84.dor.core.resolver.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import it.mamino84.dor.core.resolver.IResolver;

public class HTMLVariableResolver implements IResolver {

	public HTMLVariableResolver() {
		super();
	}

	public String variableResolve(Object webComponent, String html) {
		Field variables[] = webComponent.getClass().getDeclaredFields();
		Map<String, String> mapVariable = new HashMap<String, String>();

		for (Field variable : variables) {
			try {
				variable.setAccessible(true);
				//TODO: create annotation for input variable
				mapVariable.put(variable.getName(), (String) variable.get(webComponent));

				html = html.replaceAll("#" + variable.getName() + "#", (String) variable.get(webComponent));

			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return html;
	}

}
