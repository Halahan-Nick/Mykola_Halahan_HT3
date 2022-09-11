package page.object;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class AvicPage {

    private WebDriver driver;

    public AvicPage() {
        this.driver = new ChromeDriver();
    }

    /**
     * close web-driver page after test implementation
     */
    public void quitDriver() {
        driver.quit();
    }

    /**
     * navigate to main page
     */
    public void navigateTo() {
        driver.get("https://avic.ua/ua");
    }

    /**
     * implicity timer
     */
    public void implicityTimer(int k) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(k));
    }

    /**
     * get page title
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * test load time of elementName from page is less than time in seconds
     */

    public void loadTime(int time, String elementName) {
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(elementName)));
    }

    /**
     * set web-driver page window resolution
     */
    public void windowResolution(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    /**
     * send search request from keyboard page with Enter
     */
    public void clickEnterFromKeyboard(String headerSearchFieldXPath) {
        WebElement clickEnterButton = driver.findElement(By.xpath(headerSearchFieldXPath));
        clickEnterButton.sendKeys(Keys.ENTER);
    }


    /**
     * set request name = query and xpath of searchfield = searchFieldByXPath
     */
    public void searchFieldInputByXPath(String query, String searchFieldByXPath) {
        WebElement input = driver.findElement(By.xpath
                ((searchFieldByXPath)));
        input.sendKeys(query, Keys.ENTER);
    }

    /**
     * set request name = query and xpath of searchfield = searchFieldById
     */
    public void searchFieldInputById (String query, String searchFieldById) {
        WebElement input = driver.findElement(By.id
                ((searchFieldById)));
        input.sendKeys(query, Keys.ENTER);
    }

    /**
     * send search request from keyboard page with UI button by XPath
     */
    public void clickSearchButton(String searchButtonXPath) {
        WebElement searchButton = driver.findElement(By.xpath(searchButtonXPath));
        searchButton.click();
    }

    /**
     * send search request from keyboard page with Enter
     *
     * @return
     */
    public String getCurrentURL () {
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }

    /**
     * support method to check does header contain Phone number as a link
     * "//div[@class='header-top__item']//a[@href='tel:0800307900']"
     */
    public String getPhoneLinkFromHeader(String phoneXPath) {

        driver.findElement
                (By.xpath("//div[@class='header-top__item']//a[@href='tel:0800307900']"));
        return phoneXPath;
    }

}