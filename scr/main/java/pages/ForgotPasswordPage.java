/**
 *
 */
package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reUsableComponents.GenericFunctions;

/**
 * Creator – Manika Ranjan Modifier - Story - SC-2922 TC#255 -Verify forgot
 * password page contents
 */
public class ForgotPasswordPage {
RemoteWebDriver driver;
WebDriverWait wait;

public ForgotPasswordPage(RemoteWebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
wait = new WebDriverWait(driver, 15);
}

@FindBy(xpath = "//h2[contains(text(),'Reset Your Password')]")
WebElement forgotYourPasswordHeading;

@FindBy(xpath = "//input[@data-label='Email']")
WebElement emailInput;

@FindBy(xpath = "//button[contains(text(),'Continue')]")
WebElement continueButton;

@FindBy(xpath = "//a[text()='Cancel']")
WebElement cancelButton;

@FindBy(xpath = "//a[text()='Forgot your password?']")
WebElement forgotYourPasswordLink;

@FindBy(xpath = "//span[@id='alertBox-message-text']")
WebElement successMessage;

@FindBy(xpath = "//span[@class='form-alert-massage mt-8']")
WebElement ForgotPswErrorMessage;

@FindBy(xpath = "//*[contains(text(),'Fill in your email below to request a new password. An email will be sent to the address below containing a link to verify your email address.')]")
WebElement forgotPasswordInfoLabel;

public boolean isSuccessMessageDisplayed() {
return successMessage.isDisplayed();
}

public WebElement forgotYourPasswordHeading() {
return forgotYourPasswordHeading;
}

public boolean isforgotYourPasswordHeadingDisplayed() {
return forgotPasswordInfoLabel.isDisplayed();
}

public boolean isforgotYourPasswordInfoLabelDisplayed() {
return forgotYourPasswordHeading().isDisplayed();
}

public boolean isEmailInputDisplayed() {
return emailInput.isDisplayed();
}

public void enterNonRegisterEmailInForgotPasswordField() {
GenericFunctions gf = new GenericFunctions();
long currentTimeStamp = gf.getTimeStamp();
String emailAddress = "automation.user" + currentTimeStamp + "@gmail.com";
emailInput.sendKeys(emailAddress);
}

public void enterValidEmailInForgotPasswordField(String emailID) {
GenericFunctions gf = new GenericFunctions();
emailInput.sendKeys(emailID);
}

public void enterInvalidEmailInForgotPasswordField() {
GenericFunctions gf = new GenericFunctions();
long currentTimeStamp = gf.getTimeStamp();
String emailAddress = "automation.user" + currentTimeStamp;
emailInput.sendKeys(emailAddress);
}

public boolean isContinueButtonDisplayed() {
return continueButton.isDisplayed();
}

public void ClickContinueButton() {
continueButton.click();
}

public boolean isCancelButtonDisplayed() {
return cancelButton.isDisplayed();
}

public void clickForgotYourPasswordLink() {
forgotYourPasswordLink.click();
}

public void clickContinueButton() {
continueButton.click();
}

public void enterEmail(String email) {
emailInput.clear();
emailInput.sendKeys(email);
}
public void cancelButton() {
cancelButton.click();
}

public String getErrorMessageForForgotPaword() {
return successMessage.getText();
}

public String ForgotPswErrorMessage() {
return ForgotPswErrorMessage.getText();
}

}
