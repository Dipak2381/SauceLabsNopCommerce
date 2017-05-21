package SauceLabsNopCommerce;

import org.openqa.selenium.By;

/**
 * Created by DIPAK on 5/14/2017.
 */
public class RegistrationPage extends Utiles {
    static String username = "";

    public void clickOnRegestration() {
        username = "Raj_malhotra" + dateStamp() + "@yahoo.com";

        //click on gender
        clickOnElement(By.id("gender-male"));
        //type first name
        typeText(By.id("FirstName"), "Raj");
        //type last name
        typeText(By.id("LastName"), "Malhotra");

        //type email address
        //String email = "Raj_malhotra" + dateStamp() + "@yahoo.com";

        typeText(By.id("Email"), username);
        //type
        typeText(By.id("Company"), "dtog");
        //type password
        typeText(By.id("Password"), "D123456");
        //type confirm password
        typeText(By.id("ConfirmPassword"), "D123456");
        //click on register button
        clickOnElement(By.id("register-button"));
        //click on logout
        // clickOnElement(By.className("ico-logout"));


    }

}
