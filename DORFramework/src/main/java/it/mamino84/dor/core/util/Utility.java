package it.mamino84.dor.core.util;

public class Utility {

	public static String resolveClassComponent(String tag) {
		// TODO to be customizable
		String appCode = "app";
		String className = "";
		String suffix = "Component";
		// TODO to be customizable
		String packadze = "it.mamino84.dor.component";

		if (tag.startsWith(appCode)) {
			String temp = tag.replaceAll(appCode + "-", "");
			className = packadze + "." + temp.substring(0, 1).toUpperCase() + temp.substring(1, temp.length()) + suffix;
		} else {
			// TODO throw exception invalidAppCode
		}

		return className;
	}
}
