package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    /**
     * 1. This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * 2. get text from element
     */
    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    /**
     * 3. sendkey method
     */
    public void sendKeyToElement(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }



    /**
     * Select Class
     * 4.1 This method will select the option by visible text
     */
    public void selectByValueFromDropDown(By by,String text){
        new Select(driver.findElement(by)).selectByVisibleText(text);
    }

    /**
     * 4.2 This method will select the option by index
     */
    public void selectByIndex(By by, int indexnumber)
    {
        WebElement dropdown= driver.findElement(by);
        Select select =new Select(dropdown);
        select.selectByIndex(indexnumber);
    }
    /**
     * 4.3 This method will select the option by value
     */
    public void selectByValue(By by, String valueText)
    {
        WebElement dropdown = driver.findElement(by);
        Select select=new Select(dropdown);
        select.selectByValue(valueText);
    }

    /**
     * 5.1 Alerts method for switch to alert
     */
    public void switchToAlert(By by)
    {
        clickOnElement(by);
        driver.switchTo().alert();
    }


    /**
     * 5.2 Alerts method for accept popup
     */
    public void acceptAlert()
    {
        driver.switchTo().alert().accept();
    }


    /**
     * 5.3 Alerts method for dismiss popup
     */
    public void dismissAlert()
    {
        driver.switchTo().alert().dismiss();
    }


    /**
     * 5.4 Alerts method for sendkey
     */
    public void sendKeyAlert(String text)
    {
        driver.switchTo().alert().sendKeys(text);
    }


    /**
     * 5.5 Alerts method for gettext
     */
    public void getTextAlert()
    {
        driver.switchTo().alert().getText();
    }


    /**
     * 6. Action ---> mouse hover
     */
    public void mouseHover(By by, By by1)
    {
        WebElement text1 = driver.findElement(by);
        WebElement text2 = driver.findElement(by1);
        Actions actions= new Actions(driver);
        actions.moveToElement(text1).moveToElement(text2).click().build().perform();
    }


}
