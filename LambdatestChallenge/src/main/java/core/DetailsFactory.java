package core;

import com.github.javafaker.Faker;
import models.BillingDetails;
import models.LoginDetails;
import models.RegistrationDetails;
import org.apache.commons.lang3.RandomStringUtils;

import static core.Utils.getMappingByKey;
import static java.lang.String.format;


public class DetailsFactory {
    protected static Faker faker = new Faker();




    public static RegistrationDetails createUser() {
        var registrationDetails = new RegistrationDetails();
        registrationDetails.setFirstName(faker.name().firstName());
        registrationDetails.setLastName(faker.name().lastName());
        registrationDetails.setEmail(format(faker.name().firstName() + "@abc.com"));
        registrationDetails.setTelephone(Integer.parseInt(RandomStringUtils.randomNumeric(7)));
        registrationDetails.setPassword(RandomStringUtils.randomAlphanumeric(7));
        registrationDetails.setPasswordConfirmation(registrationDetails.getPassword());
        return registrationDetails;
    }

    public static LoginDetails loginUser() {
        var loginDetails = new LoginDetails();
        loginDetails.setEmail(getMappingByKey("validEmail"));
        loginDetails.setPassword(getMappingByKey("validPassword"));
        return loginDetails;
    }

    public static BillingDetails createBillingDetails() {
        var billingDetails = new BillingDetails();
        billingDetails.setAddress(faker.address().streetAddress());
        billingDetails.setCity(faker.address().cityName());
        billingDetails.setPostCode(faker.address().zipCode());
        return billingDetails;
    }
}