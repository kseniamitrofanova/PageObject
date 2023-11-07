package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StudentRegistrationForm {
    private SelenideElement firstNameInput =$("#firstName"),
            lastNameInput =$("#lastName"),
            userEmailInput =$("#userEmail"),
            userNumberInput =$("#userNumber"),
            genterWrapperInput = $("#genterWrapper"),
            calendarInput = $("#dateOfBirthInput");

    CalendarComponent calendarComponent = new CalendarComponent();


    public StudentRegistrationForm openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove");
        return this;
    }
    public StudentRegistrationForm setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;}
    public StudentRegistrationForm setLastName(String value)
    {
        lastNameInput.setValue(value);
        return this;

    }
    public StudentRegistrationForm setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public StudentRegistrationForm setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }
    public StudentRegistrationForm setGenter(String value){
        genterWrapperInput.$(byText("Female")).click();
        return this;
    }
    public StudentRegistrationForm setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

}
