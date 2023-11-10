package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;
import static core.Utils.LOGGER;
import static core.Utils.getMappingByKey;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver, getMappingByKey("searchPage"));
    }

    public void verifySearchPageNavigated(String item) {
        WebElement searchResultTitle = driver.findElement(By.xpath("//div[contains(@class, 'content-title')]/h1"));
        String value = searchResultTitle.getAttribute("innerText");
        Assertions.assertEquals(format("Search - " + item), value, "Search page was not navigated.");
        LOGGER.info("Search page navigated successfully.");
    }

    public void verifySearchResults(String item) {
        String searchTerm = item.toLowerCase();
        WebElement firstResult = driver.findElement(By.xpath("(//div[@class='caption']/h4[@class='title']/a)[1]"));
        String value = firstResult.getAttribute("innerText");
        Assertions.assertTrue(value.toLowerCase().contains(searchTerm), "Search result doesn't corresponds to search item.");
        LOGGER.info("Search result corresponds with search item.");
    }

    public void addItemToCart(String item) {
        WebElement result = driver.findElement(By.xpath(String.format("//h4/a[text()='%s']", item)));
        result.click();
        WebElement addToCartButton = driver.findElement(By.xpath("(//button[@title='Add to Cart'])[2]"));
        addToCartButton.click();

    }


    public void verifyCartBadge() {
        navigate();
        WebElement cartBadge = driver.findElement(By.xpath("(//span[contains(@class, 'cart-item-total')])[1]"));
        String value = cartBadge.getAttribute("innerText");
        Assertions.assertEquals("1", value, "Cart badge is empty.");
        LOGGER.info("Card's badge amount correspondes with item/s added.");
    }

    public void verifyItemAddedToCart(String item) {
        openCart();
        WebElement cartItem = driver.findElement(By.xpath("//td/a[@title]"));
        String value = cartItem.getAttribute("innerText");
        Assertions.assertEquals(item, value, "Item was not added to cart.");
        LOGGER.info("Item was successfully added to cart.");
    }

    public void openCart() {
        navigate();
        WebElement clickOnCart = driver.findElement(By.xpath("(//div[@class='cart-icon'])[1]"));
        clickOnCart.click();
    }

    public void editCart() {
        WebElement editButton = driver.findElement(By.xpath("//a[contains(@href, 'checkout/cart') and @role='button']"));
        editButton.click();
    }

}
