package lambdatests;

import core.BaseTest;
import core.DetailsFactory;
import org.junit.jupiter.api.Test;

import static core.Utils.getMappingByKey;

public class CheckoutTests extends BaseTest {

    public String userTypeGuest = getMappingByKey("userType.guest");
    public String userTypeRegister = getMappingByKey("userType.registerAccount");
    public String product = getMappingByKey("product");


    @Test
    public void checkout_when_validDataProvided() {
        addItemToCart(product);
        checkoutPage.navigate();
        checkoutPage.checkOut(userTypeGuest);
        checkoutPage.verifyHeader(getMappingByKey("checkout.confirmOrder"));
        checkoutPage.verifyPageNavigated(getMappingByKey("checkoutConfirmPage"));
        checkoutConfirmPage.confirmOrder().click();
        checkoutConfirmPage.verifyHeader(getMappingByKey("checkout.successHeader"));
        checkoutConfirmPage.verifyPageNavigated(getMappingByKey("checkoutSuccessPage"));
    }


    @Test
    public void checkoutAsLoggedUser_when_validDataProvided() {
        login();
        addItemToCart(product);
        checkoutPage.navigate();
        checkoutPage.checkOutAsLoggedUser();
        checkoutPage.verifyHeader(getMappingByKey("checkout.confirmOrder"));
        checkoutPage.verifyPageNavigated(getMappingByKey("checkoutConfirmPage"));
        checkoutConfirmPage.confirmOrder().click();
        checkoutConfirmPage.verifyHeader(getMappingByKey("checkout.successHeader"));
        checkoutConfirmPage.verifyPageNavigated(getMappingByKey("checkoutSuccessPage"));
    }

}

