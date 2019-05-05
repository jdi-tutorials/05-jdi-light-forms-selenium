package jdisite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static jdisite.entities.DefaultData.ROMAN;
import static jdisite.pages.JDISite.loginForm;

public class HomePage extends BasePage {
    public HomePage() { super("https://jdi-testing.github.io/jdi-light/"); }
    @FindBy(id ="user-icon") public WebElement userIcon;
    @FindBy(id ="user-name") public WebElement userName;
    @FindBy(css = ".fa-sign-out") public WebElement logout;

    public void loggedOut() {
        if (userName.isDisplayed()) {
            if (!logout.isDisplayed())
                userIcon.click();
            logout.click();
        }
    }
    public void loggedIn() {
        if (!userName.isDisplayed()) {
            if (loginForm.isHidden())
                userIcon.click();
            loginForm.loginAs(ROMAN);
        }
    }
}
