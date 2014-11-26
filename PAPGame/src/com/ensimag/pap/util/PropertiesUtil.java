/**
 * 
 */
package com.ensimag.pap.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Read configuration file
 * 
 * @author truaro
 */
public class PropertiesUtil {

	private final static String path = "./configuration.properties";
	private static Properties properties = null;

	public static void initProperties() throws IOException {
		InputStream propertiesFile;

		// We use a double way to load the configuration file.
		// The first one, is when the application is launch from the jar. The
		// property file is read with no problem
		// The second one is because, with Eclipse, the standard launch does not
		// manage to find the configuration file wich is at the same level than
		// the application.
		// In this case, the configurationfile use is the one which is in the
		// src folder
		try {
			propertiesFile = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			propertiesFile = PropertiesUtil.class.getClassLoader()
					.getResourceAsStream(path.substring(2));
			if (propertiesFile == null) {
				throw new FileNotFoundException("The file : " + path
						+ " does not exist");
			}
		}

		try {
			properties = new Properties();
			properties.load(propertiesFile);
		} catch (IOException e) {
			throw new IOException("The property file : " + path
					+ " is unreadable");
		} finally {
			propertiesFile.close();
		}

	}

	public static String getProperty(String key) throws IOException {
		if (properties == null) {
			initProperties();
		}
		return properties.getProperty(key);
	}
}