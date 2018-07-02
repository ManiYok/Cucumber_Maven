package Cucumber;


import java.io.File;

import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"H:\\git\\Cucumber_Maven\\src\\test\\java\\Features"},
		tags= {"@Amazon"},
				glue={"stepDefinition"},
				//plugin = {"html:src\\cucumber-html-report"}
				plugin = {"pretty:STDOUT","html:..\\TestOutput\\Reports\\cucumber-pretty",
						  "json:..\\TestOutput\\Reports\\cucumber-json\\cucumber.json",
						  "com.cucumber.listener.ExtentCucumberFormatter:..\\TestOutput\\Reports\\cucumber-extent\\report.html"
		}
		)



public class CucumberRunner {
public  static void test ()throws Exception {
		//Reporter.loadXMLConfig(new File ("C:\\Users\\657392\\eclipse-workspace\\MyFrame\\src\\Features\\extent-config.xml"));
		//System.out.println("Execution Completed Successfully");

	}
}
