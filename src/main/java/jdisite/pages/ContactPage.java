package jdisite.pages;

import jdisite.sections.ContactForm;

import static jdisite.utils.DriverUtils.DRIVER;
import static org.openqa.selenium.support.PageFactory.initElements;

public class ContactPage {
    public static final String URL = "https://jdi-testing.github.io/jdi-light/contacts.html";
    public static final String TITLE = "Contact Form";
    public static ContactForm contactForm = initElements(DRIVER, ContactForm.class);
}
