package utilityFiles;

import java.io.File;
import java.io.IOException;

import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ListenerImplClass  implements ITestListener{

	ExtentReports report=ExtentReportUtility.getExtentReports();
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Execution Finished :"+context.getName());
		report.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Execution Started :"+context.getName());
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
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed :"+result.getName());
		UtilityClassObject.getTest().fail(result.getThrowable());
		TakesScreenshot ts= (TakesScreenshot) UtilityClassObject.getDriver();
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path="./screenshots/"+result.getName()+".png";
		File dst=new File(path);
		try {
			FileHandler.copy(src, dst);
			UtilityClassObject.getTest().addScreenCaptureFromPath("../screenshots/"+result.getName()+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exception: "+result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped :"+result.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		 System.out.println("Test Started :"+result.getName());
		 
		 ExtentTest test=report.createTest(result.getName());
		 
		 UtilityClassObject.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success :"+result.getName());
	}
	
	

}
