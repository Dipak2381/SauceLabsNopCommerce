package SauceLabsNopCommerce;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by DIPAK on 5/14/2017.
 */
public class Utiles extends Basepage
{

    //send text/type text/any like name,username,password
    public static void typeText(By by, String text)
    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    //click on Any elements/click method
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //method to sleep /hold at anywhere in Webpage
    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //select methods

    //select drop down  by visible text
    public static  void selectByText(By by,String text)
    {
        new Select(driver.findElement(by)).selectByVisibleText(text);// name less object

    }

    ////select drop down  by visible value
    public static  void selectValue(By by,String value){

        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    //select drop down  by index number
    public static void selectByIndex(By by,int index)
    {
        new Select(driver.findElement(by)).deselectByIndex(index);

    }
    //clear any elements
    public  static void clearOnElement(By by)
    {
        driver.findElement(by).clear();
    }
    //close Browser Window
    public static void close()
    {
        driver.close();

    }
    //quit browser all window
    public  static void quit()
    {
        driver.quit();
    }
    //explicite wait method
    //wait until element to be present

    public  static  void elementToBePresent(By by,int second)
    {
        WebDriverWait wait =  new WebDriverWait(driver,second);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }
    //Wait until element to be clickable

    public  static  void elementToBeClickable(By by,int second)
    {
        WebDriverWait wait =  new WebDriverWait(driver,second);
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }
    //Wait until element to be visible

    public  static  void elementToBeVisible(By by,int second)
    {
        WebDriverWait wait =  new WebDriverWait(driver,second);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }
    //Wait until element to be selected

    public  static  void elementToBeSelected(By by,int second)
    {
        WebDriverWait wait =  new WebDriverWait(driver,second);
        wait.until(ExpectedConditions.elementToBeSelected(by));

    }

    //Wait until element is invisilbility of element located

    public  static  void waitUntilInvisibilityOfElementLocated(By by,int second)
    {
        WebDriverWait wait =  new WebDriverWait(driver,second);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

    }
    //Wait until element is invisibility of element with text

    public  static  void waitUntilGetTextInvisible(By by,int second,String text)
    {
        WebDriverWait wait =  new WebDriverWait(driver,second);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(by,text));

    }

    //Get text for any elements

    public static String getTextFromElement(By by)
    {
        String text= driver.findElement(by).getText();
        return text;
    }

    //get text by attribute
    public static String getTextByAttribute(By by,String attributeName)
    {
        String text = driver.findElement(by).getAttribute(attributeName);
        return text;
    }

    //Get text =value = attribute//array list
    //dropdown selection by attribute if select class on available in firepath console
    public static void dropDownSelectionByAttribute(By by,String attributeName,String dropDownText)
    {
        List<WebElement> size_menu  =driver.findElements(by);
        for(WebElement element : size_menu)
        {
            String innerText = element.getAttribute(attributeName);
            if (innerText.contentEquals(dropDownText))
            {
                element.click();
                break;
            }
        }

    }


    //date stamp method

    public static String dateStamp()
    {
        DateFormat dateFormat=new SimpleDateFormat("ddhhss");
        Date date =new Date();
        String date1 = dateFormat.format(date);
        return date1;

    }

    // TakesScreenshot ts = (TakesScreenshot) driver;
    // File source = ts.getScreenshotAs(OutputType.FILE);
    //    FileUtils.copyFile(source, new File("C:\\screenshot\\photo.png"));
    //browser screen shot

