package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Super extends ExtentManager {
		 	
	static {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
	}
	
	public WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	public void openBrowser(String browser) {		
		if(browser.equalsIgnoreCase("firefox")){
			//create firefox instance
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			//create chrome instance
			driver = new ChromeDriver();
		}	
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	}
	
	@AfterClass
	public void closeBrowser() {		
		driver.close();
		extent.flush();
	}

}
