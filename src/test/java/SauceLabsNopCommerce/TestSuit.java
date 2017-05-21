package SauceLabsNopCommerce;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by DIPAK on 5/14/2017.
 */
public class TestSuit extends BaseTest
{
    Homepage homepage =new Homepage();
    RegistrationPage registrationPage = new RegistrationPage();
//    LoginPage loginPage = new LoginPage();
//    ApparelPage apparelPage = new ApparelPage();
//    ApparelComparePage apparelComparePage = new ApparelComparePage();
//    ElectronicsPage electronicsPage =new ElectronicsPage();
//    CellPhonePage cellPhonePage = new CellPhonePage();
//    CellPhoneCheckOutPage cellPhoneCheckOutPage = new CellPhoneCheckOutPage();
//    GiftCardPage giftCardPage = new GiftCardPage();
//    EmailFriendPage emailFriendPage = new EmailFriendPage();
//    BooksPage booksPage = new BooksPage();
//    AddToCartFahrenheit451 addToCartFahrenheit451 =new AddToCartFahrenheit451();
//    BookWishListPage bookWishListPage = new BookWishListPage();
//    BookShoppingCartPage bookShoppingCartPage = new BookShoppingCartPage();
//    BookWelcomeSignInPage bookWelcomeSignInPage =new BookWelcomeSignInPage();
//    BookCheckoutPage bookCheckoutPage = new BookCheckoutPage();
//    DesktopsPage desktopsPage =new DesktopsPage();


    // Method 1: user Regestration
    @Test
    public void userShouldAbleToRegestrationSuccessfully()
    {
        homepage.clickOnregistrationButton();
        registrationPage.clickOnRegestration();
        Assert.assertEquals("Your registration completed",Utiles.getTextFromElement(By.className("result")));
    }
}
