package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.DecimalFormat;

import static java.lang.Double.parseDouble;

public class CartPage extends BasePage {

    private static final String YOUR_CART = "//h1[text()='Your cart']";
    private static final String CART_PAGE_CHOSEN_BOOK = "https://kidkiddos.com/collections/english-only/products/i-love-to-go-to-daycare-childrens-picture-book-english-only";
    private static final String QUANTITY = "//input[@class='cart__qty-input']";
    private static final String ADD_TO_CART = "//button[@name='add']";
    private static final String UPDATE = "//input[@class='btn btn--secondary cart__update cart__update--large small--hide']";
    private static final String BOOK_PRICE = "//*[@class='cart__price-wrapper cart-flex-item']//descendant::*[@class='cbb-price-digits']";
    private static final String TOTAL_BOOK_PRICE = "//*[@class='text-right small--hide']//descendant::*[@class='cbb-price-digits']";


    public void navigateToBookPage() {
        webDriver.get(CART_PAGE_CHOSEN_BOOK);
    }

    public void clickOnAddToCart() {
        clickElementByXpath(ADD_TO_CART);
    }

    public boolean isPageTitleVisible() {
        return elementExists(YOUR_CART);
    }

    public void bookQuantity(int number) {
        WebElement quantity = findElementByXpath(QUANTITY);
        quantity.sendKeys(Keys.DELETE);
        quantity.sendKeys(String.valueOf(number));
    }

    public WebElement findTheElement(String xpath) {
        return findElementByXpath(xpath);
    }

    public void updateButton() {
        clickElementByXpath(UPDATE);
    }

    public boolean isPriceUpdated(int number) {
        WebElement price = findTheElement(BOOK_PRICE);

        double initialPrice = Double.parseDouble(price.getText());
        double correctPrice = initialPrice * number;
        DecimalFormat format = new DecimalFormat("0.00");
        String dp=format.format(correctPrice);
        correctPrice = Double.valueOf(dp);

        WebElement quantity = findElementByXpath(QUANTITY);
        quantity.sendKeys(Keys.DELETE);
        quantity.sendKeys(String.valueOf(number));

        clickElementByXpath(UPDATE);
        WebElement priceNew = findTheElement(TOTAL_BOOK_PRICE);
        if (Double.parseDouble(priceNew.getText()) == correctPrice) {
            return true;
        }
        else{
            return false;
        }
    }
}


