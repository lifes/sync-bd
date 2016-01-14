package com.hikvision.syncbd.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	//find resouce in classpath
	public static Properties in(String filename) {
		InputStream inputStream = ConfigReader.class.getClassLoader()
				.getResourceAsStream(filename);
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			inputStream.close();
			return properties;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("load properties error");
		}
	}
}
