package lambdatests;

import core.BaseTest;
import core.DetailsFactory;
import org.junit.jupiter.api.Test;

import static core.Utils.getMappingByKey;

public class RegistrationTests extends BaseTest {

    @Test
    public void registerUser_when_validaDataProvided() {
        var registrationDetails = DetailsFactory.createUser();
        registrationPage.navigate();
        registrationPage.register(registrationDetails);
        registrationPage.verifyPageNavigated(getMappingByKey("registerPageSuccess"));
        registrationPage.verifyHeader(getMappingByKey("register.successHeader"));
    }

}
