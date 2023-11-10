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


    public WebElement paymentMethod() {
        return driver.findElement(By.xpath("//div/input[@name='payment_method']/following-sibling::label"));
    }

    public WebElement shippingMethod() {
        return driver.findElement(By.xpath("//div/input[@name='shipping_method']/following-sibling::label"));
    }

    public void agreeToShippingMethod() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", shippingMethod());
        shippingMethod().click();
    }

    public WebElement termsAndConditions() {
        return driver.findElement(By.xpath("//label[@for='input-agree']"));
    }

    public WebElement privacyPolicy() {
        return driver.findElement(By.xpath("//label[@for='input-account-agree']"));
    }

    public void agreeToTermsAndConditions() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", termsAndConditions());
        termsAndConditions().click();

    }

    public WebElement continueButton() {
        return driver.findElement(By.id("button-save"));

    }

    public void checkOut(String userType) {
        userType(userType).click();
        var personalDetails = DetailsFactory.createUser();
        var billingDetails = DetailsFactory.createBillingDetails();
        addPersonalDetails(personalDetails);
        addBillingDetails(billingDetails);
        paymentMethod().click();
        shippingMethod().click();
        agreeToTermsAndConditions();
        if (privacyPolicy().isDisplayed()) {
            privacyPolicy().click();
        }
        continueButton().click();
    }

    public WebElement billingAddressExisting() {
        return driver.findElement(By.xpath("//div/input[@id='input-payment-address-existing']/following-sibling::label"));
    }

    public void checkOutAsLoggedUser() {
        if (telephoneField().getText() == null) {
            var personalDetails = DetailsFactory.createUser();
            telephoneField().sendKeys(String.valueOf(personalDetails.getTelephone()));
        }
        billingAddressExisting().click();
        paymentMethod().click();
        agreeToShippingMethod();
        agreeToTermsAndConditions();
        continueButton().click();
    }
}
