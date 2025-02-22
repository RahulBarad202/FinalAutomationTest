package framework2.ExtentReportss;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass {

	
	//here we will create extent report and configure it
	public static ExtentReports getExtentReportObject() {
		
		File f=new File(System.getenv("user.dir")+"\\ReportDetails\\index.html");
		ExtentSparkReporter reporter=new ExtentSparkReporter(f);
		reporter.config().setReportName("AutomationTestCases");
		reporter.config().setDocumentTitle("SauyseTestClass");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
	    extent.setSystemInfo("Tester", "John");
	    return extent;
	
	}
	
	
}
