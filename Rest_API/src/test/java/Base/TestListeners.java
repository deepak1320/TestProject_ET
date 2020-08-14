package Base;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.Status;


public class TestListeners implements ITestListener {
	
	public static ExtentReports extent = ExtentManager.createInstance();
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
	    ExtentTest test = extent.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
	    extentTest.set(test);
	  }
	
	public void onTestSuccess(ITestResult result) {
	    String logText = "<b>Test Method" + result.getMethod().getMethodName() + "Successfull</b>";
	    Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
	    extentTest.get().log(Status.PASS, m);
	  }
	
	public void onTestFailure(ITestResult result) {
		 String logText = "<b>Test Method" + result.getMethod().getMethodName() + "Failed</b>";
		 Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		 extentTest.get().log(Status.FAIL, m);
	  }
	
	public void onTestSkipped(ITestResult result) {
		 String logText = "<b>Test Method" + result.getMethod().getMethodName() + "Skipped</b>";
		 Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		 extentTest.get().log(Status.SKIP, m);
	  }

}
