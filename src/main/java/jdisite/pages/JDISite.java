package jdisite.pages;

import jdisite.sections.LoginForm;
import org.openqa.selenium.By;

import static jdisite.utils.DriverUtils.DRIVER;
import static org.openqa.selenium.support.PageFactory.initElements;

public class JDISite {
    public static HomePage homePage = initElements(DRIVER, HomePage.class);
    public static ContactPage contactPage = initElements(DRIVER, ContactPage.class);

    public static LoginForm loginForm = initElements(DRIVER, LoginForm.class);
    public static void selectInMenu(String value) {
        DRIVER.findElement(By.xpath("//*[contains(@class, 'sidebar-menu')]//span[.='"+value+"']"))
                .click();
    }
}
