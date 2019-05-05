package com.jdi.tests;

import com.jdi.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdi.states.State.loggedIn;
import static com.jdi.test.data.DefaultDataProvider.FULL_CONTACT;
import static com.jdi.test.data.DefaultDataProvider.SIMPLE_CONTACT;
import static jdisite.enums.MenuOptions.ContactForm;
import static jdisite.pages.ContactPage.contactForm;
import static jdisite.pages.JDISite.*;
import static jdisite.utils.DriverUtils.DRIVER;
import static org.testng.Assert.assertEquals;

public class ContactForm implements TestsInit {
    @BeforeMethod
    public void before() {
        loggedIn();
        selectInMenu(ContactForm);
    }

    @Test
    public void submitContactFormTest() {
        assertEquals(DRIVER.getCurrentUrl(),
            "https://jdi-testing.github.io/jdi-light/contacts.html");
        assertEquals(DRIVER.getTitle(), "Contact Form");
        contactForm.submit(FULL_CONTACT);
        contactForm.check(FULL_CONTACT);
    }
    @Test
    public void submitContactFormSimpleTest() {
        assertEquals(DRIVER.getCurrentUrl(),
                "https://jdi-testing.github.io/jdi-light/contacts.html");
        assertEquals(DRIVER.getTitle(), "Contact Form");
        contactForm.submit(SIMPLE_CONTACT);
        contactForm.check(SIMPLE_CONTACT);
    }
}
