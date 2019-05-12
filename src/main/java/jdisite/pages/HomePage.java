package jdisite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    public static final String URL = "https://jdi-testing.github.io/jdi-light/";
    @FindBy(id ="user-icon") public static WebElement userIcon;
    @FindBy(id ="user-name") public static WebElement userName;
}
