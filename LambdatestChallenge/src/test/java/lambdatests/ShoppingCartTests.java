package lambdatests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

public class ShoppingCartTests extends BaseTest {

    public String product = "iPod Nano";

    @Test
    public void productAddedToCart_when_addToCartClicked(){
        homePage.navigateToPage();
        homePage.searchForItem(product);
        searchPage.addItemToCart(product);
        searchPage.verifyCartBadge();
        searchPage.verifyItemAddedToCart(product);
    }

}
