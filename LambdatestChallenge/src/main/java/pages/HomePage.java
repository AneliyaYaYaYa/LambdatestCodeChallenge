package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static core.Utils.LOGGER;
import static core.Utils.getMappingByKey;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver, getMappingByKey("homePage"));
    }

    public WebElement searchField() {
        return driver.findElement(By.name("search"));
    }

    public WebElement searchButton() {
        return driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
    }

    public void searchForItem(String item) {
        searchField().sendKeys(item);
        searchButton().click();
    }

}
