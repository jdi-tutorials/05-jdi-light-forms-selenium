package jdisite.pages;

import jdisite.sections.ContactForm;

import static jdisite.utils.DriverUtils.DRIVER;
import static org.openqa.selenium.support.PageFactory.initElements;

public class ContactPage {
    public static ContactForm contactForm = initElements(DRIVER, ContactForm.class);
}
