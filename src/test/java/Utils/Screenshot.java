package Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {
	
	
	
	
	
	static String strDate;
	public static WebDriver driver;
	public final static WebElement loc = driver.findElement(By.xpath("country"));
	static String screenShotPath;
	static String systemPath;
	String dirPath = System.getProperty("user.dir");
	public void launchBrowser() throws Exception {
		
		// Creating folder to place screenshots
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyymmss");  
	    strDate= formatter.format(date);
	    systemPath = System.getProperty("user.dir");
	    screenShotPath = "..\\TestOutput\\Screenshot\\"+strDate;
		File newFolder = new File(screenShotPath);
		newFolder.mkdir();
		System.setProperty("webdriver.chrome.driver", dirPath+"\\src\\test\\java\\Drivers\\chromedriver.exe");
		//ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
	}
	
	//To Take screenshot
	public  static void screenShot (String screenName)throws Exception {
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File(screenShotPath+"\\"+screenName+".jpeg"));
		//FileUtils.copyFile(screenShot, new File("D:\\Automation\\Screenshots\\"+screenName+".jpeg"));

	}
	
	//locators
	
		
}
