package core;

import models.RegistrationDetails;
import org.apache.commons.lang3.RandomStringUtils;

public class DetailsFactory {


    public static RegistrationDetails createUser() {
        var registrationDetails = new RegistrationDetails();
        registrationDetails.setFirstName(RandomStringUtils.randomAlphabetic(6));
        registrationDetails.setLastName(RandomStringUtils.randomAlphabetic(6));
        registrationDetails.setEmail(RandomStringUtils.randomAlphabetic(6) + "@abc.com");
        registrationDetails.setTelephone(Integer.parseInt(RandomStringUtils.randomNumeric(7)));
        registrationDetails.setPassword(RandomStringUtils.randomAlphanumeric(7));
        registrationDetails.setPasswordConfirmation(registrationDetails.getPassword());
    return  registrationDetails;
    }
    //public static
}