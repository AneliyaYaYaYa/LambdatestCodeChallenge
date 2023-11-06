import enums.BrowserTypes;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RegistrationPage;

import static utils.Utils.getUIMappingByKey;
import static utils.Utils.LOGGER;

public class BaseTest {
    private static WebDriver driver;
    public static RegistrationPage registrationPage;
    public static LoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        BrowserTypes browser = BrowserTypes.valueOf(getUIMappingByKey("chooseBrowser"));
        driver = BrowserTypes.choseBrowser(browser);
        LOGGER.info("Initializing WebDriver");
        driver.manage().window().maximize();
        driver.get(getUIMappingByKey("homePage"));
        LOGGER.info("Home Page navigated");
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        //manage timeouts
    }

    @AfterAll
    public static void tearDown() {
        System.gc();
        driver.close();
        LOGGER.info("Driver is shutting down");
    }
}
