package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static core.Utils.getMappingByKey;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver, getMappingByKey("homePage"));
    }

    public void searchForItem(String item) {
        WebElement searchField = driver.findElement(By.name("search"));
        searchField.sendKeys(item);
        WebElement searchButton = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
        searchButton.click();
    }

}
