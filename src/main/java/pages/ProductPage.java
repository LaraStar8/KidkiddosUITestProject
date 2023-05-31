package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductPage extends BasePage {
    private  static final String ADD_TO_CART = "//span[@id='AddToCartText-product-template']";
    private  static final String QUANTITY ="//input[@class='product-form__input']";
    private  static final String HARDCOVER ="//*[@id='SingleOptionSelector-0']/option[@value = 'Hardcover']" ;
    private  static final String BOOK_FORMAT ="//div[@class='selector-wrapper js product-form__item']/select[@data-index='option1']" ;
    private  static final String ENGLISH_ONLY_PRODUCT_PAGE = "https://kidkiddos.com/collections/english-only/products/i-love-to-go-to-daycare-childrens-picture-book-english-only";

    public void navigateToProductPage() {
        webDriver.get(ENGLISH_ONLY_PRODUCT_PAGE);
    }

    public void choseBookFormat() {
        clickElementByXpath(BOOK_FORMAT);
    }

    private static final String DESCRIPTION = "//div[@class='product-single__description rte']//following-sibling::*[contains(text(),'Finally, Jimmy discovers how much fun daycare really is!')]";

    public void choseHardCoverBook() {
        clickElementByXpath(HARDCOVER);
    }
    public WebElement findTheElement(String xpath) {
        return findElementByXpath(xpath);
    }
    public void bookQuantity(int number){
        WebElement quantity = findElementByXpath(QUANTITY);
        quantity.sendKeys(Keys.DELETE);
        quantity.sendKeys(String.valueOf(number));
    }
    public CartPage openAddToCart(){
        clickElementByXpath(ADD_TO_CART);
        return new CartPage();
    }
    public boolean isChosenBookOpened(){
       return elementExists(DESCRIPTION);
    }
}

