package reUsableComponents;

import org.testng.Assert;

import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyCartPage;
import pages.MyProfileAddressBook;
import pages.PDPPage;
import setup.DriverManager;

public class GenericAppFunctions extends DriverManager {

public void navigateToPdpPage(String product) {
PDPPage pdppage=new PDPPage(getDriver());
pdppage.navigateToPdpPage(product);
}

public String addProductToCartFromPDPwithoutSizeAndColor(PDPPage pdppage) {
return pdppage.addProductToCartFromPDPwithoutSizeAndColor();
}

public String addProductToCartFromPDP() {
PDPPage pdppage=new PDPPage(getDriver());
return pdppage.addProductToCartFromPDP();
}

/*
* This Method is to wait till loading Icon disappears
*/
public void waitForLoadingIconToDisappear(MyCartPage mycartpage) throws InterruptedException {
mycartpage.waitForLoadingIconToDisappear();
}

/*
* Create User method create unique user and returns the email address
*/

public String createUser(HomePage homePage,CreateAccountPage createAccountPage) throws InterruptedException {
GenericFunctions gf = new GenericFunctions();

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
String emailAddress = "automation.user" + currentTimeStamp + "@gmail.com";
createAccountPage.enterEmail(emailAddress);
test.info("Entered Email");
createAccountPage.enterPassword("Test1234");
test.info("Entered Password");
createAccountPage.enterConfirmPassword("Test1234");
test.info("Entered Confirm Password");
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
return emailAddress;
}

/*
* This Method Creates New Address
*/

public void createNewAddress(MyProfileAddressBook myProfileAddressBook, String firstName, String lastName,
String address, String city, String country, String state, String zipCode) throws InterruptedException {
myProfileAddressBook.createNewUserAddress(firstName, lastName, address, city, country, state, zipCode);
}

public void signOut(HomePage homePage) throws InterruptedException {
homePage.SignOut();
test.info("Clicked on Sign out button");
}


}
