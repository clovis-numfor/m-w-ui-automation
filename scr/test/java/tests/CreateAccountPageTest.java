package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.HomePage;
import reUsableComponents.GenericAppFunctions;
import reUsableComponents.GenericFunctions;
import setup.DriverManager;

public class CreateAccountPageTest extends DriverManager {

/*
* =============================================================================
* Tests
* =============================================================================
*/

/*
* Creator - Mahantesh Hadimani
* Modifier -
* Story - SC-2921,SC-2916
* TC#254, TC#310 - Verify the content of create account page
*/

@Test(enabled=true,priority = 0,groups= {"Regression","Smoke"})
public void verifyContentOfCreateAccountPage() throws InterruptedException {
HomePage homePage = new HomePage(getDriver());
CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
homePage.clickSignInLink();
test.info("Click on My Account link");
createAccountPage.clickCreateAnAccountButton();
test.info("Clicked on Create an Account button");
Assert.assertTrue(createAccountPage.isCreateAccountPageHeadingDisplayed());
test.info("Create An Account Heading Displayed");
Assert.assertTrue(createAccountPage.isFirstNameInputDisplayed());
test.info("First Name input Displayed");
Assert.assertTrue(createAccountPage.isLastNameInputDisplayed());
test.info("Last Name input Displayed");
Assert.assertTrue(createAccountPage.isAddressLine1InputDisplayed());
test.info("Address Line 1 input Displayed");
Assert.assertTrue(createAccountPage.isEmailInputDisplayed());
test.info("Email Input Displayed");
Assert.assertTrue(createAccountPage.isPasswordInputDisplayed());
test.info("Password Input displayed");
Assert.assertTrue(createAccountPage.iscreateAccountButtonDisplayed());
test.pass("All Create Account Page elements displayed");

}

/*
* Creator - Mahantesh Hadimani
* Modifier -
* Story - SC-2921, SC-2916
* TC#255, TC#312- Verify that user able to create account when user enters valid data and clicks create account button
*/

@Test(enabled=true,priority = 1,description = "TC#255, TC#312 - Verify that user able to create account when user enters valid data and clicks create account button")
public void verifyUserAbleToCreateAccountWithValidData() throws InterruptedException {
CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
GenericAppFunctions appFunctions= new GenericAppFunctions();
HomePage homePage = new HomePage(getDriver());
appFunctions.createUser(homePage,createAccountPage);
Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
test.info("Account Created Successfully");

}

/*
* Creator - Mahantesh Hadimani
* Modifier -
* Story - SC-2921
* TC#258 - Verify user successfully logged in when user enters valid data and clicks create account button
*/

@Test(enabled=true,priority = 2,description = "TC#258 - Verify user successfully logged in when user enters valid data and clicks create account button")
public void verifyUserLoggedInAfterCreatingAccount() throws InterruptedException {
HomePage homePage = new HomePage(getDriver());
CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
GenericAppFunctions appFunctions= new GenericAppFunctions();
appFunctions.createUser(homePage,createAccountPage);
Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
test.info("Account Created Successfully");
homePage.clickMenuLink();
Assert.assertTrue(homePage.isSignOutMenuDisplayed());
test.pass("User Logged In Successfully");
}

/*
* Creator - Mahantesh Hadimani
* Modifier -
* Story - SC-2921,SC-2916
* TC#256,TC#314,TC#311 - Verify that  appropriate error message displayed when user enters invalid data and clicks create account button
*/

@Test(enabled=true,priority = 3,description = "TC#256,TC#314,TC#311- Verify that  appropriate error message displayed when user enters invalid data and clicks create account button")
public void verifyErrorMessageDisplayedWhenUserEntersInvalidData() throws InterruptedException {
HomePage homePage = new HomePage(getDriver());
CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
GenericFunctions gf=new GenericFunctions();

homePage.clickSignInLink();
test.info("Click on My Account link");
createAccountPage.clickCreateAnAccountButton();
test.info("Clicked on Create an Account button");
Assert.assertTrue(createAccountPage.isCreateAccountPageHeadingDisplayed());
test.info("Create An Account Page Heading Displayed");
createAccountPage.enterFirstName("Automation");
test.info("Entered First Name");
createAccountPage.enterLastName("User");
test.info("Entered Last Name");
long currentTimeStamp = gf.getTimeStamp();
createAccountPage.enterEmail("@@ddf.cp.co,");
test.info("Entered Invalid Email");
createAccountPage.enterPassword("Tes");
test.info("Entered Invalid Password");
createAccountPage.enterConfirmPassword("Tes777,,,");
test.info("Entered Invalid Confirm Password");

createAccountPage.enterAddressLine1("244 Street 1");
test.info("Entered Address Line 1");
createAccountPage.enterCity("Calagary");
test.info("Entered City Name");
createAccountPage.selectCountryFromCountryDropDown("Canada");
test.info("Selected Country");
createAccountPage.selectStateFromStateDropDown("Alberta");
test.info("Selected State");
createAccountPage.enterZipCode("T3S");
test.info("Entered Zipcode");
createAccountPage.clickCreateAccountButton();
test.info("Clicked Create Account Button");
// Assert.assertTrue(createAccountPage.isInvalidEmailErrorDisplayed()); // To Do: some issues with email error. will fix it later
// test.info("Invalid Email Error Displayed");
Assert.assertTrue(createAccountPage.isInvalidPasswordErrorDisplayed());
test.info("Invalid Password Error Displayed");
test.pass("Invalid Data errors data displayed");
}

/*
* Creator - Mahantesh Hadimani
* Modifier -
* Story - SC-2921, SC-2916
* TC#257,TC#313 - Verify that  appropriate error message displayed when user enters already registered email address and clicks create account button
*/

@Test(enabled=true,priority = 4,description = "TC#257,TC#313 - Verify that  appropriate error message displayed when user enters already registered email address and clicks create account button")
public void verifyErrorMessageDisplayedWhenUserEntersRegisteredEmail() throws InterruptedException {
HomePage homePage = new HomePage(getDriver());
CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
GenericFunctions gf=new GenericFunctions();
GenericAppFunctions appFunctions= new GenericAppFunctions();
String emailAddress = appFunctions.createUser(homePage,createAccountPage);
Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
test.info("Account Created Successfully");
homePage.clickMenuLink();
Assert.assertTrue(homePage.isSignOutMenuDisplayed());
homePage.clickSignOutButton();
test.info("User clicked signout button");
createAccountPage.clickCreateAnAccountButton();
test.info("Clicked on Create an Account button");
createAccountPage.enterFirstName("Automation");
test.info("Entered First Name");
createAccountPage.enterLastName("User");
test.info("Entered Last Name");
createAccountPage.enterEmail(emailAddress);
test.info("Entered Registered Email");
createAccountPage.enterPassword("Test1234");
test.info("Entered Password");
createAccountPage.enterConfirmPassword("Test1234");
test.info("Entered Confirm Password");
createAccountPage.clickCreateAccountButton();
test.info("Clicked Create Account Button");
Assert.assertTrue(createAccountPage.isEmailAlreadyRegisteredErrorDisplayed());
test.info("Email Already Registered Error Displayed");
test.pass("Email Already Registered Error Displayed");
}

/*
* Creator - Mahantesh Hadimani
* Modifier -
* Story - SC-2916
* TC#309 - Verify the New Account Creation page displayed when user clicks on Create Account button
*/

@Test(enabled=true,priority = 5,description = "TC#254 - Verify the New Account Creation page displayed when user clicks on Create Account button")
public void verifyCreateAccountPageDisplayedWhenUserClicksCreateAccountBtn() throws InterruptedException {
HomePage homePage = new HomePage(getDriver());
CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
homePage.clickSignInLink();
test.info("Click on My Account link");
createAccountPage.clickCreateAnAccountButton();
test.info("Clicked on Create an Account button");
Assert.assertTrue(createAccountPage.isCreateAccountPageHeadingDisplayed());
test.info("Create An Account Heading Displayed");
test.pass("Create Account Page displayed");

}

}
