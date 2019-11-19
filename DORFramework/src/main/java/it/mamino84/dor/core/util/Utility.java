package it.mamino84.dor.core.util;

public class Utility {

	public static String resolveClassComponent(String tag) {
		// TODO to be customizable
		String appCode = "app";
		String className = "";
		String suffix = "Component";

		if (tag.startsWith(appCode)) {
			String temp = tag.replaceAll(appCode + "-", "");
			className = temp + suffix;
		} else {
			// TODO throw exception invalidAppCode
		}

		return className;
	}
}
