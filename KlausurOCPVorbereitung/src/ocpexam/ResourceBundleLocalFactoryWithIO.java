package ocpexam;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class ResourceBundleLocalFactoryWithIO {
	
	public static void main(String[] args) {
		

		
		Properties props = new Properties();

	        try (InputStream input = new FileInputStream("config.properties")) {
	            props.load(input);

	            for (String key : props.stringPropertyNames()) {
	                System.out.println(key + " = " + props.getProperty(key));
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		
	        
	        
	        // ManualLocaleLoading
	        
	    	Locale locale = new Locale.Builder()
	                .setLanguage("en")
	                .setRegion("US")
	                .build();
			
			
	        Properties properties = new Properties();
	        String fileName = "messages_" + locale.getLanguage() + ".properties";
	        

	        try (InputStream input = new FileInputStream(fileName)) {
	            properties.load(input);
	            System.out.println(properties.getProperty("greeting"));  // Output varies by locale
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}

