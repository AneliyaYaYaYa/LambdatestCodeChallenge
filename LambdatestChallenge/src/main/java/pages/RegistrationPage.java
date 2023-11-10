package pages;

import com.github.javafaker.Faker;
import models.RegistrationDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static core.Utils.getMappingByKey;

public class RegistrationPage extends BasePage {


    public RegistrationPage(WebDriver driver) {
        super(driver, getMappingByKey("registerPage"));

    }

    public WebElement firstNameField() {
        return driver.findElement(By.name("firstname"));
    }

    public WebElement lastNameField() {
        return driver.findElement(By.name("lastname"));
    }

    public WebElement emailField() {
        return driver.findElement(By.name("email"));
    }

    public WebElement telephoneField() {
        return driver.findElement(By.name("telephone"));
    }

    public WebElement passwordField() {
        return driver.findElement(By.name("password"));
    }

    public WebElement confirmPasswordField() {
        return driver.findElement(By.name("confirm"));
    }

    public WebElement agreeButton() {
        return driver.findElement(By.xpath("//label[@for='input-agree']"));
    }

    public WebElement continueButton() {
        return driver.findElement(By.xpath("//input[@type='submit']"));
    }

    public void register(RegistrationDetails details) {
        firstNameField().sendKeys(details.getFirstName());
        lastNameField().sendKeys(details.getLastName());
        emailField().sendKeys(details.getEmail());
        telephoneField().sendKeys(String.valueOf(details.getTelephone()));
        passwordField().sendKeys(details.getPassword());
        confirmPasswordField().sendKeys(details.getPasswordConfirmation());
        agreeButton().click();
        continueButton().click();
    }

}