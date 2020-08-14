package Base;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports createInstance() {
		
		String fileName = getReportNmae();
		String direc = System.getProperty("user.dir") + "/reports/";
		new File(direc).mkdirs();
		String path = direc + fileName;
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Learning Extent Reports");
		htmlReporter.config().setReportName("Sample Reports");
		htmlReporter.config().setTheme(Theme.DARK);			
			
		extent = new ExtentReports();
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Automation_Tester", "Deepak.B");
		extent.attachReporter(htmlReporter);
		
		return extent;
		
	}
	
	public static String getReportNmae( ) {
		Date d = new Date();
		String fileName = "AutomationReport_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
		return fileName;			
	}

}
