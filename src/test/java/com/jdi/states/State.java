package com.jdi.states;

import jdisite.entities.DefaultData;

import static jdisite.pages.HomePage.logout;
import static jdisite.pages.HomePage.userIcon;
import static jdisite.pages.JDISite.homePage;
import static jdisite.pages.JDISite.loginForm;

public class State {
    public static void loggedOut() {
        if (homePage.userName.isDisplayed()) {
            if (!logout.isDisplayed())
                userIcon.click();
            logout.click();
        }
    }
    public static void loggedIn() {
        if (!homePage.userName.isDisplayed()) {
            if (loginForm.isHidden())
                userIcon.click();
            loginForm.loginAs(DefaultData.ROMAN);
        }
    }
}
