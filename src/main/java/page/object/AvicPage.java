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
    public void implicityTimer(int k){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(k));
    }

    /**
     * get page title
     */
    public String getTitle() {
        return  driver.getTitle();
    }
    /**
     * test load time of elementName from page is less than time in seconds
     */

    public void loadTime(int time,String elementName) {
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(elementName)));
    }

    /**
     * set web-driver page window resolution
     */
    public void windowResolution(int width,int height) {
        driver.manage().window().setSize(new Dimension(width,height));
    }

    /**
     * set web-driver page window resolution
     */
    public void findSearchInputField() {
        driver.findElement(By.xpath
                (("//div[@class='header-bottom__search']//input[@id='input_search']")));
    }

    /**
     * set web-driver page window resolution
     */
    public void searchField(String querry) {
        WebElement input = driver.findElement(By.xpath
                (("//div[@class='header-bottom__search']//input[@id='input_search']")));
        input.sendKeys(querry, Keys.ENTER);
    }

    /**
     * support method to check does header contain Phone number as a link
     * "//div[@class='header-top__item']//a[@href='tel:0800307900']"
     */
    public String getPhoneLinkFromHeader(String phoneXPath) {

        driver.findElement
                (By.xpath
                        ("//div[@class='header-top__item']//a[@href='tel:0800307900']"));
        return phoneXPath;
    }

}