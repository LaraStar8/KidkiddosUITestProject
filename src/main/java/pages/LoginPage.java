package pages;

import consts.Consts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    public static final String LOGIN = "//input[@value='customer_login']";
    private static final String ERROR = "//li[text()='Incorrect email or password.']";
    private static final String SIGN_IN ="//*[@value='Sign In']" ;
    private static final String I_AM_NOT_A_ROBOT = "//*[@class='shopify-challenge__message']";

    //    private String xpath;
    public boolean isPageVisible() {
        return elementExists(LOGIN);
    }

    public void navigateToLoginPage() {
        webDriver.get(Consts.LOAD_PAGE_URL);
    }

    public void submitButtonClick() {
        clickElementByXpath(SIGN_IN);
    }

    public boolean isErrorVisible() {
        return elementExists(ERROR);
    }

    public void sendText(String xpath, String text) {
        sendTextToElementByXpath(xpath, text);
    }

    public boolean isImNotARobotExist() {
        Boolean isExists = elementExists(I_AM_NOT_A_ROBOT);
        return isExists;

    }

    public String URL() {
        return getCurrentURL();
    }
}

