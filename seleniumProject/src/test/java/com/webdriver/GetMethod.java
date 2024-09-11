package com.webdriver;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class GetMethod {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://stage-cloud.wavemakeronline.com/pkz7ftnbsk2m/WaveKart/#/Main");
        System.out.println("Title of web page :"+driver.getTitle());//Title of web page
        System.out.println("Url of web page "+driver.getCurrentUrl());//url of the web page
        System.out.println(driver.getPageSource());//returns source code of page

        String windowId = driver.getWindowHandle();//returns Id of single browser window
        System.out.println(windowId);//value is dynamic, changes every time we run the app

        //getWindowHandles() return the multiple browser window ids, it stores in set<String> data type

    }
}
