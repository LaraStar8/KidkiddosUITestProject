package utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class UseCaseBase {
    private static WebDriver webDriver;
    private static BasePage page;

    @BeforeAll
    public static void setupMain() {
        page = new BasePage();
        webDriver = SharedDriver.getWebdriver(SharedDriver.Browser.CHROME);
        page.setWebDriver(webDriver);
    }

    @AfterAll
    public static void tearDownMain() {
        SharedDriver.closeDriver();
        webDriver = null;
    }
}
