package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.Utils.getUIMappingByKey;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver, getUIMappingByKey("loginPage"));
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
        Assertions.assertEquals(actualUrl, expectedUrl, "Login was not successful.");
    }

    public void verifyLoginFailed() {
        String expectedUrl=getUIMappingByKey("loginPage");
        String actualUrl=driver.getCurrentUrl();
        Assertions.assertEquals(actualUrl, expectedUrl, "Login was successful.");
    }

    public void validateErrorMessage(){

    }
}
