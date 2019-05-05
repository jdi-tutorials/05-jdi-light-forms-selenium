package com.jdi.tests;

import com.jdi.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdi.test.data.DefaultDataProvider.FULL_CONTACT;
import static jdisite.enums.MenuOptions.ContactForm;
import static jdisite.pages.ContactPage.contactForm;
import static jdisite.pages.JDISite.*;

public class ContactForm implements TestsInit {
    @BeforeMethod
    public void before() {
        homePage.loggedIn();
        selectInMenu(ContactForm);
    }

    @Test
    public void submitSeleniumContactFormTest() {
        contactPage.open();
        contactForm.submit(FULL_CONTACT);
        contactForm.check(FULL_CONTACT);
    }
}
