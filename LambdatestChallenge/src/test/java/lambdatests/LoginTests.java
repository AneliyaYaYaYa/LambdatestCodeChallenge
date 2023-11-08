package lambdatests;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static core.Utils.getMappingByKey;

public class LoginTests extends BaseTest {


    @Test
    public void login_when_validCredentialsProvided() {
        loginPage.navigateToPage();
        loginPage.fillInEmail(getMappingByKey("validEmail"));
        loginPage.fillInPassword(getMappingByKey("validPassword"));
        loginPage.clickLoginButton();
        loginPage.verifyPageNavigated(getMappingByKey("accountPage"));
        loginPage.logout();
    }

    @ParameterizedTest
    @CsvSource({"a@abg.com, ''", "a@abg.com, 12345678", "'', 123456", "asLisam@abv.bg, 12345678", "'',''"})
    public void loginFails_when_invalidCredentialsProvided(String email, String password) {
        loginPage.navigateToPage();
        loginPage.fillInEmail(email);
        loginPage.fillInPassword(password);
        loginPage.clickLoginButton();
        loginPage.verifyLoginFailed();
        loginPage.errorMessageDisplayed();
    }
}
