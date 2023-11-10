package core;

import enums.BrowserTypes;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import pages.*;

import static core.Utils.getMappingByKey;
import static core.Utils.LOGGER;

public class BaseTest {
    private static WebDriver driver;
    public static RegistrationPage registrationPage;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static SearchPage searchPage;
    public static ShoppingCartPage shoppingCartPage;
    public static CheckoutGeneralPage checkoutPage;
    public static CheckoutConfirmPage checkoutConfirmPage;

    @BeforeAll
    public static void setUp() {
        BrowserTypes browser = BrowserTypes.valueOf(getMappingByKey("chooseBrowser"));
        driver = BrowserTypes.choseBrowser(browser);
        LOGGER.info("Initializing WebDriver");
        driver.manage().window().maximize();
        driver.get(getMappingByKey("homePage"));
        LOGGER.info("Home Page navigated");
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        checkoutPage = new CheckoutGeneralPage(driver);
        checkoutConfirmPage = new CheckoutConfirmPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);

    }

    @AfterAll
    public static void tearDown() {
        System.gc();
        driver.close();
        LOGGER.info("Driver is shutting down");
    }

    public void login() {
        var loginDetails = DetailsFactory.loginUser();
        loginPage.navigate();
        loginPage.login(loginDetails);
    }

    public void addItemToCart(String product) {
        homePage.navigate();
        homePage.searchForItem(product);
        searchPage.addItemToCart(product);
    }


}
