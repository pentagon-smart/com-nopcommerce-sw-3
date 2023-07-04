package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
        //1.1 Click on Computer Menu.
        //1.2 Click on Desktop
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"),By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));


        //1.3 Select Sort By position "Name: Z to A"

        selectByValueFromDropDown(By.name("products-orderby"),"Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        String expectedText = "Name: Z to A";
        String actualTextElement = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals("Product not displayed", expectedText, actualTextElement);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        //2.2 Click on Desktop
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"),By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));

        //2.3 Select Sort By position "Name: A to Z"
        selectByIndex(By.xpath("//select[@id='products-orderby']"),1);
        Thread.sleep(1000);

        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//div[@class='buttons']//button[text()='Add to cart']"));
        Thread.sleep(1000);

        //2.5 Verify the Text "Build your own computer"

        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Text is not displayed.",expectedText,actualText);
        Thread.sleep(1000);


        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByValue(By.xpath("//select[@id='product_attribute_1']"), "1");;
        Thread.sleep(1000);

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByValue(By.xpath("//select[@id='product_attribute_2']"),"5");
        Thread.sleep(1000);

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        Thread.sleep(1000);

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        Thread.sleep(1000);

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"

//        clickOnElement(By.xpath("//label[contains(text(),'Microsoft Office [+$50.00]')]"));
//        Thread.sleep(1000);

        clickOnElement(By.xpath("//label[contains(text(),'Total Commander [+$5.00]')]"));
        Thread.sleep(1000);

        //2.11 Verify the price "$1,475.00"
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals("Price is not displayed",expectedPrice,actualPrice);

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        Thread.sleep(1000);

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMesaage = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("Message is not displayed",expectedMessage,actualMesaage);
        Thread.sleep(1000);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        Thread.sleep(1000);

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.

        mouseHover(By.xpath("//li[@id='topcartlink']/a[@class='ico-cart']"),By.xpath("//button[contains(text(),'Go to cart')]"));
        Thread.sleep(1000);

        //2.15 Verify the message "Shopping cart"

        String expectedMessageCart = "Shopping cart";
        String actualMessageCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Message is not displayed",expectedMessageCart,actualMessageCart);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        sendKeyToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.xpath("//button[@class='button-2 update-cart-button']"));
        Thread.sleep(1000);

        //2.17 Verify the Total"$2,950.00"
        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[text()='$2,950.00']"));
        Assert.assertEquals("total is not displayed",expectedTotal,actualTotal);

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(1000);

        //2.20 Verify the Text “Welcome, Please Sign In!”
        String expectedWelcomeText = "Welcome, Please Sign In!";
        String actualWelcomeText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Message is not displayed",expectedWelcomeText,actualWelcomeText);

        //2.21 Click on “CHECKOUT AS GUEST”
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        Thread.sleep(1000);

        //2.22 Fill the all mandatory field

        sendKeyToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Poonam");
        sendKeyToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Ramavat");
        sendKeyToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"poonam@gmail.com");
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");;
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"),"Arizona");
        sendKeyToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"New York");
        sendKeyToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"Burley Road");
        sendKeyToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"FA1234");
        sendKeyToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"09887241121");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']//button[text()='Continue']"));
        Thread.sleep(1000);

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        Thread.sleep(1000);

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']//button[text()='Continue']"));
        Thread.sleep(1000);

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByValueFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Master card");
        Thread.sleep(1000);

        //2.28 Fill all the details

        sendKeyToElement(By.xpath("//input[@id='CardholderName']"),"Poonam");
        sendKeyToElement(By.xpath("//input[@id='CardNumber']"),"5425233430109903");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"12");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2026");
        sendKeyToElement(By.xpath("//input[@id='CardCode']"),"0136");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']//button[text()='Continue']"));
        Thread.sleep(1000);

        //2.30 Verify “Payment Method” is “Credit Card”
        String expectedMethod = "Credit Card";
        String actualMethod = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Method is not displayed",expectedMethod,actualMethod);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod = "Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//li[@class='shipping-method']/span[@class='value']"));
        Assert.assertEquals("Method is not displayed",expectedShippingMethod,actualShippingMethod);

        //2.33 Verify Total is “$2,950.00”
        String expectedTotal1 = "$2,950.00";
        String actualTotal1 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[text()='$2,950.00']"));
        Assert.assertEquals("Total is not displayed",expectedTotal1,actualTotal1);

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        Thread.sleep(1000);

        //2.35 Verify the Text “Thank You”
        String expectedText2 = "Thank you";
        String actualText2 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Text is not displayed",expectedText2,actualText2);

        //2.36 Verify the message “Your order has been successfully processed!”
        String expectedText3 = "Your order has been successfully processed!";
        String actualText3 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Message is not displayed",expectedText3,actualText3);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        Thread.sleep(1000);

        //2.37 Verify the text “Welcome to our store”
        String expectedText4 = "Welcome to our store";
        String actualText4 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Message is not displayed",expectedText4,actualText4);

    }
    @After
    public void tearDown() {
          closeBrowser();
    }
}
