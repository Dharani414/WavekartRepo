package com.wavekart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCart extends BasePage{

    public MyCart(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[text()='My Cart']")
    WebElement clkMyCart;


    @FindBy(xpath = "//p[text()='Fujifilm X100S Mirrorless']")
    WebElement addedItem;

    @FindBy(xpath = "//span[text()='Place Order']")
    WebElement clkPlaceOrder;

    public void clickMyCart()
    {
        clkMyCart.click();
    }
    public boolean isItemAdded()
    {
        try{
            return addedItem.isDisplayed();
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public void clickPlaceOrder()
    {
        clkPlaceOrder.click();
    }
}
