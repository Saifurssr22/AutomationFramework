package vTiger.GenericUtilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementations to all the methods present in
 * ITestListener Interface of TestNG
 * 
 * @author LENOVO
 *
 */
public class ListenerImplimentataionClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		test.log(Status.INFO, "Test Execution Started- " + methodName);

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, "Test Script Passed- " + methodName);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();

		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, "Test Script Failed- " + methodName);
		test.log(Status.FAIL, result.getThrowable());

		String screenShotName = methodName + "-" + jUtil.getSystemDateInFormat();

		try {
			String path = wUtil.takeScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, "Test Script Skipped- " + methodName);
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("--------- Suite Execution Started -------");

		ExtentSparkReporter htmlReport = new ExtentSparkReporter(
				".\\ExtentReports\\Report-" + new JavaUtility().getSystemDateInFormat() + ".html");
		htmlReport.config().setDocumentTitle("VTiger Execution Report");
		htmlReport.config().setReportName("VTiger Execution Report");
		htmlReport.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Reporter Name", "Saif");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		System.out.println("-------- Suite Execution Started -------");
		report.flush();
	}

}
