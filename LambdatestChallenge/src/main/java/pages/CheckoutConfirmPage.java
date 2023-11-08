package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static core.Utils.getMappingByKey;

public class CheckoutConfirmPage extends BasePage{
    public CheckoutConfirmPage(WebDriver driver) {
        super(driver, getMappingByKey("https://ecommerce-playground.lambdatest.io/index.php?route=extension/maza/checkout/confirm"));
    }

    public void clickConfirm() {
        WebElement confirmButton = driver.findElement(By.id("button-confirm"));
        confirmButton.click();
    }


}
