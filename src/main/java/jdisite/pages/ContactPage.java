package jdisite.pages;

import jdisite.sections.ContactForm;

import static jdisite.utils.DriverUtils.DRIVER;
import static org.openqa.selenium.support.PageFactory.initElements;

public class ContactPage extends BasePage {
    public ContactPage() { super(
        "https://jdi-testing.github.io/jdi-light/contacts",
        "Contact Form");
    }
    public static ContactForm contactForm = initElements(DRIVER, ContactForm.class);
}
