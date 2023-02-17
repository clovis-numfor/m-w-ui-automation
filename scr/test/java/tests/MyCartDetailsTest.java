package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyCartPage;
import pages.PDPPage;
import reUsableComponents.GenericAppFunctions;
import setup.DriverManager;

public class MyCartDetailsTest extends DriverManager {

/*
* =============================================================================
* Tests
* =============================================================================
*/

/*
* Creator - Vikas SP Modifier - Story - SC-1426 TC#318 - Verify Name and
* Picture Sku Color and Size of Item under My Cart
*/

@Test(enabled=true,priority = 0, description = "TC#318 - Verify Name and Picture Sku Color and Size of Item under My Cart")
public void verifyNamePicturePresntInMyCart() throws InterruptedException {

MyCartPage mycartpage = new MyCartPage(getDriver());
GenericAppFunctions genericappfunctions = new GenericAppFunctions();
PDPPage pdppage = new PDPPage(getDriver());
genericappfunctions.navigateToPdpPage("1-l-le-parfait-jar/");
test.info("Navigated To PDP Page");
String productname = genericappfunctions.addProductToCartFromPDP();
test.info("Product Added from PDP Page");
test.info("Product Name Added " + productname);
pdppage.clickPreviewModal();
test.info("Clicked on Preview Modal");
mycartpage.clickCart();
test.info("Clicked on Cart");
Assert.assertTrue(mycartpage.isProductImageDisplayed());
test.info("Image is Displayed in My Cart");
Assert.assertTrue(mycartpage.isProductNameDisplayed());
test.info("Product Name is Displayed in My Cart");
Assert.assertTrue(mycartpage.isSizeDisplayed());
test.info("Size is Displayed in My Cart");
Assert.assertTrue(mycartpage.isColorDisplayed());
test.info("Color is Displayed in My Cart");
test.pass("All Properties are displayed under My Cart successfully");

}

/*
* Creator - Vikas SP Modifier - Story - SC-1426 TC#322 - Verify PDP Navigation
* After User clicks on Thumbnail or Name in My Cart Page
*/
@Test(enabled=true,priority = 1, description = "TC#322 - Verify PDP Navigation After User clicks on Thumbnail or Name in My Cart Page")
public void verifyPdpNavigationInMyCart() throws InterruptedException {
MyCartPage mycartpage = new MyCartPage(getDriver());
GenericAppFunctions genericappfunctions = new GenericAppFunctions();
PDPPage pdppage = new PDPPage(getDriver());
genericappfunctions.navigateToPdpPage("1-l-le-parfait-jar/");
test.info("Navigated To PDP Page");
String productname = genericappfunctions.addProductToCartFromPDP();
test.info("Product Added from PDP Page");
test.info("Product Name Added " + productname);
pdppage.clickPreviewModal();
test.info("Clicked on Preview Modal");
mycartpage.clickCart();
test.info("Clicked on Cart");
mycartpage.clickItemNameInMyCart();
test.info("User is in My Cart Page");
test.info("Item Name Clicked in My Cart");
Assert.assertTrue(pdppage.isPDPDisplayed());
test.info("PDP Page Displayed");
test.pass("PDP Page Validation Completed For Thumbnail and Name Successfully");

}

/*
* Creator - Vikas SP
* Modifier -
* Story - SC-1426
* TC#320 -  Verify the user is able to update the Quantity for added item in the Cart
*/

@Test(enabled=true,priority = 2,description = "TC#320 - Verify the user is able to update the Quantity for added item in the Cart")
public void verifyUpdateQuantityInMyCart() throws InterruptedException {

MyCartPage mycartpage=new MyCartPage(getDriver());
GenericAppFunctions genericappfunctions=new GenericAppFunctions();
PDPPage pdppage=new PDPPage(getDriver());
genericappfunctions.navigateToPdpPage("1-l-le-parfait-jar/");
test.info("Navigated To PDP Page");
String productname=genericappfunctions.addProductToCartFromPDP();
test.info("Product Added from PDP Page");
test.info("Product Name Added "+productname);
pdppage.clickPreviewModal();
test.info("Clicked on Preview Modal");
mycartpage.clickCart();
test.info("Clicked on Cart");
Assert.assertTrue(mycartpage.validateUserAbleToUpdate());
test.info("User able to update with add and remove Quantity");
test.pass("User able to update with add and remove Quantity");

}


/*
* Creator - Vikas SP
* Modifier -
* Story - SC-1426
* TC#321 -  Validation for InValid Quantity for Quantity input Textbox in MyCart
*/

@Test(enabled=true,priority = 3,description = "TC#321 - Validation for InValid Quantity for Quantity input Textbox in MyCart")
public void verifyInvalidQuantityInMyCart() throws InterruptedException {

MyCartPage mycartpage=new MyCartPage(getDriver());
GenericAppFunctions genericappfunctions=new GenericAppFunctions();
PDPPage pdppage=new PDPPage(getDriver());
genericappfunctions.navigateToPdpPage("1-l-le-parfait-jar/");
test.info("Navigated To PDP Page");
String productname=genericappfunctions.addProductToCartFromPDP();
test.info("Product Added from PDP Page");
test.info("Product Name Added "+productname);
pdppage.clickPreviewModal();
test.info("Clicked on Preview Modal");
mycartpage.clickCart();
test.info("Clicked on Cart");
Assert.assertTrue(mycartpage.validateAlertTextForZeroQuantityValue());
test.info("Alert Validation For Zero Value Completed");
Assert.assertTrue(mycartpage.validateQuantityInputForThreeDigitValue());
test.info("Quantity input validation for three digit value completed");
test.pass("Quantity Input Validation Completed Successfully");

}


}
