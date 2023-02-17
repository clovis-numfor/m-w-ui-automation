package util;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import setup.DriverManager;

public class ExtentListeners extends DriverManager implements ITestListener {

static Date d = new Date();
static String fileName = "SleepCountry_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
private static ExtentReports extent;
public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
public static String screenshotPath;
public static String screenshotName;

public void onStart(ITestContext context) {
ExtentSparkReporter htmlReporter = new ExtentSparkReporter(
System.getProperty("user.dir") + "\\report\\" + fileName);

htmlReporter.config().setTheme(Theme.STANDARD);
htmlReporter.config().setDocumentTitle(fileName);
htmlReporter.config().setEncoding("utf-8");
htmlReporter.config().setReportName(fileName);

extent = new ExtentReports();
extent.attachReporter(htmlReporter);
extent.setSystemInfo("Automation Tester", "Sleep Country");
extent.setSystemInfo("Organization", "Sleep Country");
extent.setSystemInfo("Build no", "1234");

}

public void onTestStart(ITestResult result) {
test = extent
.createTest(result.getTestClass().getName() + "     @TestCase : " + result.getMethod().getMethodName());
testReport.set(test);
test.log(Status.INFO, "Test Started " + result.getTestClass().getName());
}

public void onTestSuccess(ITestResult result) {
String methodName = result.getMethod().getMethodName();
String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
testReport.get().pass(m);
}

public void onTestFailure(ITestResult result) {
String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
testReport.get()
.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
+ " \n");

captureScreenshot();
testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
MediaEntityBuilder.createScreenCaptureFromPath(ExtentListeners.screenshotPath).build());

String failureLogg = "TEST CASE FAILED";
Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
testReport.get().log(Status.FAIL, m);

}

public void onTestSkipped(ITestResult result) {
String methodName = result.getMethod().getMethodName();
String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
testReport.get().skip(m);

}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
// TODO Auto-generated method stub
}

public void onFinish(ITestContext context) {
if (extent != null) {
extent.flush();
}

}

public static void captureScreenshot() {
File scrFile = ((TakesScreenshot) threadLocalDriver.get()).getScreenshotAs(OutputType.FILE);
Date d = new Date();
screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
screenshotPath = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName;

try {
File finalDestination = new File(screenshotPath);
FileUtils.copyFile(scrFile, finalDestination);
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

}

}
