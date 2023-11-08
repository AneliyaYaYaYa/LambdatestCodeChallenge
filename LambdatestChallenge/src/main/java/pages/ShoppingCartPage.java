package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static core.Utils.getMappingByKey;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver, getMappingByKey("shoppingCartPage"));
    }
    public void removeItem(){
        WebElement removeItem = driver.findElement(By.xpath("//button[contains(@onclick, 'cart.remove')]"));
        removeItem.click();
    }

}
