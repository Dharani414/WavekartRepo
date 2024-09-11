package com.wavekart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class AllProductsPage extends BasePage{
    public AllProductsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@title='Price - High to Low']")
    WebElement clkHighToLow;
    @FindBy(xpath = "//div[contains(@class,'active')]//p[text()='Fujifilm X100S Mirrorless']")
    WebElement clkOneItem;
    public void HighToLow()
    {
        clkHighToLow.click();

    }
    public void selectItem()
    {
        clkOneItem.click();
    }
}
