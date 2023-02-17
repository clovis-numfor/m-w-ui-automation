package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class LoginPage {

RemoteWebDriver driver;
WebDriverWait wait;

public LoginPage(RemoteWebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);

    }

@FindBy(id = "login_email")
WebElement usernameField;

@FindBy(id = "login_pass")
WebElement passwordField;

@FindBy(xpath = "(//input[@value='Sign in'])[1]")
WebElement signInButton;

@FindBy(id = "myAccountBtn")
WebElement myAccountBtn;

@FindBy(xpath = "//div/p[contains(text(),'My Account')]")
WebElement myAccountPanel;

@FindBy(id = "alertBox-message-text")
WebElement errorContainer;

public void typeUsername(String username) { // pass a parameter so we don't hardcode values in the object class.
usernameField.clear();
usernameField.sendKeys(username);
}

public void typePassword(String password) {
passwordField.clear();
passwordField.sendKeys(password);

}

public void clickSignInButton() {

signInButton.click();
}

public WebElement errorContainerMessage() {
return errorContainer;
}

public boolean errorContainerDisplayed() {
return wait.until(ExpectedConditions.visibilityOf(errorContainerMessage())).isDisplayed();
}

public String getTitle() throws InterruptedException {
return driver.getTitle();
}

public WebElement myAccountPanelElement() {
return myAccountPanel;
}

public boolean myAccountLogoDisplayed() throws InterruptedException {
wait.until(ExpectedConditions.urlToBe("https://qa.sleepcountry.ca/"));
myAccountBtn.click();
return wait.until(ExpectedConditions.visibilityOf(myAccountPanelElement())).isDisplayed();
}
}
