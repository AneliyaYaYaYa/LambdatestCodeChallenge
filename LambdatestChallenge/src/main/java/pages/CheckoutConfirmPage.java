package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static core.Utils.getMappingByKey;

public class CheckoutConfirmPage extends BasePage {
    public CheckoutConfirmPage(WebDriver driver) {
        super(driver, getMappingByKey("checkoutConfirmPage"));
    }

    public WebElement confirmOrder() {
        return driver.findElement(By.id("button-confirm"));
    }

}