    public static void printBrowserScreenShot(String filePath)
    {TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(filePath+"\\photo"+dateStamp()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //print screen shot

    public static void printScreenShot(String filePath)
    {
        try {
            Robot robot = new Robot();
            BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(screenShot,"jpg",new File(filePath+"\\photo"+dateStamp()+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (AWTException e) {
            e.printStackTrace();
        }
    }

    //use Random number

    public static void randomNumber(int range)
    {
        Random random = new Random();
        int number = random.nextInt(range);
        return ;
    }

    //mouse hover  on any element
    public static void mouseHover(By by)
    {
        Actions action =new Actions(driver);
        WebElement mouse = driver.findElement(by);
        action.moveToElement(mouse).build().perform();
    }
    public static  void pageScrollUpAndDown(String scroll,String objects )
    {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(scroll,objects);
    }

    //Reusable method to scrollpage
    public static void scrollPage(int x,int y)
    {
        ((JavascriptExecutor)driver).executeScript("scroll(x,y)");
    }



    public  static  void alertAccept()
    {
        Alert alert = driver.switchTo().alert();

        alert.accept();
    }
    public static void iFreamByNumber(String iFNumber)
    {
        //Switch by frame name
        driver.switchTo().frame("");
        driver.quit();

    }

    public WebElement fluentWait ( final By locator)
    {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(java.util.NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver)
            {
                return driver.findElement(locator);
            }
        });

        return foo;
    }
    //Reusable boolen method  for verifying if elements presnet
    public static boolean isElementPresent(By by)
    {
        try{
            return driver.findElement(by).isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    //Resuable method for waiting for Element to be present

    public static void waitUntilToBePresent(By by){
        int counter =0;
        while (counter<=10){
            try
            {
                if(driver.findElement(by).isDisplayed()){
                    counter++;
                    System.out.println("Waiting for a Second....");
                    sleep(1);
                }else {
                    return;
                }
            }catch (Exception e){
                return;
            }
        }
    }

    //assertion by getting text from web location
    public  static void assertByGetText(By by,String expectedText,String errorMessage)
    {
        Assert.assertEquals(getTextFromElement(by),expectedText,errorMessage);
    }
    ////assertion by getting attribute value from web location
    public static  void assertByGetAttribute(By by,String attributeValue,String expectedText,String errorMessage)
    {
        Assert.assertEquals(getTextByAttribute(by,attributeValue),expectedText,errorMessage);
    }
    // asseration by string variable
    public static void assertByStringVariable(String expectedText,String actualText,String errorMessage)
    {
        Assert.assertEquals(actualText,expectedText,errorMessage);
    }
    public static void getCurrentURL()
    {
        driver.getCurrentUrl();
    }

    public static void refresh()
    {
        driver.navigate().refresh();
    }

    // Categories SortBy Position

    public static void sortByPosition(String position)
    {
        if (position.equalsIgnoreCase("Price: Low to High"))
        {
            selectByText(By.id("products-orderby"), "Price: Low to High");
        } else if (position.equalsIgnoreCase("Name: A to Z"))
        {
            selectByText(By.id("products-orderby"), "Name: A to Z");
        } else if (position.equalsIgnoreCase("Name: Z to A"))
        {
            selectByText(By.id("products-orderby"), "Price: High to Low");
        } else if (position.equalsIgnoreCase("Created on"))
        {
            selectByText(By.id("products-orderby"), "Created on");
        }

    }

    // Method for Arrange Product By Display per Page
    public static void displayBy(int a)
    {
        if(a == 3)
        {
            selectByText(By.id("products-pegesize"),"3");
        }else if (a == 6)
        {
            selectByText(By.id("products-pegesize"),"6");
        } else if (a == 9)
        {
            selectByText(By.id("products-pegesize"),"9");
        }
    }
    // Reusable method for to check product is arrange in ascending or Low to High
    public static boolean ascendingOrLowToHighOrder(By by)
    {
        java.util.List<WebElement> productsNames_WebElement = driver.findElements(by);
        java.util.List<String> product_names = new ArrayList<String>();

        for (WebElement e : productsNames_WebElement)
        {
            String s = e.getText();
            product_names.add(s);
        }
        boolean isSorted = Ordering.natural().isOrdered(product_names);
        return isSorted;

    }

    // Reusable method for to check product is arrange in Descending or High to low
    public static boolean descendingOrHighToLowOrder(By by)
    {
        java.util.List<WebElement> productsNames_WebElement = driver.findElements(by);
        java.util.List<String> product_names = new ArrayList<String>();

        for (WebElement e : productsNames_WebElement)
        {
            String s = e.getText();
            product_names.add(s);
        }
        boolean isSorted = !(Ordering.natural().isOrdered(product_names));
        return isSorted;
    }
}
