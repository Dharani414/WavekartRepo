package com.wavekart.testCases;

import com.wavekart.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

public class TC002_AddToCartTest extends BaseClass{

   @Test(groups={"Master","Regression"})
    public void addToCart() throws InterruptedException
    {
        logger.info("Adding to cart test case started");
        try
        {
            //Testing login
            LoginPage lp = new LoginPage(driver);
            Thread.sleep(2000);
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
            AllProductsPage pp = new AllProductsPage(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            pp.HighToLow();
            pp.selectItem();

            //getting product details
            ProductDetails pd = new ProductDetails(driver);
            pd.addToCart();//clicking add to cart button

            //validating whether product added to cart or not
            MyCart mc = new MyCart(driver);
            boolean itemAdded=mc.isItemAdded();
            Assert.assertEquals(itemAdded,true,"Item is not added to cart");
            logger.info("Added to cart successfully");

        }
        catch(NoSuchElementException e)
        {
            System.out.println("Nosuch element exception occured:"+e.getMessage());
        }
    }

}
