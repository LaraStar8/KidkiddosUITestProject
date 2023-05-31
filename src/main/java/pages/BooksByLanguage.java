package pages;

import consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BooksByLanguage extends BasePage{
    private static final String BOOKS_BY_LANGUAGE = "//a[@aria-controls='SiteNavLabel-books-by-language']";
    private static final String BOOKS_BY_ENGLISH_ONLY = "//*[(@id='SiteNavLabel-books-by-language')]//descendant::*[contains (text(),'English Only')]";
    public void navigateToHomePage(){
        webDriver.get(Consts.MAIN_URL);
    }

    public void clickBookByLanguage(){
        clickElementByXpath(BOOKS_BY_LANGUAGE);
    }

    public EnglishOnlyBooks openEnglishOnlyBooks(){
        clickElementByXpath(BOOKS_BY_LANGUAGE);
        clickElementByXpath(BOOKS_BY_ENGLISH_ONLY);
        return new EnglishOnlyBooks();
    }
}
