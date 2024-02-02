package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsclass {
	
		public static ExtentReports extent;
	
	public static ExtentReports getExReports() {
		//set path for report  use support class ExtentSparkReporter object and pass path in it where we want to generate our report   
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter Reporter =new ExtentSparkReporter(path);
		
		// config the path i.e report 
		Reporter.config().setDocumentTitle("Test Results");
		Reporter.config().setReportName("Web Automation test");
		// now create object of Extended report class 
	           extent=new ExtentReports();
		extent.attachReporter(Reporter);
        extent.setSystemInfo("Automation Tester ", "Aakash Satpute ");
       
		return extent;
		
	}
	

}
