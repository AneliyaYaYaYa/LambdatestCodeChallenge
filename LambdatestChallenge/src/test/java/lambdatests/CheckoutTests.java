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
    public void checkout_when_validDataProvided() throws InterruptedException {
        addItemToCart(product);
        checkoutPage.navigate();
        checkoutPage.checkOut(userTypeGuest);
        checkoutPage.verifyPageNavigated(getMappingByKey("checkoutConfirmPage"));
        checkoutPage.verifyHeader(getMappingByKey("checkout.confirmOrder"));
        checkoutConfirmPage.confirmOrder().click();
        checkoutConfirmPage.verifyPageNavigated(getMappingByKey("checkoutSuccessPage"));
        checkoutConfirmPage.verifyHeader(getMappingByKey("checkout.successHeader"));
    }


    @Test
    public void checkoutAsLoggedUser_when_validDataProvided() throws InterruptedException {
        login();
        addItemToCart(product);
        checkoutPage.navigate();
        checkoutPage.checkOutAsLoggedUser();
        checkoutPage.verifyPageNavigated(getMappingByKey("checkoutConfirmPage"));
        checkoutPage.verifyHeader(getMappingByKey("checkout.confirmOrder"));
        checkoutConfirmPage.confirmOrder().click();
        checkoutConfirmPage.verifyPageNavigated(getMappingByKey("checkoutSuccessPage"));
        checkoutConfirmPage.verifyHeader(getMappingByKey("checkout.successHeader"));
    }

}

