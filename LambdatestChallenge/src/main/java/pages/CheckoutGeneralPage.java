package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static core.Utils.LOGGER;
import static core.Utils.getMappingByKey;
import static java.lang.String.format;
import static pages.RegistrationPage.faker;

public class CheckoutGeneralPage extends BasePage{
    public CheckoutGeneralPage(WebDriver driver) {
        super(driver, getMappingByKey("checkoutPage"));
    }

    public void selectUserType(String user){
        WebElement userType = driver.findElement(By.xpath(format("//div[contains(@class, 'custom-control') and descendant::label[contains(@for, 'guest')]]", user)));
        userType.click();
    }

    public void fillInPersonalDetails() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillInFirstName();
        registrationPage.fillInLastName();
        registrationPage.fillInEmail();
        registrationPage.fillInTelephone();
    }

    public void fillInBillingDetails() {
        String address = faker.address().streetAddress();
        WebElement addressInput = driver.findElement(By.name("address_1"));
        addressInput.sendKeys(address);

        String city = faker.address().cityName();
        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys(city);

        String postCode = faker.address().zipCode();
        WebElement postCodeInput = driver.findElement(By.name("postcode"));
        postCodeInput.sendKeys(postCode);

    }
    public void agreeToPrivacyPolicy() {
        WebElement agreeCheckbox = driver.findElement(By.xpath("//label[@for='input-agree']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", agreeCheckbox);
        agreeCheckbox.click();
    }

    public void clickContinue() {
        WebElement continueButton = driver.findElement(By.id("button-save"));
        continueButton.click();
    }


}
