import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CartPage;
import pages.EnglishOnlyBooks;
import pages.ProductPage;
import utils.UseCaseBase;

import static org.junit.jupiter.api.Assertions.*;

public class ProductPageTest extends UseCaseBase {
    private static ProductPage productPage;
    private static  final String BOOK_QUANTITY = "//input[@class='product-form__input']";
    private static  final String BOOK_FORMAT ="//div[@class='selector-wrapper js product-form__item']/select[@data-index='option1']" ;
    private static  final String HARDCOVER_FORMAT ="//*[@id='SingleOptionSelector-0']/option[@value = 'Hardcover']";

    @BeforeAll
    public static void classSetup() {
        productPage = new ProductPage();
    }

    @BeforeEach
    public void beforeTest() {
        productPage.navigateToProductPage();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Paperback", "Hardcover"})
    public void formatTest(String format) {
        WebElement choseAFormat = productPage.findTheElement(BOOK_FORMAT);
        Select selectedFormat = new Select(choseAFormat);
        selectedFormat.selectByVisibleText(format);
        String formatValue = selectedFormat.getFirstSelectedOption().getText();
        assertEquals(format, formatValue);
    }

    @Test
    public void hardcoverBookOpenTest() {
        productPage.choseHardCoverBook();
        String actualFormat = productPage.findTheElement(HARDCOVER_FORMAT).getAttribute("value");
        assertEquals("Hardcover", actualFormat);
    }
    @Test
    public void bookQuantityTest() {
        productPage.bookQuantity(5);
        String actualQuantity = productPage.findTheElement(BOOK_QUANTITY).getAttribute("value");
        assertEquals("5", actualQuantity);
    }
    @Test
    public void openCartPageTest(){
        CartPage cartPage =productPage.openAddToCart();
        boolean isOpened = cartPage.isPageTitleVisible();
        assertTrue(isOpened);
    }
}

