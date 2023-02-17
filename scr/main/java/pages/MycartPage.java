package pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyCartPage {

RemoteWebDriver driver;
WebDriverWait wait;

public MyCartPage(RemoteWebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
wait = new WebDriverWait(driver, 5);
}

@FindBy(how = How.XPATH, using = "//td[@class='cart-item-block cart-item-figure']/img")
WebElement myCartProductImage;

@FindBy(how = How.XPATH, using = "//h2[@class='cart-item-name']/a")
WebElement myCartProductName;

@FindBy(how = How.XPATH, using = "//dd[@class='productView-info-value']")
WebElement myCartSkuName;

@FindBy(how = How.XPATH, using = "//dl[@class='definitionList']//dd[2]")
WebElement myCartProductSize;

@FindBy(how = How.XPATH, using = "//dl[@class='definitionList']//dd[1]")
WebElement myCartProductColor;

@FindBy(how = How.XPATH, using = "//button[@data-action='inc']//i")
WebElement quantityIncreaseButton;

@FindBy(how = How.XPATH, using = "//button[@data-action='dec']")
WebElement quantityDecreseButton;

@FindBy(how = How.XPATH, using = "//input[@data-action='manualQtyChange']")
WebElement quantityInputTextBox;

@FindBy(how = How.XPATH, using = "//div[@class='loadingOverlay' and @style='display: block;']")
List<WebElement> loadingIcon;

@FindBy(how = How.XPATH, using = "//div[@id='alert-modal']//div[@class='modal-content']")
WebElement alertWarningText;

@FindBy(how = How.XPATH, using = "//button[@class='confirm button']")
WebElement alertOkButton;

@FindBy(how = How.XPATH, using = "(//h2[@class='cart-item-name'])[1]")
WebElement CartItem1;

@FindBy(how = How.XPATH, using = "(//h2[@class='cart-item-name'])[2]")
WebElement CartItem2;

@FindBy(how = How.XPATH, using = "//li[@class='navUser-item navUser-item--cart']/a")
WebElement CartIcon;

public boolean isProductImageDisplayed() {
return myCartProductImage.isDisplayed();
}

public boolean isProductNameDisplayed() {
return myCartProductName.isDisplayed();
}

public boolean isSkuDisplayed() {
return myCartSkuName.getText().length() > 0;
}

public boolean isColorDisplayed() {
return myCartProductColor.getText().length() > 0;

}

public boolean isSizeDisplayed() {
return myCartProductSize.getText().length() > 0;
}

public void waitForLoadingIconToDisappear() throws InterruptedException {
int count = 0;
while (loadingIcon.size() != 0 && count <= 10) {
Thread.sleep(1000);
count++;
}
}

public boolean validateUserAbleToUpdate() throws InterruptedException {
boolean flag1 = false, flag2 = false;
String currentQuantityValue = quantityInputTextBox.getAttribute("value");
quantityIncreaseButton.click();
waitForLoadingIconToDisappear();
Thread.sleep(5000);
String afterIncreaseQuantityValue = quantityInputTextBox.getAttribute("value");
if (Integer.valueOf(afterIncreaseQuantityValue) > Integer.valueOf(currentQuantityValue)) {
flag1 = true;
}
quantityDecreseButton.click();
Thread.sleep(5000);
waitForLoadingIconToDisappear();
String afterDeccreaseQuantityValue = quantityInputTextBox.getAttribute("value");
if (Integer.valueOf(afterDeccreaseQuantityValue) == Integer.valueOf(currentQuantityValue)) {
flag2 = true;
}
return flag1 && flag2;
}

public boolean validateAlertTextForZeroQuantityValue() throws InterruptedException {
boolean flag=false;
quantityInputTextBox.sendKeys(Keys.BACK_SPACE);
quantityInputTextBox.sendKeys("0",Keys.ENTER);
wait.until(ExpectedConditions.visibilityOf(alertWarningText));
String alerttext=alertWarningText.getText();
alertOkButton.click();
waitForLoadingIconToDisappear();
if(alerttext.contains("is not a valid entry")) {
flag=true;
}
return flag;
}

public boolean validateQuantityInputForThreeDigitValue() throws InterruptedException {
boolean flag=false;
quantityInputTextBox.sendKeys(Keys.BACK_SPACE);
quantityInputTextBox.sendKeys("100",Keys.ENTER);
waitForLoadingIconToDisappear();
if(quantityInputTextBox.getAttribute("value").equals("99")) {
flag=true;
}
return flag;
}

public void clickItemThumbnailInMyCart() {
myCartProductImage.click();
}

public void clickItemNameInMyCart() {
myCartProductName.click();
}

public String ProductNameFromCart1() {
return CartItem1.getText();
}

public String ProductNameFromCart2() {
return CartItem2.getText();
}

public void clickCart() {
wait.until(ExpectedConditions.elementToBeClickable(CartIcon)).click();
}

}
