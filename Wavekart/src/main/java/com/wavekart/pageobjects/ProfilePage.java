package com.wavekart.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage{

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));




    WebElement PhoneNumber = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("widget-id779")));

    @FindBy(xpath = "//span[text()='Save']")
    WebElement saveDetails;

    public void ClickEditDetails()
    {
        WebElement clkEditDetails = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Edit Details']")));
        clkEditDetails.click();
    }
    public void setPhoneNumber()
    {
        PhoneNumber.clear();
    }
    public void ClickSaveDetails()
    {
        saveDetails.click();
    }
}
