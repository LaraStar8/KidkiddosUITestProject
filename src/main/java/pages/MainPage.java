package pages;

import consts.Consts;

public class MainPage extends BasePage {
    private static final String LOGO_IMG = "//img[@itemprop='logo']";
    private static final String CONTACT_US_OPTION = "//a[text()='Contact us']";
    private static final String LOGIN_PAGE = "//*[@class='icon icon-login']";

    public void navigateToMainPage(){
        webDriver.get(Consts.MAIN_URL);
    }
    public boolean isLogoVisible(){
        Boolean isVisible = elementExists(LOGO_IMG);
        return isVisible;
    }
    public ContactUsPage openContactUsPage(){
        clickElementByXpath(CONTACT_US_OPTION);
        return new ContactUsPage();
    }
    public LoginPage openLoginPage(){
        clickElementByXpath(LOGIN_PAGE);
        return new LoginPage();
    }

}
