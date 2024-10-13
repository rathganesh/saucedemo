package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	FileReader fileReader;
	Properties properties;
	String propertiesFileLocation = System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties";
	
	public String getPropertiesFileValue(String propertyKey) throws IOException {
		fileReader = new FileReader(propertiesFileLocation);
		Properties properties = new Properties();
		properties.load(fileReader);
		
		return properties.getProperty(propertyKey);
	}
	
	
}
