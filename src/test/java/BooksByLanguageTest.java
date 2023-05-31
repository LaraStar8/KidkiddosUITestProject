import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.BooksByLanguage;
import pages.EnglishOnlyBooks;
import pages.MainPage;
import utils.UseCaseBase;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class BooksByLanguageTest extends UseCaseBase {
    private static BooksByLanguage booksByLanguage;

    @BeforeAll
    public static void classSetup() {
        booksByLanguage = new BooksByLanguage();
    }

    @BeforeEach
    public void beforeTest() {
        booksByLanguage.navigateToHomePage();
    }

    @Test
    public void openBooksByLanguageTest() {
        booksByLanguage.clickBookByLanguage();
        booksByLanguage.takeScreenshot("BooksByLanguageMenu");
    }

    @Test
    public void openEnglishOnlyBooksTest() {
        EnglishOnlyBooks englishOnlyBooks = booksByLanguage.openEnglishOnlyBooks();
        Boolean englishOnlyLoaded = englishOnlyBooks.isEnglishOnlyOpened();
        assertTrue(englishOnlyLoaded);
    }
}
