package pages;

import com.github.javafaker.Faker;
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

    public void fillInFirstName(){
        String firstName = faker.name().firstName();
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        firstNameInput.sendKeys(firstName);
    }
    public void fillInLastName(){
        String lastName = faker.name().lastName();
        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        lastNameInput.sendKeys(lastName);
    }
    public void fillInEmail(){
        String email = (faker.name().firstName()+"@abc.com").toString();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);
    }
    public void fillInTelephone(){
        int numb = 10000 + rnd.nextInt(900000);
        String phone = String.valueOf(numb);
        WebElement telephoneInput = driver.findElement(By.name("telephone"));
        telephoneInput.sendKeys(phone);
    }

    public void fillInPassword() {
        int numb = 10000 + rnd.nextInt(900000);
        String pass = String.valueOf(numb);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(pass);
        WebElement confirmPasswordInput = driver.findElement(By.name("confirm"));
        confirmPasswordInput.sendKeys(pass);
    }

    public void agreeToPrivacyPolicy() {
        WebElement agreeCheckbox = driver.findElement(By.xpath("//label[@for='input-agree']"));
        agreeCheckbox.click();
    }

    public void clickContinue() {
        WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit']"));
        continueButton.click();
    }

}
