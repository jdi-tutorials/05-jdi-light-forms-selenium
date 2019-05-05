package com.jdi.tests;

import com.jdi.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdi.test.data.DefaultDataProvider.FULL_CONTACT;
import static jdisite.enums.MenuOptions.ContactForm;
import static jdisite.pages.ContactPage.contactForm;
import static jdisite.pages.JDISite.homePage;
import static jdisite.pages.JDISite.selectInMenu;

public class ContactForm implements TestsInit {
    @BeforeMethod
    public void before() {
        homePage.loggedIn();
        selectInMenu(ContactForm);
    }

    @Test
    public void submitSeleniumContactFormTest() {
        contactForm.submit(FULL_CONTACT);
        contactForm.check(FULL_CONTACT);
    }
}
