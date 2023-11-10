package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static core.Utils.LOGGER;

public  class BasePage {
    public String url;
    protected WebDriver driver;
    public BasePage(WebDriver driver, String url){
        this.driver = driver;
        this.url=url;
    }

    public void navigate(){
        driver.get(url);
        LOGGER.info("Page was successfully navigated.");
    }

    public void verifyHeader(String message) {
        WebElement successTitle = driver.findElement(By.xpath("//div/h1[contains(@class, 'page-title')]"));
        String value = successTitle.getAttribute("innerText");
        Assertions.assertEquals(message, value.trim(), "Header title not as expected.");
       //Assertions.assertTrue(value.contains(message), "Header title not as expected.");
        LOGGER.info("Header verified successfully.");
    }
    public void verifyPageNavigated(String expectedUrl) {
        String actualUrl=driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl, "Expected page was not navigated.");
        LOGGER.info("Page was successfully navigated.");
    }
}
