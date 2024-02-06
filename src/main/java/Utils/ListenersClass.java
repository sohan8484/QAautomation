package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class ListenersClass implements ITestListener{
public ExtentReports report;
public ExtentTest test;
	public void onTestFailure(ITestResult result){
		String testName=result.getMethod().getMethodName();
		System.out.println(testName);
		Date date = new Date();
		String currentDate=date.toString().replace(" ", "_").replace(":", "_");
		EventFiringWebDriver takescreenshot = new EventFiringWebDriver(BaseClass.StaticDriver);
		File source = takescreenshot.getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+result.getMethod().getMethodName()+"_"+currentDate+".PNG";
		try {
			FileUtils.copyFile(source, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(screenshotPath);
	}
	
	public void onFinish(ITestContext context) {
		//step 7: flush the report
		report.flush();
	}

	public void onStart(ITestContext context) {
		//step1:configuration
		Date date = new Date();
		String currentDate=date.toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/extentreport "+currentDate+".html");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Trello Automation Report");
		htmlReporter.config().setReportName("Extent Reports");
		//step 2: attaching report and system info
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Platform", "Windows10");
	}
	

	public void onTestSkipped(ITestResult result) {
		//step6: log for skip methods
		test.generateLog(Status.SKIP, result.getMethod().getMethodName()+"is Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

	}

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		//step4: log for pass methods
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
	}

}
