package com.ceub.geduc.util;

public class StringCleanUtil {
	
	private static String REGEX_NO_ACCENT = "[^\\\\p{ASCII}]";
	
	public static String cleanString(String string) {
		String noAccent = string.replaceAll(REGEX_NO_ACCENT, "");
		String upperCase = noAccent.toUpperCase();
		return upperCase;
	}

}
