package com.wavekart.testCases;

import com.wavekart.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class TC003_OrderItemTest extends BaseClass{
    @Test(groups={"Master","Regression"})
    public void orderItem() throws InterruptedException
    {
        try
        {
            //Testing login
            LoginPage lp = new LoginPage(driver);
            Thread.sleep(3000);
            lp.ClickLogin();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            logger.info("Clicked on login ");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            lp.setUserName(p.getProperty("username"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            lp.setPassword(p.getProperty("password"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            lp.clickSignIn();

            //validating login
            HomePage hpage = new HomePage(driver);
            boolean targetPage=hpage.isMyCartExists();
            Assert.assertEquals(targetPage,true,"login failed");
            logger.info("Signed in to application");

            //Adding an item to cart
            HomePage hp = new HomePage(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            hp.clickAllProducts();//clicking allproducts in home page
            AllProductsPage prodpage = new AllProductsPage(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            prodpage.HighToLow();
            prodpage.selectItem();

            //getting product details
            ProductDetails pd = new ProductDetails(driver);
            pd.addToCart();//clicking add to cart button
            MyCart mc =new MyCart(driver);
            mc.clickPlaceOrder();

            //Payment for the ordered Item
            PaymentPage pp =new PaymentPage(driver);
            pp.ClickContinue();
            pp.ClickContinue();
            pp.selectPaymentMethod();
            pp.ClickContinue();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            pp.clickConfirmOrder();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

            //validating order details
           MyOrders ordItem = new MyOrders(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            boolean ItemOrdered = ordItem.isItemOrdered();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            Assert.assertEquals(ItemOrdered,true,"Item is not shown in my orders");




        }
        catch(NoSuchElementException e)
        {
            System.out.println("Nosuch element exception occured:"+e.getMessage());
        }

    }
}
