package jdisite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(id ="user-icon") public WebElement userIcon;
    @FindBy(id ="user-name") public WebElement userName;
    @FindBy(css = ".fa-sign-out") public WebElement logout;
}
