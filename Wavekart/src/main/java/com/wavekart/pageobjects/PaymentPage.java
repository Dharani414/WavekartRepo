package com.wavekart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage{
    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[text()='Continue']")
    WebElement clkContinue;
    public void ClickContinue()
    {
        clkContinue.click();
    }
    @FindBy(xpath = "//span[text()='Net Banking']")
    WebElement slctNetBanking;
    public void selectPaymentMethod()
    {
        slctNetBanking.click();
    }
    @FindBy(xpath = "//button//span[text()='Confirm Order']")
    WebElement clkConfirmOrder;
    public void clickConfirmOrder()
    {
        clkConfirmOrder.click();
    }
}
