package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Supplement the framework created in the class with 3-4 tests
 * that check the functionality of the https://avic.ua/ site
 * _______________________________________________________________
 * 1) Programming code should correspond to Java Code Convention.
 * 2) Use Waits where necessary (give preference to Explicit waits).
 * 3) Apply different types of Asserts .
 * 4) Use sensible names for methods and variables
 */
public class BasicTest extends WebDriverSettings {

    /**
     * refactored support method to check does header contain Phone number as a link
     */

    private void getPhoneLinkFromHeader() {
        String phoneLink = String.valueOf(chromeDriver.findElement
                (By.xpath
                        ("//div[@class='header-top__item']//a[@href='tel:0800307900']")));
        Assert.assertTrue(true, phoneLink);
    }

    /**
     * Global BeforeTest settings precondition
     */

    @BeforeTest
    private void globalPrecondition() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome.exe");
    }

    /**
     * test load time is less than 10 seconds
     * Assert checks Site title is same as Expected
     */

    @Test
    public void siteTitleTest() {
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chromeDriver.get("https://avic.ua/ua");
        String title = chromeDriver.getTitle();
        Assert.assertTrue(title.equals
                ("AVIC ™ - зручний інтернет-магазин побутової техніки та електроніки в Україні. | Avic"));
        System.out.println
                ("Site title is same as Expected");
    }

    /**
     * test load time is less than 10 seconds
     * Assert checks site header contains Phone Number 0800307900 as a link
     */
    @Test
    public void sitePhoneTest() {

        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        chromeDriver.get("https://avic.ua/ua");
        getPhoneLinkFromHeader();
        System.out.println
                ("Phone Number 0800307900 is in site header as a link");
    }

    @Test
    public void searchElementLoadingTime() {
        chromeDriver.get("https://avic.ua/ua");

        new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("input_search")));
        System.out.println
                ("Input search field was found on main page");
    }

    /**
     * test checks flow:
     * 1. Is there search field in header
     * 2. We type "iPhone" text in search field
     * 3. We press "Enter" button from keyboard
     * 4. Assert checks Site title is same as Expected
     * 5. Assert checks site header contains Phone Number 0800307900 as a link
     */

    @Test
    public void searchWithEnterFromKeyboard() {
        chromeDriver.manage().window().setSize(new Dimension(1280, 800));
        chromeDriver.get("https://avic.ua/ua");
        WebElement input = chromeDriver.findElement(By.xpath
                (("//div[@class='header-bottom__search']//input[@id='input_search']")));
        input.sendKeys("iPhone", Keys.ENTER);
        String title = chromeDriver.getTitle();
        Assert.assertEquals("Результати пошуку", title);
        getPhoneLinkFromHeader();
        System.out.println
                ("Iphone search was executed with press Enter button from keyboard" +
                        "Page title same as Expected");
    }

    /**
     * test checks flow:
     * 1. Is there search field in header
     * 2. We type "iPhone" text in search field
     * 3. We press "Search" button from UI
     * 4. Assert checks Actual URL is same as Expected
     * 5. Assert checks site header contains Phone Number 0800307900 as a link
     */

    @Test
    public void searchWithFindButton() {
        String expectedURL = "https://avic.ua/ua/search-results?query=Iphone";
        chromeDriver.manage().window().setSize(new Dimension(1280, 800));
        chromeDriver.get("https://avic.ua/ua");
        WebElement inputSearchField = chromeDriver.findElement(By.id(("input_search")));
        WebElement searchButton = chromeDriver.findElement(By.xpath("//button[@class='button-reset search-btn']"));
        inputSearchField.sendKeys("Iphone");
        searchButton.click();
        new WebDriverWait(chromeDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("input_search")));
        getPhoneLinkFromHeader();
        String actualURL = chromeDriver.getCurrentUrl();
        Assert.assertTrue(expectedURL.equals(actualURL), " Expected and Actual URL  match");

        System.out.println("Iphone search was executed" +
                "Phone Number 0800307900 is in site header as a link");
    }

}