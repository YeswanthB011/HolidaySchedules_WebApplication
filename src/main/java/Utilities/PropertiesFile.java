package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	public static String readProperties(String key) throws IOException {
		Properties pr = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Resources\\config.properties");
		pr.load(fis);
		String value = pr.getProperty(key);

		return value;
	}
}
