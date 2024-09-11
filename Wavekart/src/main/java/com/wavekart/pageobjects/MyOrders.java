package com.wavekart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyOrders extends BasePage{

    public MyOrders(WebDriver driver) {
        super(driver);
    }
   By name= By.name("productName");
    WebElement OrderedItem = driver.findElement(name);
    By OrderedItem2 = By.name("productName");


    public boolean isItemOrdered()
    {
        try
        {
            return OrderedItem.isDisplayed();
        }
        catch (Exception e) {
            return false;
        }
    }

}
