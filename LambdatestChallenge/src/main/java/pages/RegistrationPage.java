package pages;

import com.github.javafaker.Faker;
import models.RegistrationDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static core.Utils.getMappingByKey;

public class RegistrationPage extends BasePage {
    protected static Faker faker;
    protected static Random rnd;

    public RegistrationPage(WebDriver driver) {
        super(driver, getMappingByKey("registerPage"));
        faker = new Faker();
        rnd = new Random();
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


    public void fillInFirstName() {
        String firstName = faker.name().firstName();
        driver.findElement(By.name("firstname")).sendKeys(firstName);
    }

    public void fillInLastName() {
        String lastName = faker.name().lastName();
        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        lastNameInput.sendKeys(lastName);
    }

    public void fillInEmail() {
        String email = (faker.name().firstName() + "@abc.com").toString();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);
    }

    public void fillInTelephone() {
        int numb = 10000 + rnd.nextInt(900000);
        String phone = String.valueOf(numb);
        WebElement telephoneInput = driver.findElement(By.name("telephone"));
        telephoneInput.sendKeys(phone);
    }
}