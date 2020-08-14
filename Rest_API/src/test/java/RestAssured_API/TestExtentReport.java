package RestAssured_API;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExtentReport {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extenttest;
	WebDriver driver;
	
	static {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeClass
	public void beforeclass() {
	htmlReporter = new ExtentHtmlReporter("./reports/extent.html");
	htmlReporter.config().setEncoding("utf-8");
	htmlReporter.config().setDocumentTitle("Learning Extent Reports");
	htmlReporter.config().setReportName("Sample Reports");
	htmlReporter.config().setTheme(Theme.DARK);
	
	extent = new ExtentReports();
	extent.setSystemInfo("OS", "WIN10");
	extent.setSystemInfo("Browser", "Chrome");
	extent.setSystemInfo("Tester", "Deepak");
	extent.attachReporter(htmlReporter);
	
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("dpkjerry13@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("deepakjerry@7");	
        
        extenttest = extent.createTest("successfull Test");
        extenttest.log(Status.PASS, "Test Method successfull");
        
	}
	
	@AfterClass
	public void afterclass() {
		driver.quit();
		extent.flush();		
	}

}
