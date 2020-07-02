package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pom.RegistrationPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import utilities.LoadProperties;

@Listeners(utilities.ListenerTest.class)			
public class RegistrationTest extends TestBase{
	
		RegistrationPage registrationpage;
		String firstname=LoadProperties.get_firstname();
		String lastname=LoadProperties.get_lastname();
		String mobile=LoadProperties.get_mobile();
		String email=LoadProperties.get_email();
		String password=LoadProperties.get_password();

	
	@Test(priority = 1)
	@Description("User Registration successfully")
	@Step("user fill in the registration form with correct data")
	public void userregisterationsuccessfully ( )  {
	    
		registrationpage= new RegistrationPage(driver);
		registrationpage.fill_registration_form(firstname,lastname,mobile,email,password);
		Http_interceptor();
		String message=registrationpage.server_errormessage.getText();
		if(message.contains("HTTP ERROR 500")) {
			System.out.println("500 !! SERVER can't handle the registration");
		}
			
		
    }
	
	
}
