package com.wavekart.testCases;

import org.apache.logging.log4j.Logger;//log4j
import org.apache.logging.log4j.LogManager;//log4j
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;
    @BeforeClass(groups={"Sanity","Master","Regression"})
    @Parameters({"os","browser"})
    public void setup(String os, String br) throws IOException {
        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        logger=LogManager.getLogger(this.getClass());

        switch(br.toLowerCase()) {
            case "chrome" : driver = new ChromeDriver(); break;
            case "edge" : driver = new EdgeDriver();break;
            default : System.out.println("Invalid browser name.."); return;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appUrl"));// Reading url form properties file
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

   /* @AfterClass(groups={"Sanity","Master","Regression"})
    public void tearDown()
    {
        driver.quit();
    }

    */

}
