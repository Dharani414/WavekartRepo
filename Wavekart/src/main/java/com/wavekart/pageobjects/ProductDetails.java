package com.wavekart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetails extends BasePage{

    public ProductDetails(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@name='AddToCart']")
    WebElement btnAddToCart;
    public void addToCart()
    {
        btnAddToCart.click();
    }
}
