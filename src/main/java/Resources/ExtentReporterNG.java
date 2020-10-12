package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
	public static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Application Result");
		reporter.config().setDocumentTitle("Test Result");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sangita");
		return extent;
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
