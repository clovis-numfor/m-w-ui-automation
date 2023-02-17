package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import setup.DriverManager;

public class HomePageTest extends DriverManager{

/*
* =============================================================================
* Tests
* =============================================================================
*/

/*
* SC-1568
* TC#553 - Validate the Footer Contents
*/

@Test(priority = 0, description = "TC#553 - Verify the Footer links")
public void validateFooterContents() throws InterruptedException {
HomePage homePage = new HomePage(getDriver());
HashMap<String,String> footerLinks = new HashMap<String,String>();
footerLinks.put("Shipping & Returns","Shipping & Returns");
footerLinks.put("Contact Us","Contact Us");
footerLinks.put("Blog","Blog");
footerLinks.put("Sitemap","Sitemap");
footerLinks.put("Shop All","Shop All");
footerLinks.put("Bath","Bath");
footerLinks.put("Garden","Garden");
footerLinks.put("Kitchen","Kitchen");
footerLinks.put("Publications","Publications");
footerLinks.put("Utility","Utility");
footerLinks.put("OFS","OFS");
footerLinks.put("Common Good","Common Good");
footerLinks.put("Sagaform","Sagaform");
footerLinks.put("View All","Brand");

for(Map.Entry<String, String> footer: footerLinks.entrySet()) {
homePage.clickFooterElement(footer.getKey());
test.info(footer.getKey() + " - Footer Link Clicked");
Assert.assertTrue(homePage.isPageHeadingDisplayed(footer.getValue()));
test.info(footer.getValue() + "- Page Displayed");
//driver.navigate().back();
}

Assert.assertTrue(homePage.isSubscribeInputDisplayed());
    test.info("Subscribe Input Displayed");
    Assert.assertTrue(homePage.isSubscribeButtonDisplayed());
    test.info("Subscribe Button Displayed");
test.pass("All Footer Contents verified");
}
}
