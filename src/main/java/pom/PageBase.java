package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	public WebDriver driver ;

	public PageBase(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver=driver;

	}


	public static void clickbutton(WebElement button) {

		button.click();
	}

	public static void settext (WebElement text , String value) {
		
		text.sendKeys(value);
	}

	public void scrollToBottom() 
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;  
		jse.executeScript("window.scrollBy(0,2500)");
	}
	
	
}
