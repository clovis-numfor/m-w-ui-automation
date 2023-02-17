package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyProfileAddressBook;
import reUsableComponents.GenericAppFunctions;
import setup.DriverManager;

public class MyProfileAddressBookTest extends DriverManager {

/*
* =============================================================================
* Tests
* =============================================================================
*/

/*
* Creator - Vikas SP Modifier - Story - SC-2928 TC#267 - Verify - Verify user
* able to delete the address by clicking on the delete button on profile page
* TC#270 - Verify address is deleted if user clicks ok button on address delete
* confirmation modal
*/

@Test(enabled = false, priority = 0, dataProvider = "newAddress", description = "TC#267,TC#270 - Verify user able to delete the address by clicking on the delete button on profile page")
public void verifyUserAbleToDeleteSavedAddress(String firstName, String lastName, String address, String city,
String country, String state, String zip) throws InterruptedException {
GenericAppFunctions genericAppFunction = new GenericAppFunctions();
MyProfileAddressBook myProfileAddressBook = new MyProfileAddressBook(getDriver());
CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
HomePage homePage = new HomePage(getDriver());
String emailId = genericAppFunction.createUser(homePage, createAccountPage);
test.info("Account Created With Email ID " + emailId);
Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
test.info("Account Created Successfully");
homePage.clickMenuLink();
test.info("Clicked on Menu Link");
myProfileAddressBook.clickAccountLink();
test.info("User clicked on Account Link");
myProfileAddressBook.clickAddressesSubMenuLink();
test.info("User clicked on Addresses Sub Tab Link");
genericAppFunction.createNewAddress(myProfileAddressBook, firstName, lastName, address, city, country, state,
zip);
Assert.assertTrue(myProfileAddressBook.verifyNewlyCreatedAddress(city));
test.info("New Address Created Successfully");
int noOfAddressBeforeDelete = myProfileAddressBook.addressCount();
test.info("Total No Of Address Present Before delete " + noOfAddressBeforeDelete);
myProfileAddressBook.clickFirstDeleteIconUnderAddressesList();
test.info("First Delete Icon Clicked under Addresses  List");
myProfileAddressBook.clickConfirmDeleteButton();
test.info("Confirm  Delete button Clicked");
int noOfAddressAfterDelete = myProfileAddressBook.addressCount();
test.info("Total No Of Address Present After delete " + noOfAddressAfterDelete);
Assert.assertTrue(noOfAddressBeforeDelete != noOfAddressAfterDelete);
test.pass("Address deleted Successfully");

}

/*
* Creator - Vikas SP Modifier - Story - SC-2928 TC#266 - Verify delete button
* displayed for the saved address on profile page
*/

@Test(enabled = false, priority = 1, description = "TC#266 - Verify delete button displayed for the saved address on profile page")
public void verifyDeleteButtonDisplayedForSavedAddress() throws InterruptedException {
GenericAppFunctions genericAppFunction = new GenericAppFunctions();
MyProfileAddressBook myProfileAddressBook = new MyProfileAddressBook(getDriver());
CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
HomePage homePage = new HomePage(getDriver());
String emailId = genericAppFunction.createUser(homePage, createAccountPage);
test.info("Account Created With Email ID " + emailId);
Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
test.info("Account Created Successfully");
homePage.clickMenuLink();
test.info("Clicked on Menu Link");
myProfileAddressBook.clickAccountLink();
test.info("User clicked on Account Link");
myProfileAddressBook.clickAddressesSubMenuLink();
test.info("User clicked on Addresses Sub Tab Link");
Assert.assertTrue(myProfileAddressBook.isDeleteButtonDisplayedOnSavedAddressProfilePage());
test.info("Delete Button present on Saved Address");
test.pass("Delete button displayed for the saved address on profile page");

}

/*
* Creator - Vikas SP Modifier - Story - SC-2928 TC#268 - Verify on click of
* delete button confirmation modal displayed
*/

@Test(enabled = false, priority = 2, description = "TC#268 - Verify on click of delete button confirmation modal displayed")
public void verifyDeleteConfirmationModalDisplayed() throws InterruptedException {
GenericAppFunctions genericAppFunction = new GenericAppFunctions();
MyProfileAddressBook myProfileAddressBook = new MyProfileAddressBook(getDriver());
CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
HomePage homePage = new HomePage(getDriver());
String emailId = genericAppFunction.createUser(homePage, createAccountPage);
test.info("Account Created With Email ID " + emailId);
Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
test.info("Account Created Successfully");
homePage.clickMenuLink();
test.info("Clicked on Menu Link");
myProfileAddressBook.clickAccountLink();
test.info("User clicked on Account Link");
myProfileAddressBook.clickAddressesSubMenuLink();
test.info("User clicked on Addresses Sub Tab Link");
myProfileAddressBook.clickFirstDeleteIconUnderAddressesList();
test.info("First Delete Icon Clicked under Addresses  List");
Assert.assertTrue(myProfileAddressBook.isDeleteConfirmationModalDisplayed());
test.info("Delete Confirmation Modal Displayed");
test.pass("Delete Confirmation Modal Displayed");

}

/*
* Creator - Vikas SP Modifier - Story - SC-2928 TC#269 - Verify address is not
* deleted if user clicks cancel button on address delete confirmation modal
*/

@Test(enabled = false, priority = 3, description = "TC#269 - Verify address is not deleted  if user clicks cancel button on address delete confirmation modal")
public void verifyDeleteConfirmationModalCancelButton() throws InterruptedException {
GenericAppFunctions genericAppFunction = new GenericAppFunctions();
MyProfileAddressBook myProfileAddressBook = new MyProfileAddressBook(getDriver());
CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
HomePage homePage = new HomePage(getDriver());
String emailId = genericAppFunction.createUser(homePage, createAccountPage);
test.info("Account Created With Email ID " + emailId);
Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
test.info("Account Created Successfully");
homePage.clickMenuLink();
test.info("Clicked on Menu Link");
myProfileAddressBook.clickAccountLink();
test.info("User clicked on Account Link");
myProfileAddressBook.clickAddressesSubMenuLink();
test.info("User clicked on Addresses Sub Tab Link");
int noOfAddressBeforeDelete = myProfileAddressBook.addressCount();
test.info("Total No Of Address Present Before Clicking Cancel " + noOfAddressBeforeDelete);
myProfileAddressBook.clickFirstDeleteIconUnderAddressesList();
test.info("First Delete Icon Clicked under Addresses  List");
myProfileAddressBook.clickCancelButtonInDeleteConfirmationModal();
test.info("Clicked On Cancel Button in Delete Confirmation Modal");
int noOfAddressAfterDelete = myProfileAddressBook.addressCount();
test.info("Total No Of Address Present After Clicking Cancel " + noOfAddressAfterDelete);
Assert.assertTrue(noOfAddressBeforeDelete == noOfAddressAfterDelete);
test.info("Address Not Deleted After user clicks on cancel button in  Confirmation Modal");
test.pass("Address Not Deleted After user clicks on cancel button in  Confirmation Modal");

}

/*
* Creator - Vikas SP
* Modifier -
* Story - SC-2928
* TC#1180 - Verify delete button Not displayed for the Default address on profile page
*/

@Test(enabled=true,priority = 1,description = "TC#1180 - Verify delete button Not displayed for the Default address on profile page")
public void verifyDeleteButtonNotDisplayedForDefaultAddress() throws InterruptedException  {
GenericAppFunctions genericAppFunction = new GenericAppFunctions();
MyProfileAddressBook myProfileAddressBook = new MyProfileAddressBook(getDriver());
CreateAccountPage createAccountPage = new CreateAccountPage(getDriver());
HomePage homePage = new HomePage(getDriver());
String emailId = genericAppFunction.createUser(homePage, createAccountPage);
test.info("Account Created With Email ID " + emailId);
Assert.assertTrue(createAccountPage.isAccountCreatedSuccessMessageDisplayed());
test.info("Account Created Successfully");
homePage.clickMenuLink();
test.info("Clicked on Menu Link");
myProfileAddressBook.clickAccountLink();
test.info("User clicked on Account Link");
myProfileAddressBook.clickAddressesSubMenuLink();
test.info("User clicked on Addresses Sub Tab Link");
Assert.assertTrue(myProfileAddressBook.isDeleteButtonDisplayedOnDefaultAddressProfilePage()==0);
test.info("Delete Button Not present on Default Address");
test.pass("Delete button Not displayed for the Defalut address on profile page");

}

/*
* Testdata for Creating New Address
*/
@DataProvider(name = "newAddress")
public Object[][] getData2() {
return new Object[][] {
{ "Automation", "Tester", "Test Address", "White Rock", "Canada", "British Columbia", "V4B" } };
}

}
