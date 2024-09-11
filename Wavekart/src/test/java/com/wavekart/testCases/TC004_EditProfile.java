package com.wavekart.testCases;

import com.wavekart.pageobjects.ProfilePage;
import com.wavekart.pageobjects.HomePage;
import com.wavekart.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC004_EditProfile extends BaseClass{
    @Test(groups={"Master","Regression"})
 public void EditProfile() {

     logger.info("Starting TC001_LoginWaveCartTest ");
     try {
         //login page
         LoginPage hp = new LoginPage(driver);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         Thread.sleep(2000);
         hp.ClickLogin();

         logger.info("Clicked on login ");
         hp.setUserName(p.getProperty("username"));
         hp.setPassword(p.getProperty("password"));
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         hp.clickSignIn();
         logger.info("User Logged in to the page");
         //home page
         HomePage hpage = new HomePage(driver);
         boolean targetPage = hpage.isMyCartExists();
         Assert.assertEquals(targetPage, true, "login failed");
         logger.info("Signed in to application");

         //EditProfile
         hpage.clickMyProfile();
         logger.info("My Profile page opened");
         ProfilePage profilePage = new ProfilePage(driver);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         profilePage.ClickEditDetails();

         profilePage.setPhoneNumber();
         profilePage.ClickSaveDetails();//saving the details
         logger.info("Edited Details saved");

     }
     catch (Exception e) {
         logger.error("Login Test Failed");
     }
 }
}
