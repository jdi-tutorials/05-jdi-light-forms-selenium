package jdisite.pages;

import jdisite.sections.ContactForm;
import jdisite.sections.SimpleContactForm;

import static jdisite.utils.DriverUtils.DRIVER;
import static org.openqa.selenium.support.PageFactory.initElements;

public class ContactPage /*extends BasePage*/ {
    public static final String URL = "https://jdi-testing.github.io/jdi-light/contacts.html";
    public static ContactForm contactForm = initElements(DRIVER, ContactForm.class);

    /*public ContactPage() { super(
            "https://jdi-testing.github.io/jdi-light/contacts",
            "Contact Form");
    }*/
    public static SimpleContactForm sContactForm = initElements(DRIVER, SimpleContactForm.class);
}
