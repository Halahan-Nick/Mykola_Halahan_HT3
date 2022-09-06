package org.example;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {
    public ChromeDriver driver;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        System.out.println("Test start");
    }

    @After
    public void close() {
        driver.quit();
        System.out.println("Test close");
    }
}
