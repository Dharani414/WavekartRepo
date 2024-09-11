package com.wavekart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

   @FindBy(xpath="//span[normalize-space()='Login']")
   WebElement lnkLogin;

    @FindBy(xpath = "//p[@caption='Username']/..//div//input")
    WebElement txtUserName;
    @FindBy(xpath = "//p[@caption='Password']/..//div//input")
    WebElement txtPassword;
    @FindBy(xpath = "//span[text()='Sign in']")
    WebElement btnSignIn;
    //Login Page
    public void ClickLogin(){lnkLogin.click(); }
    public void setUserName(String Uname)
    {
        txtUserName.sendKeys(Uname);
    }
    public void setPassword(String Pass)
    {
        txtPassword.sendKeys(Pass);
    }
    public void clickSignIn()
    {
        btnSignIn.click();
    }
}
