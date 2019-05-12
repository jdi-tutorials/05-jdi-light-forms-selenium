package com.jdi.states;

import jdisite.entities.DefaultData;

import static jdisite.pages.HomePage.*;
import static jdisite.pages.JDISite.homePage;
import static jdisite.pages.JDISite.loginForm;

public class State {
    public static void loggedIn() {
        if (!homePage.userName.isDisplayed()) {
            if (loginForm.isHidden())
                userIcon.click();
            loginForm.loginAs(DefaultData.ROMAN);
        }
    }
}
