package jdisite.sections;

import jdisite.entities.ContactInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.String.valueOf;
import static org.testng.Assert.assertEquals;

public class ContactForm {
    @FindBy(css ="#contact-form #name") WebElement name;
    @FindBy(css ="#contact-form #last-name") WebElement lastName;
    @FindBy(css ="#contact-form #position") WebElement position;
    @FindBy(css ="#contact-form #passport-number") WebElement passportNumber;
    @FindBy(css ="#contact-form #passport-seria") WebElement passportSeria;
    @FindBy(css ="#contact-form #passport") WebElement passport;
    // Dropdown
    @FindBy(css ="#contact-form #gender") WebElement gender;
    private Select gender() {
        return new Select(gender);
    }
    /*@FindBy(id ="gender") WebElement genderExpand;
    @FindBy(id ="gender") List<WebElement> genderList;
    @FindBy(id ="gender") WebElement genderValue;*/
    // Combobox
    @FindBy(css ="#contact-form #religion") WebElement religion;

    // MultiDropdown
    @FindBy(css ="#contact-form #weather .caret") WebElement weatherExpand;
    @FindBy(css ="#contact-form #weather label") List<WebElement> weatherList;
    @FindBy(css ="#contact-form #weather button") WebElement weatherValue;
    @FindBy(css ="#contact-form #weather ul") WebElement weatherIsExpanded;
    private boolean weatherIsExpanded() {
        return weatherIsExpanded.getAttribute("style").equals("display: block;");
    }

    @FindBy(css ="#contact-form #accept-conditions") WebElement acceptConditions;
    @FindBy(css ="#contact-form #description") WebElement description;

    @FindBy(css ="#contact-form [type=submit]") WebElement submit;

    public void submit(ContactInfo contact) {
        // TextFields
        if (contact.name != null) {
            name.clear();
            name.sendKeys(contact.name);
        }
        if (contact.lastName != null) {
            lastName.clear();
            lastName.sendKeys(contact.lastName);
        }
        if (contact.position != null) {
            position.clear();
            position.sendKeys(contact.position);
        }
        if (contact.passportNumber != -1) {
            passportNumber.clear();
            passportNumber.sendKeys(valueOf(contact.passportNumber));
        }
        if (contact.passportSeria != -1) {
            passportSeria.clear();
            passportSeria.sendKeys(valueOf(contact.passportSeria));
        }
        // Dropdown
        if (contact.gender != null) {
            gender().selectByVisibleText(contact.gender);
        }
        // Combobox
        if (contact.religion != null) {
            religion.clear();
            religion.sendKeys(contact.religion);
        }
        // MultiDropdown
        if (contact.weather != null) {
            if (!weatherIsExpanded())
                weatherExpand.click();
            String[] values = contact.weather.split(", ");
            for (String value : values) {
                int size = weatherList.size();
                for (int i = 0; i < size; i++) {
                    WebElement listOption = weatherList.get(i);
                    if (listOption.getText().trim().equals(value))
                        listOption.click();
                }
            }
        }
        // Checkboxes
        if (contact.passport && !passport.isSelected() ||
            !contact.passport && passport.isSelected())
                passport.click();
        if (contact.acceptConditions && !acceptConditions.isSelected() ||
            !contact.acceptConditions && acceptConditions.isSelected())
                acceptConditions.click();
        // TextArea
        if (contact.description != null) {
            description.clear();
            description.sendKeys(contact.description);
        }
        submit.click();
    }
    
    public void check(ContactInfo contact) {
        // TextFields
        if (contact.name != null)
            assertEquals(name.getAttribute("value"), contact.name);
        if (contact.lastName != null)
            assertEquals(lastName.getAttribute("value"), contact.lastName);
        if (contact.position != null)
            assertEquals(position.getAttribute("value"), contact.position);
        if (contact.passportNumber != -1)
            assertEquals(passportNumber.getAttribute("value"), valueOf(contact.passportNumber));
        if (contact.passportSeria != -1)
            assertEquals(passportSeria.getAttribute("value"), valueOf(contact.passportSeria));
        // Dropdown
        if (contact.gender != null)
            assertEquals(gender().getFirstSelectedOption().getText(), contact.gender);
        // Combobox
        if (contact.religion != null)
            assertEquals(religion.getAttribute("value"), contact.religion);
        // MultiDropdown
        if (contact.weather != null)
            assertEquals(weatherValue.getText(), contact.weather);
        // Checkboxes
        assertEquals(passport.isSelected(), contact.passport);
        assertEquals(acceptConditions.isSelected(), contact.acceptConditions);
        // TextArea
        if (contact.description != null)
            assertEquals(description.getAttribute("value"), contact.description);
    }

}
