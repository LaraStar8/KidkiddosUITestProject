import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.EnglishOnlyBooks;
import pages.LoginPage;
import pages.ProductPage;
import utils.UseCaseBase;

import static org.junit.jupiter.api.Assertions.*;

public class EnglishOnlyPageTest extends UseCaseBase {
    private static EnglishOnlyBooks englishOnly;
    private static final String BOOK = "//img[@alt='I-Love-to-Go-to-Daycare-kids-bunnies-bedtime-story-Shelley-Admont-English-language-cover']";

    @BeforeAll
    public static void classSetup() {
        englishOnly = new EnglishOnlyBooks();
    }

    @BeforeEach
    public void beforeTest() {
        englishOnly.navigateToEnglishOnlyPage();
    }

    @Test
    public void isBookLoaded() {
        ProductPage chosenBook = englishOnly.productPage(BOOK);
        Boolean isChosenBookOpened = chosenBook.isChosenBookOpened();
        assertTrue(isChosenBookOpened);
    }
}
