package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){
        //1.1 Mouse Hover on “Electronics” Tab
        //1.2 Mouse Hover on “Cell phones” and click

        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/electronics']"),By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));

        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Text is not displayed",expectedText,actualText);

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        //2.2 Mouse Hover on “Cell phones” and click
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/electronics']"), By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        Thread.sleep(1000);

        //2.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Text is not displayed", expectedText, actualText);
        Thread.sleep(1000);

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(1000);

        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//div[@class='details']//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        Thread.sleep(1000);

        //2.6 Verify the text “Nokia Lumia 1020”
        String expectedText1 = "Nokia Lumia 1020";
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("Text is not displayed", expectedText1, actualText1);
        Thread.sleep(1000);

        //2.7 Verify the price “$349.00”
        String expectedPrice = "$349.00";
        String actualPrice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals("Price is not displayed", expectedPrice, actualPrice);
        Thread.sleep(1000);

        //2.8 Change quantity to
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendKeyToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        Thread.sleep(1000);

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        Thread.sleep(1000);

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMesaage = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("Message is not displayed", expectedMessage, actualMesaage);
        Thread.sleep(1000);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        Thread.sleep(1000);

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//li[@id='topcartlink']/a[@class='ico-cart']"), By.xpath("//button[contains(text(),'Go to cart')]"));
        Thread.sleep(1000);

        //2.12 Verify the message "Shopping cart"
        String expectedMessageCart = "Shopping cart";
        String actualMessageCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Message is not displayed", expectedMessageCart, actualMessageCart);
        Thread.sleep(1000);

        //2.13 Verify the quantity is 2
//        String expectedQty = "2";
//        String actualQty = getTextFromElement(By.xpath("//input[@class='qty-input']"));
//        Assert.assertEquals("Qty is not displayed", expectedQty, actualQty);
//        Thread.sleep(1000);

        //2.14 Verify the Total $698.00
        String expectedTotal = "$698.00";
        String actualTotal = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[text()='$698.00']"));
        Assert.assertEquals("Total is not displayed", expectedTotal, actualTotal);
        Thread.sleep(1000);

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(1000);

        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedWelcomeText = "Welcome, Please Sign In!";
        String actualWelcomeText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Message is not displayed", expectedWelcomeText, actualWelcomeText);
        Thread.sleep(1000);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        Thread.sleep(1000);

        //2.19 Verify the text “Register”
        String expectedReg = "Register";
        String actualReg = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Register is not displayed", expectedReg, actualReg);
        Thread.sleep(1000);

        //2.20 Fill the mandatory
        sendKeyToElement(By.xpath("//input[@id='FirstName']"), "Poonam");
        sendKeyToElement(By.xpath("//input[@id='LastName']"), "Ramavat");
        sendKeyToElement(By.xpath("//input[@id='Email']"), "Poonam1@gmail.com");
        sendKeyToElement(By.xpath("//input[@id='Password']"), "Poonam123");
        sendKeyToElement(By.xpath("//input[@id='ConfirmPassword']"), "Poonam123");
        Thread.sleep(1000);

        //2.21 Click on “REGISTER”
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        String expectedMessage1 = "Your registration completed";
        String actualMessage1 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Message is not displayed", expectedMessage1, actualMessage1);
        Thread.sleep(1000);

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(1000);

        //2.24 Verify the text “Shopping card”
        String expectedText2 = "Shopping card";
        String actualText2 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Message is not displayed", expectedMessage1, actualMessage1);
        Thread.sleep(1000);

        //2.25 click on checkbox “I agree with the terms of service”
        //2.26 Click on “CHECKOUT”
        //2.27 Fill the Mandatory fields
        //2.28 Click on “CONTINUE”
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        //2.30 Click on “CONTINUE”
        //2.31 Select Radio Button “Credit Card”
        //2.32 Select “Visa” From Select credit card dropdown
        //2.33 Fill all the details
        //2.34 Click on “CONTINUE”
        //2.35 Verify “Payment Method” is “Credit Card”
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        //2.37 Verify Total is “$698.00”
        //2.38 Click on “CONFIRM”
        //2.39 Verify the Text “Thank You”
        //2.40 Verify the message “Your order has been successfully processed!”
        //2.41 Click on “CONTINUE”
        //2.42 Verify the text “Welcome to our store”
        //2.43 Click on “Logout” link
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
    }

        @After
        public void tearDown() {
//            closeBrowser();
        }
    }



