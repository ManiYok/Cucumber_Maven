package Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Screenshot {
	static String strDate;
	public static WebDriver driver;
	static String screenShotPath;
	static String systemPath;
	String dirPath = System.getProperty("user.dir");
	/*
	final static ExtentReports extent = new  ExtentReports("..\\TestOutput\\Reports\\cucumber-extent2\\report.html", true);
	protected final static ExtentTest test = extent.startTest("Execution Started");
	*/
	public void launchBrowser() throws Exception {
		//extent.loadConfig(new File(System.getProperty("..src\\test\\java\\Features\\extent-config.xml")));
		
		// Creating folder to place screenshots
		
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyymmss");  
	    strDate= formatter.format(date);
	    systemPath = System.getProperty("user.dir");
	    screenShotPath = "..\\TestOutput\\Screenshot\\"+strDate;
		File newFolder = new File(screenShotPath);
		newFolder.mkdir();
		
		//Browser Selection
		
		if(TestData.getData("Environment", "Browser").contains("Firefox")) {
		System.setProperty("webdriver.gecko.driver", dirPath+"\\src\\test\\java\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		}
		else if(TestData.getData("Environment", "Browser").contains("IE")) {
		System.setProperty("webdriver.ie.driver", dirPath+"\\src\\test\\java\\Drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		}
		else if(TestData.getData("Environment", "Browser").contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", dirPath+"\\src\\test\\java\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			throw new Exception("Please Select the browser before starting the execution");
		}
}
	
	//To Take screenshot
	public  static void screenShot (String screenName)throws Exception {
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File(screenShotPath+"\\"+screenName+".jpeg"));
		//FileUtils.copyFile(screenShot, new File("D:\\Automation\\Screenshots\\"+screenName+".jpeg"));

	}
	
	
		
}
