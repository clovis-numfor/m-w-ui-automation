package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;


public class HomePage {
RemoteWebDriver driver;
WebDriverWait wait;

public HomePage(RemoteWebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);

    }

@FindBy(id = "guestTkn")
WebElement previewCodeInput;

@FindBy(xpath = "//div[@class='rc-inline-block']")
WebElement captchaCheckbox;

@FindBy(xpath = "//input[@value='Submit']")
WebElement submitButton;

@FindBy(xpath = "//span[@class='header-logo-text']")
WebElement sleepCountryLogo;

@FindBy(xpath = "//div[@id='myAccountBtn']")
WebElement myAccountBtn;

@FindBy(xpath = "//button[@id='CC-userLoginSubmit']")
WebElement signinButton;

@FindBy(xpath = "(//li[@class='navPages-item']/a[@aria-label='Sign in'])[1]")
WebElement signInLink;

@FindBy(xpath = "//li[@class='navUser-item navUser-item--account']/a[@aria-label='Sign out']")
WebElement signOutLink;

@FindBy(xpath = "//a[@class='mobileMenu-toggle']")
WebElement menuLink;

@FindBy(xpath = "//a[@class='mobileMenu-toggle']")
WebElement menuIcon;

@FindBy(xpath = "//input[@value='Subscribe']")
WebElement subscribeButton;

@FindBy(xpath = "//input[@placeholder='Subscribe with an email address']")
WebElement subscribeInput;

public WebElement signOutLinkElement() {
return signOutLink;
}

public boolean signOutLinkDisplayed() throws InterruptedException {
menuLink.click();
Thread.sleep(3000);
return wait.until(ExpectedConditions.visibilityOf(signOutLinkElement())).isDisplayed();
}

public String getTitle() throws InterruptedException {
Thread.sleep(5000);
return driver.getTitle();
}

public boolean getLogo() {
return sleepCountryLogo.isDisplayed();
}

public void clickMyAccountLink() {
myAccountBtn.click();
}

public void clickSignInLink() throws InterruptedException {
menuLink.click();
Thread.sleep(3000);
signInLink.click();
}

public void switchTabs() {
ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(tabs.get(1));
}

public void typePreviewCode(String previewCode) {
previewCodeInput.sendKeys(previewCode);
}

public void selectCaptchaCheckbox() {
captchaCheckbox.click();
}

public void clickSubmitButton() {
submitButton.click();
}

public void clickMenuLink() throws InterruptedException {
menuLink.click();
}

public boolean isSignOutMenuDisplayed() {
return signOutLink.isDisplayed();
}

public void clickSignOutButton() {
signOutLink.click();
}

public void SignOut() {
menuIcon.click();
signOutLink.click();

}

public void clickFooterElement(String linkName) {
driver.findElement(By.xpath("//ul[@class='footer-info-list']/li/a[contains(text(),'"+linkName+"')]")).click();
}

public boolean isPageHeadingDisplayed(String pageHeading) {
return driver.findElement(By.xpath("//h1[contains(text(),'"+pageHeading+"')]")).isDisplayed();
}

public boolean isSubscribeInputDisplayed() {
return subscribeInput.isDisplayed();
}

public boolean isSubscribeButtonDisplayed() {
return subscribeButton.isDisplayed();
}


}
