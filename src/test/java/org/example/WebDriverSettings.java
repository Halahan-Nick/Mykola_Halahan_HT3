package org.example;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class WebDriverSettings {
    public ChromeDriver chromeDriver;
    @BeforeTest
    public void setUp() {
        chromeDriver = new ChromeDriver();
        System.out.println("Test start");
    }

    @AfterTest
    public void close() {
        chromeDriver.quit();
        System.out.println("Test close");
    }
}