package pages;

import core.DetailsFactory;
import models.BillingDetails;
import models.RegistrationDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static core.Utils.getMappingByKey;
import static java.lang.String.format;

public class CheckoutGeneralPage extends BasePage {
    public CheckoutGeneralPage(WebDriver driver) {
        super(driver, getMappingByKey("checkoutPage"));
    }

    public WebElement userType(String user) {
        return driver.findElement(By.xpath(format("//div[contains(@class, 'custom-control') and descendant::label[contains(@for, '%s')]]", user)));
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

    public WebElement passwordConfirmField() {
        return driver.findElement(By.name("confirm"));
    }


    public WebElement addressField() {
        return driver.findElement(By.name("address_1"));
    }

    public WebElement cityField() {
        return driver.findElement(By.name("city"));
    }

    public WebElement postCodeField() {
        return driver.findElement(By.name("postcode"));
    }

    public void addPersonalDetails(RegistrationDetails details) {
        firstNameField().sendKeys(details.getFirstName());
        lastNameField().sendKeys(details.getLastName());
        emailField().sendKeys(details.getEmail());
        telephoneField().sendKeys(String.valueOf(details.getTelephone()));
        if (passwordField().isDisplayed() && passwordConfirmField().isDisplayed()) {
            passwordField().sendKeys(details.getPassword());
            passwordConfirmField().sendKeys(details.getPasswordConfirmation());
        }
    }
    public void addBillingDetails(BillingDetails billingDetails) {
        addressField().sendKeys(billingDetails.getAddress());
        cityField().sendKeys(billingDetails.getCity());
        postCodeField().sendKeys(billingDetails.getPostCode());
    }
    public WebElement termsAndConditions() {
        return driver.findElement(By.xpath("//label[@for='input-agree']"));
    }
    public WebElement privacyPolicy() {
        return driver.findElement(By.xpath("//label[@for='input-account-agree']"));
    }
    public void agreeToTermsAndConditions() {
       // WebElement termsAndConditions = driver.findElement(By.xpath("//label[@for='input-agree']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", termsAndConditions());
        termsAndConditions().click();

    }

    public WebElement continueButton() {
        return driver.findElement(By.id("button-save"));

    }

    public void checkOut(String userType) {
        userType(userType).click();
        var personalDetails = DetailsFactory.createUser();//using ony part of reg details?!
        var billingDetails = DetailsFactory.createBillingDetails();
        addPersonalDetails(personalDetails);
        addBillingDetails(billingDetails);
        agreeToTermsAndConditions();
        if (privacyPolicy().isDisplayed()) {
            privacyPolicy().click();
        }
        continueButton().click();
    }

    public void checkOutAsLoggedUser() {
        agreeToTermsAndConditions();
        continueButton().click();
    }
}
