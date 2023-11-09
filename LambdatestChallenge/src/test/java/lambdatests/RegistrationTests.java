package lambdatests;

import core.BaseTest;
import models.RegistrationDetails;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static core.Utils.getMappingByKey;

public class RegistrationTests extends BaseTest {

    @Test
    public void registerUser_when_validaDataProvided(){
        var details = new RegistrationDetails();
        details.setFirstName(RandomStringUtils.randomAlphabetic(6));
        details.setLastName(RandomStringUtils.randomAlphabetic(6));
        details.setEmail(RandomStringUtils.randomAlphabetic(6)+"@abc.com");
        details.setTelephone(Integer.parseInt(RandomStringUtils.randomNumeric(7)));
        details.setPassword(RandomStringUtils.randomAlphanumeric(7));
        details.setPasswordConfirmation(details.getPassword());

        registrationPage.navigate();
        registrationPage.register(details);
        registrationPage.verifyPageNavigated(getMappingByKey("registerPageSuccess"));
        registrationPage.verifyHeader(getMappingByKey("register.successHeader"));
    }

}
