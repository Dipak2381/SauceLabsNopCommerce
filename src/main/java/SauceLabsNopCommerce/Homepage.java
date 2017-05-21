package SauceLabsNopCommerce;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by DIPAK on 5/14/2017.
 */
public class Homepage extends Utiles
{

    //click on nopcommerce registration page
    public void clickOnregistrationButton()
    {
        clickOnElement(By.xpath("//div[@class='header']/div/div[2]/div/ul/li/a"));
        //verify if user is navigated to registration page successfully
        Assert.assertEquals("Register", getTextFromElement(By.xpath("html/body/div[6]/div[3]/div/div/form/div/div[1]/h1")));
    }

    public void clickOnLoginButton()

    {
        clickOnElement(By.className("ico-login"));
        //verify if user is navigated to login page successfully
        // Assert.assertTrue(getTextFromElement(By.tagName("body")).contains("Welcome, Please Sign In!"), "Fail");
        // System.out.println(driver.getCurrentUrl());
        //assertByGetText(By.xpath("//h1"),"Welcome, Please Sign In!","user not on welcome sign page");// Assert.assertTrue(driver.getCurrentUrl().contains("gin"),"Fail");
        // Assert.assertTrue(driver.getPageSource().contains("Welcome, Please Sign In!"));
        Assert.assertTrue(getTextFromElement(By.xpath("//h1")).contains("Welcome, Please Sign In!"),"Fail");

    }
    public  void clickOnApparelButton()
    {
        clickOnElement (By.xpath("//a[contains(@href, '/apparel')]"));
        //verify user is on Apparel page see all categarioes
        Assert.assertEquals(driver.getCurrentUrl(),"http://demo.nopcommerce.com/apparel");

    }
    public  void clickOnElectronicesButton()
    {
        clickOnElement(By.xpath("//a[@href='/electronics']"));
        //verify user on electronics page
        assertByGetText(By.xpath("//h1"),"Electronics","user not in electronics page");

    }
    public  void clickOnBooksButton()
    {
        clickOnElement(By.xpath("//a[contains(text(),'Books')]"));
        //verify user on books page
        assertByGetText(By.xpath("//h1"),"Books","user not on book page");
    }

    public  void clickOnLogout()
    {
        clickOnElement(By.className("ico-logout"));
        //verify user on logout page
        assertByGetText(By.linkText("Log in"),"Log in","if not present then fail");
    }
    public void clickOnGiftCard()
    {
        pageScrollUpAndDown("0,800","$25 Virtual Gift Card");
        //click on gift card $25 to add to cart
        clickOnElement(By.xpath("//div[4]/div/div[2]/div[3]/div[2]/input[1]"));
        assertByGetText(By.xpath("//h1"),"$25 Virtual Gift Card","user not on $25gift card page");
    }
    public void clickOnComputor()
    {
        clickOnElement(By.xpath("//a[contains(@href, '/computers')]"));
        //verify user on computor page
        assertByGetText(By.xpath("//h1"),"Computers","user not on computor page");
    }
}
