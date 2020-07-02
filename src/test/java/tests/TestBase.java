package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import ru.yandex.qatools.allure.annotations.Step;
import utilities.ConstantPaths;
import utilities.Helper;
import utilities.LoadProperties;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;

@Listeners(utilities.ListenerTest.class)			
public class TestBase {

	public static WebDriver driver ;
	String URL=LoadProperties.get_Url();

	@BeforeSuite 
	@Step("open the registration page")
	public void startdriver() {
	
		System.setProperty("webdriver.chrome.driver", ConstantPaths.DRIVERS_DIRECTORY+"chromedriver.exe");
		
        driver = new ChromeDriver();

		
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(URL);
		
		
		

	}
	

	@AfterSuite
	public void stopdriver() {
		driver.quit();

	}
	
	
	@AfterMethod
	public void screenshotonfailure(ITestResult result) {
		
		if(result.getStatus() ==ITestResult.FAILURE) {
			System.out.println("Failed !");
			System.out.println("taking screenshot .. ");
			Helper.capturescreenshoot(driver, result.getName());
			driver.quit();
			
		}
		
	}
	
  public void Http_interceptor() {
	  HttpRequestInterceptor requestInterceptor = new HttpRequestInterceptor() {
	         @Override
	         public void process(HttpRequest request, HttpContext context) throws
	         HttpException, IOException {
	            if(request.containsHeader("sample-header")) {
	               System.out.println("Contains header sample-header, removing it..");
	               request.removeHeaders("sample-header"); 
	            }
	            //Printing remaining list of headers
	            Header[] headers= request.getAllHeaders();
	            for (int i = 0; i<headers.length;i++) {
	               System.out.println(headers[i].getName());
	            }
	         }
	      };
	      
	      CloseableHttpClient httpclient =
	    	      HttpClients.custom().addInterceptorFirst(requestInterceptor).build();
	      String currenturl=driver.getCurrentUrl();
	      HttpPost httppost1 = new HttpPost(currenturl);
	      System.out.println("Request Type: "+httppost1.getMethod());
	      try {
			@SuppressWarnings("unused")
			HttpResponse httpresponse = httpclient.execute(httppost1);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	      
	      HttpResponse httpresponse = null;
		try {
			httpresponse = httpclient.execute(httppost1);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	      System.out.println(httpresponse.getStatusLine());

	  
  }


}
