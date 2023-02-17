package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.PropertiesOperations;

public class PDPPage {

RemoteWebDriver driver;
WebDriverWait wait;

public PDPPage(RemoteWebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
wait = new WebDriverWait(driver, 5);
}

@FindBy(how = How.XPATH, using = "//div[@class='productView']")
WebElement productDetailPage;

@FindBy(how = How.XPATH, using = "(//div/input[@aria-label='Silver'])[1]")
WebElement colorSelectionPdpSilver;

@FindBy(how = How.XPATH, using = "(//div/input[@value='95'])[1]")
WebElement sizeSelectionPdpSmall;

@FindBy(how = How.XPATH, using = "//input[@value='Add to Cart']")
WebElement addToCartButtonPdp;

@FindBy(how = How.XPATH, using = "//h1[@class='productView-title']")
WebElement productName;

@FindBy(how = How.XPATH, using = "//div[@id='previewModal']//button[@title='Close']")
WebElement previewModal;

public boolean isPDPDisplayed() {
return productDetailPage.isDisplayed();
}

public void navigateToPdpPage(String product) {
driver.navigate().to(PropertiesOperations.getPropertyValueByKey("url") + product);
}

public String addProductToCartFromPDP()  {
String product=productName.getText();
colorSelectionPdpSilver.click();
sizeSelectionPdpSmall.click();
addToCartButtonPdp.click();
return product ;
}

public String addProductToCartFromPDPwithoutSizeAndColor() {
((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)", "");
addToCartButtonPdp.click();
driver.navigate().refresh();
return productName.getText();
}

public void clickPreviewModal() {
wait.until(ExpectedConditions.visibilityOf(previewModal)).click();
}

}
