package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.Utils.LOGGER;
import static java.lang.String.format;

public class BasePage {
    public String url;
    protected WebDriver driver;
    private static WebDriverWait wait;

    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigate() {
        driver.get(url);
        LOGGER.info("Page was successfully navigated.");
    }

    public void verifyHeader(String message) {
        WebElement successTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h1[contains(@class, 'page-title')]")));
        String value = successTitle.getAttribute("innerText");
        Assertions.assertEquals(message, value.trim(), format("Header title not as expected. Expected: %s, received: %s", message, value));
        LOGGER.info("Page title verified successfully.");
    }

    public void verifyPageNavigated(String expectedUrl)  {
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl, "Expected page was not navigated.");
        LOGGER.info("Page was successfully navigated.");
    }
}
