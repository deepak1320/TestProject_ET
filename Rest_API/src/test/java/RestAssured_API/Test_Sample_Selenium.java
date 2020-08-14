package RestAssured_API;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Base.Super;


public class Test_Sample_Selenium extends Super {	
	
	
	@Test
	public void test1() {			
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("dpkjerry13@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("deepakjerry@7");        
	}
	
	@Test
	public void test2() {			
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("emai")).sendKeys("dpkjerry13@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("deepakjerry@7");        
	}
	
	
}
