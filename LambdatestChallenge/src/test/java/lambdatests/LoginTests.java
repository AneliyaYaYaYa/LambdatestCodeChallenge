package lambdatests;

import core.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTests extends BaseTest {


    @Test
    public void login_when_validCredentialsProvided() {
        loginPage.navigateToPage();
        loginPage.fillInEmail("a@abg.com");
        loginPage.fillInPassword("123456");
        loginPage.clickLoginButton();
        loginPage.verifyLoginSuccess();
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
    }
}
