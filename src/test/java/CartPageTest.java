import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.ProductPage;
import utils.UseCaseBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class CartPageTest extends UseCaseBase {
    private static CartPage cartPage;
    private static final String BOOK_QUANTITY = "//input[@class='cart__qty-input']";

    @BeforeAll
    public static void classSetup() {
        cartPage = new CartPage();
    }

    @BeforeEach
    public void beforeTest() {
        cartPage.navigateToBookPage();
    }

    @Test
    public void bookQuantityTest() {
        cartPage.clickOnAddToCart();
        cartPage.bookQuantity(6);
        String actualQuantity = cartPage.findTheElement(BOOK_QUANTITY).getAttribute("value");
        assertEquals("6", actualQuantity);
    }

    @Test
    public void isPriceUpdatedTest() {
        cartPage.clickOnAddToCart();
        boolean updated = cartPage.isPriceUpdated(15);
        assertTrue(updated);
    }
}
