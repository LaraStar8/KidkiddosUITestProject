import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.MainPage;
import utils.UseCaseBase;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTest extends UseCaseBase {
    private static LoginPage loginPage;
    private static final String EMAIL = "//input[@name='customer[email]']";
    private static final String PASSWORD = "//input[@name='customer[password]']";

    @BeforeAll
    public static void classSetup() {
        loginPage = new LoginPage();
    }

    @BeforeEach
    public void beforeTest() {
        loginPage.navigateToLoginPage();
    }

    @Test
    public void loadLoginPageTest() {
        Boolean success = loginPage.isPageVisible();
        loginPage.takeScreenshot("LoginPageLoadingTest");
        assertTrue(success);
    }


    @ParameterizedTest
    @CsvSource({" ,123", " , ", "lara@gmailcom, ","lara@gmailcom, 123", "lara@gmail.com, $"})
    public void negativeLoginTest(String email, String password) {
        if (email==null) {
            loginPage.sendText(EMAIL, "");
        } else {
            loginPage.sendText(EMAIL, email);
        }
        if (password==null){
            loginPage.sendText(PASSWORD, "");
        } else {
            loginPage.sendText(PASSWORD, password);
        }
        loginPage.submitButtonClick();
        Boolean success = loginPage.isImNotARobotExist();
        assertTrue(success);
//        Boolean success = loginPage.isErrorVisible();
//        assertTrue(success);
    }

    @Test
    public void spaceEntryTest() {
        loginPage.sendText(EMAIL, " ");
        loginPage.sendText(PASSWORD, " ");
        loginPage.submitButtonClick();
        Boolean success = loginPage.isImNotARobotExist();
        assertTrue(success);
    }
}
