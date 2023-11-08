package lambdatests;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import static core.Utils.getMappingByKey;

public class ShoppingCartTests extends BaseTest {

    public String product = getMappingByKey("product");

    @Test
    public void productAddedToCart_when_addToCartClicked(){
        homePage.navigateToPage();
        homePage.searchForItem(product);
        searchPage.addItemToCart(product);
        searchPage.verifyCartBadge();
        searchPage.verifyItemAddedToCart(product);
    }

    @Test
    public void removeItemFromCart_when_removeClicked(){
        addItemToCart();
        searchPage.openCart();
        searchPage.editCart();
        shoppingCartPage.removeItem();
        shoppingCartPage.verifyHeader(getMappingByKey("shoppingCart.emptyHeader"));
    }
}
