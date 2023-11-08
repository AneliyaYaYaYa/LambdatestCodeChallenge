package lambdatests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import static core.Utils.getMappingByKey;

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
        registrationPage.verifyPageNavigated(getMappingByKey("registerPageSuccess"));
        registrationPage.verifyHeader(getMappingByKey("register.successHeader"));
    }

}
