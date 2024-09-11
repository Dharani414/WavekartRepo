package com.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().window().maximize();
        driver.get("http://stage-cloud.wavemakeronline.com/pkz7ftnbsk2m/WaveKart/#/Main");

        //finding login button
//        Thread.sleep(3000);
        By  loginbtn = By.xpath("//span[text()='All Products']");
                WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement loginButton = mywait.until(ExpectedConditions.presenceOfElementLocated(loginbtn));
        loginButton.click();

//        boolean usernameField = driver.findElement(By.name("j_username")).isEnabled();
//        System.out.println(usernameField);
    }
}
