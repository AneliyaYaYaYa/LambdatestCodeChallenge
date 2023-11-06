import enums.BrowserTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static utils.Utils.getUIMappingByKey;
import static utils.Utils.LOGGER;

public class BaseTest {
    private static WebDriver driver;

    //@BeforeAll
    @Test
    public  void setUp() {
        BrowserTypes browser = BrowserTypes.valueOf(getUIMappingByKey("chooseBrowser"));
        driver = BrowserTypes.choseBrowser(browser);
        LOGGER.info("Initializing WebDriver");
        driver.manage().window().maximize();
        driver.get(getUIMappingByKey("homePage"));
        LOGGER.info("Home Page navigated");
    }

    @AfterAll
    public static void tearDown() {
        System.gc();
        driver.close();
        LOGGER.info("Driver is shutting down");
    }
}
