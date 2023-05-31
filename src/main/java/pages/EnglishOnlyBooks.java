package pages;

import consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EnglishOnlyBooks extends BasePage {
    private static final String ENGLISH_ONLY = "//h1[contains (text(),'English Only')]";

    public void navigateToEnglishOnlyPage() {
        webDriver.get(Consts.ENGLISH_ONLY_BOOKS);
    }
    public ProductPage productPage(String xpath) {
        clickElementByXpath(xpath);
        return new ProductPage();
    }
    public boolean isEnglishOnlyOpened() {
        return elementExists(ENGLISH_ONLY);
    }
}
