package lambdatests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import static core.Utils.getMappingByKey;

public class CheckoutTests extends BaseTest {

    public String userType = "guest";


    @Test
    public void checkoutAsGuest_when_validDataProvided() {
        addItemToCart();
        openCheckout();
        checkoutPage.selectUserType(userType);
        checkoutPage.fillInPersonalDetails();
        checkoutPage.fillInBillingDetails();
        checkoutPage.agreeToPrivacyPolicy();
        checkoutPage.clickContinue();
        //checkoutPage.verifyPageNavigated(getMappingByKey("checkoutConfirmPage"));
        checkoutPage.verifyHeader(getMappingByKey("checkout.confirmOrder"));
        checkoutConfirmPage.clickConfirm();
        checkoutConfirmPage.verifyPageNavigated(getMappingByKey("checkoutSuccessPage"));
        checkoutConfirmPage.verifyHeader(getMappingByKey("checkout.successHeader"));
    }
}
