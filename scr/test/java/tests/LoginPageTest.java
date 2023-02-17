package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
import setup.DriverManager;
import pages.HomePage;

public class LoginPageTest extends DriverManager {

/*
* =============================================================================
* Tests
* =============================================================================
*/

/*
* Navigate to login page
*/
@Test(priority = 0)
public void navigateToLoginPage() throws InterruptedException {

HomePage homePage = new HomePage(getDriver());
LoginPage login = new LoginPage(getDriver());

test.info("Clicking 'Log In or Sign Up' button");
homePage.clickSignInLink();
test.info("Checking title matches string");
Assert.assertEquals(login.getTitle(), "QA - Sign in");
test.info("Title matches with title from DOM");
}

/*
* Test Login with invalid credentials
*/
@Test(priority = 1, dataProvider = "inValidaccounts")
public void verifyInvalidCredentialsLogin(String testUsername, String testPassword) throws InterruptedException {

HomePage homePage = new HomePage(getDriver());
LoginPage login = new LoginPage(getDriver());

homePage.clickSignInLink();
login.typeUsername(testUsername);
test.info("Entering invalid username");
login.typePassword(testPassword);
test.info("Entering invalid password");
login.clickSignInButton();
test.info("Clicking Sign in button");
Assert.assertTrue(login.errorContainerDisplayed());
test.info("Log in with invalid crendentials failed");
}

/*
* Test Login with valid credentials
*/
@Test(priority = 2, dataProvider = "validaccounts")
@Parameters({ "username", "password" })
public void verifyValidCredentialsLogin(String username, String password) throws InterruptedException {
HomePage homePage = new HomePage(getDriver());
LoginPage login = new LoginPage(getDriver());
homePage.clickSignInLink();
login.typeUsername(username);
test.info("Entering valid username");
login.typePassword(password);
test.info("Entering valid password");
login.clickSignInButton();
test.info("Clicking Sign out button");
Assert.assertTrue(homePage.signOutLinkDisplayed());
test.info("Log in with valid crendentials passed");
}

/*
* =============================================================================
* Data Providers
* =============================================================================
*/

/*
* Testdata for invalid login attempts using data from DataProvider
*/
@DataProvider(name = "inValidaccounts")
public Object[][] getData1() {
return new Object[][] { { "InvalidEmail@gmail.com", "testing123" }, // Invalid email, correct password
{ "testuser@yahoo.com", "InvalidPassword2" } // Correct email, Invalid password
};
}

/*
* Testdata for valid login attempts using data from DataProvider
*/
@DataProvider(name = "validaccounts")
public Object[][] getData2() {
return new Object[][] { { "mahantesh.hadimani@sleepcountry.ca", "Test1234" } // valid email, correct password
};
}
}
