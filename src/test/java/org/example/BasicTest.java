package org.example;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.object.AvicPage;

/**
 * Supplement the framework created in the class with 3-4 tests
 * that check the functionality of the https://avic.ua/ site
 * _______________________________________________________________
 * 1) Programming code should correspond to Java Code Convention.
 * 2) Use Waits where necessary (give preference to Explicit waits).
 * 3) Apply different types of Asserts .
 * 4) Use sensible names for methods and variables
 */
public class BasicTest {

    /**
     * Global BeforeTest settings precondition
     */

    @BeforeClass
    public void globalPrecondition() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    /**
     * test load time is less than 10 seconds
     * Assert checks site header title is same as Expected
     */

    @Test
    public void siteTitleTest() {
        AvicPage avicPage = new AvicPage();
        avicPage.navigateTo();
        avicPage.implicityTimer(10);
        String actualTitle = avicPage.getTitle();
        String expectedTitle = "AVIC ™ - зручний інтернет-магазин побутової техніки та електроніки в Україні. | Avic";
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println
                ("Site title is same as Expected");
        avicPage.quitDriver();
    }

    /**
     * test load time is less than 10 seconds
     * Assert checks site header contains Phone Number 0800307900 as a link
     */
    @Test
    public void sitePhoneTest() {
        AvicPage avicPage = new AvicPage();
        avicPage.navigateTo();
        avicPage.implicityTimer(10);
            String phoneXPath = "//div[@class='header-top__item']//a[@href='tel:0800307900']";
            String actualXPath = avicPage.
                getPhoneLinkFromHeader(phoneXPath);
        String expectedXPath = phoneXPath;
        Assert.assertEquals(actualXPath, expectedXPath);
        System.out.println
                ("Phone Number 0800307900 is in site header as a link");
        avicPage.quitDriver();
    }

    /**
     * test load time of elementName from page is less than time in seconds
     * time = 10 seconds
     * elementName = "input_search"
     */

    @Test
    public void searchElementLoadingTime() {
        AvicPage avicPage = new AvicPage();
        avicPage.navigateTo();
        avicPage.loadTime(10,"input_search");
        System.out.println
                ("Input search field was found on main page");
        avicPage.quitDriver();
    }


    /**
     * test checks flow:
     * 1. Sets browser resolution (width * height) width=1280, height=720
     * 2. Is there search field in header
     * 3. We type "iPhone" text in search field
     * 4. We press "Enter" button from keyboard
     * 5. Assert checks Site title is same as Expected
     */

    @Test
    public void searchWithEnterFromKeyboard() {
        AvicPage avicPage = new AvicPage();
        avicPage.navigateTo();
        avicPage.windowResolution(1280,720);
            String searchFieldXPath = "//div[@class='header-bottom__search']//input[@id='input_search']";
            String query = "IPhone";
        avicPage.searchFieldInputByXPath(query, searchFieldXPath);
        avicPage.clickEnterFromKeyboard(searchFieldXPath);
        String actualTitle = avicPage.getTitle();
            String expectedTitle = "Результати пошуку";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println
                ("Iphone search was executed with press Enter button from keyboard" +
                        "Page title same as Expected");
        avicPage.quitDriver();
    }

    /**
     * test checks flow:
     * 1. Is there search field in header
     * 2. We type "iPhone" text in search field
     * 3. We press "Search" button from UI
     * 4. Assert checks Actual URL is same as Expected
     */

    @Test
    public void searchWithFindButton() {
        AvicPage avicPage = new AvicPage();
        avicPage.navigateTo();
        avicPage.windowResolution(1280,720);
            String expectedURL = "https://avic.ua/ua/search-results?query=IPhone";
            String searchButtonXPath = "//button[@class='button-reset search-btn']";
            String searchFieldById = "input_search";
            String query = "IPhone";
        avicPage.searchFieldInputById(query,searchFieldById);
        avicPage.clickSearchButton(searchButtonXPath);
        Assert.assertEquals(avicPage.getCurrentURL(), expectedURL, " Expected and Actual URL  match");

        System.out.println("Iphone search was executed" +
                "Phone Number 0800307900 is in site header as a link");
        avicPage.quitDriver();
    }

}