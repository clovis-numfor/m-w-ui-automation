package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import reUsableComponents.GenericFunctions;
import setup.DriverManager;

public class MyProfileAddressBook extends DriverManager {

RemoteWebDriver driver;
WebDriverWait wait;

public MyProfileAddressBook(RemoteWebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
wait = new WebDriverWait(driver, 5);
}

@FindBy(xpath = "//a[@class='navPages-action has-subMenu']")
WebElement accountLink;

@FindBy(how = How.XPATH, using = "//li[@class='navPage-subMenu-item']//a[contains(text(),'Addresses')]")
WebElement addressesSubMenuLink;

@FindBy(xpath = "//span[@class='address-addNew']/span")
WebElement newAddressAddIcon;
//
@FindBy(how = How.ID, using = "FormField_4_input")
WebElement firstNameInputTextBox;

@FindBy(how = How.ID, using = "FormField_5_input")
WebElement lastNameInputTextBox;

@FindBy(how = How.ID, using = "FormField_8_input")
WebElement addressLine1InputTextBox;

@FindBy(how = How.ID, using = "FormField_10_input")
WebElement cityInputTextBox;

@FindBy(how = How.ID, using = "FormField_11_select")
WebElement countrySelectDropdown;

@FindBy(how = How.ID, using = "FormField_12_input")
WebElement stateSelectDropdown;

@FindBy(how = How.ID, using = "FormField_13_input")
WebElement zipInputTextBox;

@FindBy(how = How.XPATH, using = "//button[text()='Save']")
WebElement saveAddressButton;

@FindBy(how = How.XPATH, using = "(//li[@class='address'])[1]//li")
WebElement createdAddressHeader;

@FindBy(how = How.XPATH, using = "//h1[text()='Add an Address']")
WebElement addNewAddressHeading;

@FindBy(how = How.XPATH, using = "(//button[@data-reveal-id='delete-it'])[1]")
WebElement firstDeleteIconOnAddressList;

@FindBy(how = How.XPATH, using = "//form[@id='delete-address-url']/button[text()='Delete']")
WebElement deleteConfirmButton;

@FindBy(how = How.XPATH, using = "//ul[@class='addressList']/li")
List<WebElement> addressCount;

@FindBy(how = How.XPATH, using = "//h3[text()='Delete this Shipping Address?']")
WebElement deleteConfirmationModal;

@FindBy(how = How.XPATH, using = "//form[@id='delete-address-url']//a")
WebElement cancelConfirmationModalButton;

@FindBy(how = How.XPATH, using = "//button[text()='Default']/..//button[@data-reveal-id='delete-it']")
List<WebElement> deleteIconOnDefaultAddress;

public void clickFirstDeleteIconUnderAddressesList() {
firstDeleteIconOnAddressList.click();
}

public void clickConfirmDeleteButton() throws InterruptedException {
deleteConfirmButton.click();
Thread.sleep(3000);
}

public void clickAccountLink() {
accountLink.click();
}

public void clickAddressesSubMenuLink() {
addressesSubMenuLink.click();
}

public void clickOnNewAddressAddIcon() {
newAddressAddIcon.click();
}

public void enterFirstName(String firstName) {
firstNameInputTextBox.clear();
firstNameInputTextBox.sendKeys(firstName);
}

public void enterLastName(String lastName) {
lastNameInputTextBox.clear();
lastNameInputTextBox.sendKeys(lastName);
}

public void enterAddressLine1(String addressLine) {
addressLine1InputTextBox.clear();
addressLine1InputTextBox.sendKeys(addressLine);
}

public void enterCity(String cityName) {
cityInputTextBox.clear();
cityInputTextBox.sendKeys(cityName);
}

public void selectCountryFromCountryDropDown(String countryName) {
Select countryDropdown = new Select(countrySelectDropdown);
countryDropdown.selectByVisibleText(countryName);
}

public void selectStateFromStateDropDown(String stateName) throws InterruptedException {
Thread.sleep(4000);
Select stateDropdown = new Select(stateSelectDropdown);
stateDropdown.selectByVisibleText(stateName);
}

public void enterZipCode(String zipCode) {
zipInputTextBox.clear();
zipInputTextBox.sendKeys(zipCode);
}

public void clickSaveAddressButton() {
saveAddressButton.click();
}

public boolean verifyNewlyCreatedAddress(String validateText) {
return createdAddressHeader.getText().contains(validateText);
}

public WebElement addNewAddressPageHeadingElement() {
return addNewAddressHeading;
}

public boolean isAddNewAddressPageHeadingDisplayed() {
return wait.until(ExpectedConditions.visibilityOf(addNewAddressPageHeadingElement())).isDisplayed();
}

public int addressCount() {
return addressCount.size();
}

public boolean isDeleteButtonDisplayedOnSavedAddressProfilePage() {
return wait.until(ExpectedConditions.visibilityOf(firstDeleteIconOnAddressList)).isDisplayed();
}

public boolean isDeleteConfirmationModalDisplayed() {
return wait.until(ExpectedConditions.visibilityOf(deleteConfirmationModal)).isDisplayed();
}

public void clickCancelButtonInDeleteConfirmationModal() {
cancelConfirmationModalButton.click();
}

/*
* This Method Creates New Address
*/

public void createNewUserAddress(String firstName, String lastName, String address, String city, String country,
String state, String zipCode) throws InterruptedException {
GenericFunctions gf = new GenericFunctions();
String firstNameWithTimeStamp = firstName + gf.getTimeStamp();
clickOnNewAddressAddIcon();
test.info("User clicked on New Address Creation Icon");
isAddNewAddressPageHeadingDisplayed();
test.info("New Address Creation Page Displayed");
enterFirstName(firstNameWithTimeStamp);
test.info("Entered First Name " + firstNameWithTimeStamp);
enterLastName(lastName);
test.info("Entered Last Name");
enterAddressLine1(address);
test.info("Entered Address");
enterCity(city);
test.info("Entered City Name");
// selectCountryFromCountryDropDown(country);
// test.info("Select Country Name");
selectStateFromStateDropDown(state);
test.info("Select State Name");
enterZipCode(zipCode);
test.info("Entered Zip Code");
clickSaveAddressButton();
test.info("Click on SAVE Button");

}

public int isDeleteButtonDisplayedOnDefaultAddressProfilePage() {
return deleteIconOnDefaultAddress.size();
}

}
