package amazon_Project1.Project1_Amazon;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		Reporter.log("Test started for test=" + result.getName());
		System.out.println("Test started for test=" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		Reporter.log("result is passed for test=" + result.getName());
		System.out.println("result is passed for test=" + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		Reporter.log("result is failed for test=" + result.getName());
		System.out.println("result is failed for test=" + result.getName());
		captureScreenshot(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		result.getTestContext().getClass().getDeclaredFields();
		Reporter.log("result is SKIPPED for test=" + result.getName());
		System.out.println("result is SKIPPED for test=" + result.getName());
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	public void captureScreenshot(ITestResult result) {
		try {
			SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd_HH-mm_ss-SSS");
			String fileName = dt1.format(new Date());

			File Destination = new File("C:\\Users\\amolb\\eclipse-workspace\\Maven_Project1_amazon\\test-output\\Screenshot\\Test-" + result.getName() + "_" + fileName + ".png");

			// WebDriver driver = (WebDriver) result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(result.getInstance());
			// WebDriver driver = LoginandQuit.driver; // LoginandQuit.getDriver();
			TakesScreenshot ts = (TakesScreenshot) LoginandQuit.driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);

			FileHandler.copy(Source, Destination);
			System.out.println("ScreenCaptured");
			System.out.println("Source:" + Source);
			System.out.println("Destination:" + Destination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
