package com.wavekart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[text()='My Cart']")
    WebElement clkMyCart;
    @FindBy(xpath = "//a[@caption='My Cart']")
    WebElement chkMyCart;
    @FindBy(xpath = "//span[text()='My Profile']")
    WebElement clkMyProfile;

    public boolean isMyCartExists()
    {
        try
        {
            return (chkMyCart.isDisplayed());
        }
        catch (Exception e)
        {
            return false;
        }
    }
    @FindBy(xpath = "//li[@name='list_services']/a")
    WebElement clkAllProducts;
    public void clickAllProducts()
    {
        clkAllProducts.click();
    }
    public void clickMyCart()
    {
        clkMyCart.click();
    }

    public void clickMyProfile()
    {
        clkMyProfile.click();
    }
}
