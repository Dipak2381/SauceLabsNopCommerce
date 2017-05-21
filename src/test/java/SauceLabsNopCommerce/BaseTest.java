package SauceLabsNopCommerce;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by DIPAK on 5/14/2017.
 */
public class BaseTest extends Basepage {
  //  BrowserSectors browserSelector= new BrowserSectors();
    public static final String USERNAME = "dipak2381";
    public static final String ACCESS_KEY = "fb8bd245-ca66-4643-aca7-f18e09e56c19";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    @BeforeMethod
    public void openBrowser()
    {

       // browserSelector.selectBrowser();
       // driver =new FirefoxDriver();
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows XP");
        caps.setCapability("version", "43.0");

        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("http://demo.nopcommerce.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
}
