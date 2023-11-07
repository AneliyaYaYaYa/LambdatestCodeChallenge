package lambdatests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

public class RegistrationTests extends BaseTest {

    @Test
    public void registerUser_when_validDataProvided() {
        registrationPage.navigateToPage();
        registrationPage.fillInFirstName();
        registrationPage.fillInLastName();
        registrationPage.fillInEmail();
        registrationPage.fillInTelephone();
        registrationPage.fillInPassword();
        registrationPage.agreeToPrivacyPolicy();
        registrationPage.clickContinue();
        registrationPage.verifyRegistrySuccessPageNavigated();
        registrationPage.verifySuccessMessage();
    }

}
