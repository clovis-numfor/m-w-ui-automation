package util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import setup.DriverManager;

public class DriverUtils extends DriverManager {

public static RemoteWebDriver selectDeviceAndBrowser(String runOn) throws MalformedURLException {
RemoteWebDriver driver = null;
DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

switch (runOn) {
case "BrowserStack_Android":
desiredCapabilities.setCapability("device", PropertiesOperations.getPropertyValueByKey("device"));
desiredCapabilities.setCapability("os_version", PropertiesOperations.getPropertyValueByKey("os_version"));
desiredCapabilities.setCapability("project", "SleepCountry Android");
desiredCapabilities.setCapability("build", "QA Android Build");
desiredCapabilities.setCapability("name", PropertiesOperations.getPropertyValueByKey("test_name"));
desiredCapabilities.setCapability("real_mobile", "true");
desiredCapabilities.setCapability("autoGrantPermissions", "true");
desiredCapabilities.setCapability("autoAcceptAlerts", true);
desiredCapabilities.setCapability("browsername", PropertiesOperations.getPropertyValueByKey("browserName"));
driver = new RemoteWebDriver(new URL("https://" + PropertiesOperations.getPropertyValueByKey("userName") + ":"
+ PropertiesOperations.getPropertyValueByKey("accessKey") + "@hub-cloud.browserstack.com/wd/hub"), desiredCapabilities);
break;
case "BrowserStack_iOS":
desiredCapabilities.setCapability("device", PropertiesOperations.getPropertyValueByKey("ios_device"));
desiredCapabilities.setCapability("os_version", PropertiesOperations.getPropertyValueByKey("ios_os_version"));
desiredCapabilities.setCapability("project", "SleepCountry iOS");
desiredCapabilities.setCapability("build", "QA iOS Build");
desiredCapabilities.setCapability("name", PropertiesOperations.getPropertyValueByKey("test_name"));
desiredCapabilities.setCapability("real_mobile", "true");
desiredCapabilities.setCapability("autoGrantPermissions", "true");
desiredCapabilities.setCapability("browsername", PropertiesOperations.getPropertyValueByKey("browserName"));
driver = new IOSDriver(new URL("https://" + PropertiesOperations.getPropertyValueByKey("userName") + ":"
+ PropertiesOperations.getPropertyValueByKey("accessKey") + "@hub-cloud.browserstack.com/wd/hub"), desiredCapabilities);
break;
}

return driver;
}

}
