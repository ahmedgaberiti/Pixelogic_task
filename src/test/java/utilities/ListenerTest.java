package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import ru.yandex.qatools.allure.annotations.Attachment;
import tests.TestBase;

import java.util.List;
import java.util.Map;

public class ListenerTest extends TestBase implements ITestListener , IReporter{

	 @Override		
	    public void onFinish(ITestContext Result) 					
	    {		
	                		
	    }		

	    @Override		
	    public void onStart(ITestContext Result)					
	    {		
	            		
	    }		

	    @Override		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	    {		
	    		
	    }		

	    // When Test case get failed, this method is called.		
	    @Override		
	    public void onTestFailure(ITestResult Result) 					
	    {		
	    System.out.println("The name of the testcase failed is :"+Result.getName());					
	    }		

	    // When Test case get Skipped, this method is called.		
	    @Override		
	    public void onTestSkipped(ITestResult Result)					
	    {		
	    System.out.println("The name of the testcase Skipped is :"+Result.getName());					
	    }		

	    // When Test case get Started, this method is called.		
	    @Override		
	    public void onTestStart(ITestResult Result)					
	    {		
	    System.out.println(Result.getName()+" test case started");					
	    }		

	    // When Test case get passed, this method is called.		
	    @Override		
	    public void onTestSuccess(ITestResult Result)					
	    {		
	    System.out.println("The name of the testcase passed is :"+Result.getName());					
	    }	
	    
	    @Override
	    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
	       String outputDirectory) {
	       
	       //Iterating over each suite included in the test
	       for (ISuite suite : suites) {
	             
	          //Following code gets the suite name
	          String suiteName = suite.getName();
	             
	          //Getting the results for the said suite
	          Map<String, ISuiteResult> suiteResults = suite.getResults();
	          for (ISuiteResult sr : suiteResults.values()) {
	             ITestContext tc = sr.getTestContext();
	             System.out.println("Passed tests for suite '" + suiteName +
	                "' is:" + tc.getPassedTests().getAllResults().size());
	             System.out.println("Failed tests for suite '" + suiteName +
	                "' is:" + tc.getFailedTests().getAllResults().size());
	             System.out.println("Skipped tests for suite '" + suiteName +
	                "' is:" + tc.getSkippedTests().getAllResults().size());
	          }
	       }
	       
	       
	    }
	    
	  /*  @Attachment(value = "Page screenshot", type = "image/png")
	    public byte[] saveScreenshot(WebDriver driver) {
	        return (((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
	    }

	   */

}
