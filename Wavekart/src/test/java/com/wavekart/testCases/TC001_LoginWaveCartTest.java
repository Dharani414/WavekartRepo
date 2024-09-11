package com.wavekart.testCases;

import com.wavekart.pageobjects.HomePage;
import com.wavekart.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class TC001_LoginWaveCartTest extends BaseClass{
    @Test(groups={"Sanity","Master"})
    public void Login_Wavecart() throws InterruptedException
    {
        logger.info("Starting TC001_LoginWaveCartTest ");
        try {
            //login page
            WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
            LoginPage hp = new LoginPage(driver);

            Thread.sleep(2000);
            WebElement lnkLogin =mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@name='Login']")));
            lnkLogin.click();
            logger.info("Clicked on login ");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            hp.setUserName(p.getProperty("username"));
            hp.setPassword(p.getProperty("password"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            hp.clickSignIn();

            //home page
            HomePage hpage = new HomePage(driver);
            boolean targetPage=hpage.isMyCartExists();
            Assert.assertEquals(targetPage,true,"login failed");
            logger.info("Signed in to application");

        }
        catch (Exception e)
        {
            logger.error("Login Test Failed");
        }
        logger.info("Finished testing TC001_LoginWaveCartTest");
    }
}
