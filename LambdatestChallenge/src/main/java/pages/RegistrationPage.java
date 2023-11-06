package pages;

import org.openqa.selenium.WebDriver;

import static utils.Utils.getUIMappingByKey;

public class RegistrationPage extends BasePage{

    public RegistrationPage (WebDriver driver, String url){
super(driver, getUIMappingByKey("registerPage"));
    }
}
