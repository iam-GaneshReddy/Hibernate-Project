package com.scaleupindia.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {
	 private static final Properties properties =new Properties();
	    private static final PropertiesConfig propertiesConfig=new PropertiesConfig();

	    private PropertiesConfig() {
	        try (FileReader fileReader2 = new FileReader("C:\\Users\\bbbb\\Desktop\\Hibernate\\Demo3\\src\\main\\resources\\message.propertiess")) {
	            	  properties.load(fileReader2);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
	      public static PropertiesConfig getInstance(){
	        return propertiesConfig;
	      }
	       public static String getProperty(String key){
	            return properties.getProperty(key);
	        }

}
