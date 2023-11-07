package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static core.Utils.LOGGER;
import static core.Utils.getMappingByKey;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver, getMappingByKey("loginPage"));
    }

    public void fillInEmail(String email){
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);
    }
    public void fillInPassword(String password) {
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton() {
        WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit']"));
        continueButton.click();
    }
    public void verifyLoginSuccess() {
        String expectedUrl="https://ecommerce-playground.lambdatest.io/index.php?route=account/account";
        String actualUrl=driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl, expectedUrl, "Login was not successful although valid credentials provided..");
        LOGGER.info("User was successfully logged in.");
    }

    public void verifyLoginFailed() {
        String expectedUrl= getMappingByKey("loginPage");
        String actualUrl=driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl, expectedUrl, "Login was successful although incorrect credentials provided.");
        LOGGER.info("User was not logged in.");
    }

    public void logout(){
        WebElement logoutButton = driver.findElement(By.xpath("(//a[contains(@href, 'logout')])[2]"));
        logoutButton.click();
    }

}
