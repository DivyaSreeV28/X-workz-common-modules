package com.xworkz.springcm.temple.utility;

import org.apache.log4j.Logger;

public class GenerateRandomPassword {

	public GenerateRandomPassword() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}
	
	private static final Logger logger=Logger.getLogger(GenerateRandomPassword.class);

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@$*";
	
	public static String generatePassword() {
		try {
			StringBuilder builder = new StringBuilder();
			int count = 8;
			while (count-- != 0) {
				int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
				builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			}
			return builder.toString();
		} catch (Exception e) {
			logger.error("Exception in generating password ", e);
		}
		return null;
	}
	
}
