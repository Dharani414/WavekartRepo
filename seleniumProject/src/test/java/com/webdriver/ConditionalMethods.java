package com.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class ConditionalMethods {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        driver.get("http://stage-cloud.wavemakeronline.com/pkz7ftnbsk2m/WaveKart/#/Main");
        driver.manage().window().maximize();
       // By appLogo = By.name("AppLogo");(finding the logo of page)
        //WebElement logo = driver.findElement(appLogo);
        //System.out.println("Display status of logo: " + logo.isDisplayed());
        //finding login button
        By loginButton = By.cssSelector("a[name='Login']");
        Thread.sleep(5000);
        driver.findElement(loginButton).click();

       boolean usernameField =  driver.findElement(By.name("j_username")).isEnabled();
       System.out.println(usernameField);




    }
}
