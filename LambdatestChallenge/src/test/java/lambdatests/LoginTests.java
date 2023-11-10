package lambdatests;

import core.BaseTest;
import core.DetailsFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static core.Utils.getMappingByKey;

public class LoginTests extends BaseTest {


    @Test
    public void login_when_validCredentialsProvided() throws InterruptedException {
        var loginDetails = DetailsFactory.loginUser();
        loginPage.navigate();
        loginPage.login(loginDetails);
        loginPage.verifyPageNavigated(getMappingByKey("accountPage"));
        loginPage.logout();
    }

    @ParameterizedTest
    @CsvSource({"a@abg.com, ''", "a@abg.com, 12345678", "'', 123456", "asLisam@abv.bg, 12345678", "'',''"})
    public void loginFails_when_invalidCredentialsProvided(String email, String password) {
        loginPage.navigate();
        loginPage.emailField().sendKeys(email);
        loginPage.passwordField().sendKeys(password);
        loginPage.loginButton().click();
        loginPage.verifyLoginFailed();
        loginPage.errorMessageDisplayed();
    }
}
