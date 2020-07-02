package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	// Load the properties file from the folder
		public static Properties userData =  
				loadProperties(ConstantPaths.PROPERTIES_DIRECTORY); 
		


	    public static String get_Url() {
	        String url = userData.getProperty("url");
	        if(url != null) return url;
	        else throw new RuntimeException("[Error] - url not specified in the  data.properties file");
	    }
	    
	    public static String get_firstname() {
	        String firstname = userData.getProperty("firstname");
	        if(firstname != null) return firstname;
	        else throw new RuntimeException("[Error] - firstname not specified in the  data.properties file");
	    }

	    public static String get_lastname() {
	        String lastname = userData.getProperty("lastname");
	        if(lastname != null) return lastname;
	        else throw new RuntimeException("[Error] - lastname not specified in the  data.properties file");
	    }
	    
	    public static String get_mobile() {
	        String mobile = userData.getProperty("mobile");
	        if(mobile != null) return mobile;
	        else throw new RuntimeException("[Error] - mobile not specified in the  data.properties file");
	    }
	    
	    public static String get_email() {
	        String email = userData.getProperty("email");
	        if(email != null) return email;
	        else throw new RuntimeException("[Error] - email not specified in the  data.properties file");
	    }
	    
	    public static String get_password() {
	        String password = userData.getProperty("password");
	        if(password != null) return password;
	        else throw new RuntimeException("[Error] - password not specified in the  data.properties file");
	    }
		private static Properties loadProperties(String path)
		{
			Properties pro = new Properties();
			try {
				FileInputStream stream = new FileInputStream(path);
				pro.load(stream);
			} catch (FileNotFoundException e) {
			System.out.println("Error occurred :  " + e.getMessage());
			} catch (IOException e) {
				System.out.println("Error occurred :  " + e.getMessage());
			} 
			catch (NullPointerException e) {
				System.out.println("Error occurred :  " + e.getMessage());
			} 
		
			return pro; 
		}
	
}
