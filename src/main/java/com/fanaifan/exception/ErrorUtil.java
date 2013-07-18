package com.fanaifan.exception;

import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author zhangpeng
 * 
 */
public class ErrorUtil {

	public static String readValue(String key) {
		Properties props = new Properties();
		try {
			InputStream in = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("/error.properties");
			props.load(in);
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
