package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.ForgotPasswordPage;
import pages.HomePage;
import reUsableComponents.GenericAppFunctions;
import reUsableComponents.GenericFunctions;
import setup.DriverManager;



public class TestForgotPasswordTest extends DriverManager {

/**
* Creator – Surendra
* Story - SC-2922 TC#255 -Verify forgot password page contents
* TC#246 - Verify forgot password page contents
* @throws InterruptedException
*
*/
@Test(priority = 0, description = "TC#246 - Verify forgot password page contents")
public void verifyForgotPasswordPageContent() throws InterruptedException {
HomePage homePage = new HomePage(getDriver());
ForgotPasswordPage fp = new ForgotPasswordPage(getDriver());
GenericFunctions gf = new GenericFunctions();
homePage.clickSignInLink();
fp.clickForgotYourPasswordLink();
test.info("Click on My Account link");
Assert.assertTrue(fp.isforgotYourPasswordHeadingDisplayed());
test.info("Forgot Password Heading Displayed");
Assert.assertTrue(fp.isforgotYourPasswordInfoLabelDisplayed());
test.info("Forgot Password Page Label Displayed");
Assert.assertTrue(fp.isEmailInputDisplayed());
test.info("Email Input Displayed");
Assert.assertTrue(fp.isContinueButtonDisplayed());
test.info("Continue Button Displayed");
Assert.assertTrue(fp.isCancelButtonDisplayed());
test.info("Cancel Button Displayed");
test.pass("Forgot Password content Displayed");
}

/**
* Creator – Surendra
* Story - SC-2922 TC#247 - Verify appropriate error message displayed when user provides non registered email address in forgot password page
* TC#247 - Verify forgot password page contents
* @throws InterruptedException
*
*/
@Test(priority = 0, description = "TC#247 - SC-2922_Verify appropriate error message displayed when user provides non registered email address in forgot password page")
public void verifyForgotPasswordErrorMessage() throws InterruptedException {
HomePage homePage = new HomePage(getDriver());
ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());
GenericFunctions gf = new GenericFunctions();
homePage.clickSignInLink();
forgotPasswordPage.clickForgotYourPasswordLink();
test.info("Clicked on ForgotYourPassword Link");
Assert.assertTrue(forgotPasswordPage.isEmailInputDisplayed());
test.info("Email Input Displayed");
forgotPasswordPage.enterNonRegisterEmailInForgotPasswordField();
forgotPasswordPage.ClickContinueButton();
test.info("Clicked on continue button");
String ActualSuccessMessage = forgotPasswordPage.getErrorMessageForForgotPaword();
test.info("Invalide email in forgot password error message : " + ActualSuccessMessage);
String Expected = "you will receive a password";
boolean success = ActualSuccessMessage.contains(Expected);
Assert.assertTrue(success);
test.info("Error message is displayed on invalid email address in the forgot password field");
}

/**
* Creator – Surendra
* Story - SC-2922 TC#248 - Verify appropriate error message displayed when user provides invalid email address in forgot password page
* @throws InterruptedException
*
*/
@Test(priority = 0, description = "TC#248 - SC-2922_Verify appropriate error message displayed when user provides invalid email address in forgot password page")
public void verifyForgotPasswordErrorMessageForInvalidEmail() throws InterruptedException {
HomePage homePage = new HomePage(getDriver());
ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());
GenericFunctions gf = new GenericFunctions();
homePage.clickSignInLink();
forgotPasswordPage.clickForgotYourPasswordLink();
test.info("Clicked on ForgotYourPassword Link");
Assert.assertTrue(forgotPasswordPage.isEmailInputDisplayed());
test.info("Email Input Displayed");
forgotPasswordPage.enterInvalidEmailInForgotPasswordField();
String ActualEerrorMessage = forgotPasswordPage.ForgotPswErrorMessage();
test.info("Invalide email in forgot password error message : " + ActualEerrorMessage);
String ExpectedErrorMessage = "Invalid email.";
Assert.assertEquals(ActualEerrorMessage, ExpectedErrorMessage);
test.info("Error message is displayed on invalid email address in the forgot password field");
}

/**
* Creator – Surendra
* Story - SC-2922 TC#249 - Verify success message when user enters registered email address in forgot password page
* @throws InterruptedException
*
*/
@Test(priority = 0, description = "TC#249 - SC-2922_Verify success message when user enters registered email address in forgot password page")
public void verifyForgotPasswordSuccessMessageForValidEmail() throws InterruptedException {
HomePage homePage = new HomePage(getDriver());
CreateAccountPage createAccountPage =new CreateAccountPage(getDriver());
ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());
GenericFunctions gf = new GenericFunctions();
GenericAppFunctions Gaf = new GenericAppFunctions();
String NewUserEmailID = Gaf.createUser(homePage, createAccountPage);
Gaf.signOut(homePage);
homePage.clickSignInLink();
forgotPasswordPage.clickForgotYourPasswordLink();
test.info("Clicked on ForgotYourPassword Link");
Assert.assertTrue(forgotPasswordPage.isEmailInputDisplayed());
test.info("Email Input Displayed");
forgotPasswordPage.enterValidEmailInForgotPasswordField(NewUserEmailID);
forgotPasswordPage.ClickContinueButton();
test.info("Clicked on continue button");
String ActualSuccessMessage = forgotPasswordPage.getErrorMessageForForgotPaword();
test.info("Invalide email in forgot password error message : " + ActualSuccessMessage);
String Expected = "you will receive a password";
boolean success = ActualSuccessMessage.contains(Expected);
Assert.assertTrue(success);
test.info("Success message is displayed on email address in the forgot password field");
}
}
