package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static core.Utils.LOGGER;
import static core.Utils.getMappingByKey;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver, getMappingByKey("loginPage"));
    }


    public WebElement emailField(){
        return driver.findElement(By.name("email"));
    }

    public WebElement passwordField(){
        return driver.findElement(By.name("password"));
    }

    public WebElement loginButton(){
        return driver.findElement(By.xpath("//input[@value='Login']"));
    }

    public void login (String email, String password){
        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        loginButton().click();
    }

    public void verifyLoginFailed() {
        Boolean display = driver.findElement(By.xpath("//input[@value='Login']")).isDisplayed();
        if (display){
            LOGGER.info("Login with invalid credentials was not successful.");
        } else {
            LOGGER.info("User logged in with invalid credentials.");
        }
    }

    public void errorMessageDisplayed(){
        Boolean displayError = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]")).isDisplayed();
        if (displayError){
            LOGGER.info("Error message displayed.");
        } else {
            LOGGER.info("No error message.");
        }

    }
    public void logout(){
        WebElement logoutButton = driver.findElement(By.xpath("(//a[contains(@href, 'logout')])[2]"));
        logoutButton.click();
        LOGGER.info("Logout button clicked.");
    }

}
