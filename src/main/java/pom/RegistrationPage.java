package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "firstname")
	WebElement first_name ;
	
	@FindBy(name = "lastname")
	WebElement last_name ;
	
	@FindBy(name = "phone")
	WebElement mobile_number ;
	
	@FindBy(name = "email")
	WebElement Email ;

	@FindBy(name = "password")
	WebElement Password ;
	
	@FindBy(name = "confirmpassword")
	WebElement confirm_password ;
	
	@FindBy(xpath = "//button[@type='submit' and @class='signupbtn btn_full btn btn-success btn-block btn-lg']")
	public  WebElement signup_btn ;
	
	@FindBy(xpath = "//div[@class='error-code']")
	public WebElement server_errormessage ;
	
	public void fill_registration_form (String firstname,String lastname,String mobile,String email,String password)
	{
		settext(first_name,firstname);
		settext(last_name,lastname);
		settext(mobile_number,mobile);
		settext(Email,email);
		settext(Password,password);
		settext(confirm_password,password);
		scrollToBottom();
		clickbutton(signup_btn);
	}
	
	
	
}
