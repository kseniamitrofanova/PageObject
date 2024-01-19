package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationPage {
    private SelenideElement firstNameInput =$("#firstName"),
            lastNameInput =$("#lastName"),
            userEmailInput =$("#userEmail"),
            userNumberInput =$("#userNumber"),
            genderWrapperInput = $("#genterWrapper"),
            calendarInput = $("#dateOfBirthInput"),
            buttonSubmit= $("#submit"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            subjectsInput= $("#subjectsInput"),
            loadPicture=$("#uploadPicture"),
            currentAddressInput =$("#currentAddress"),
            setReact3 =$("#react-select-3-input"),
            setReact4 =$("#react-select-4-input"),
            userForm=$("#userForm.was-validated"),
            tableResponsive=$(".table-responsive");





    CalendarComponent calendarComponent = new CalendarComponent();

    public StudentRegistrationPage removePage() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove");
        return this;
    }


    public StudentRegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    public StudentRegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public StudentRegistrationPage setLastName(String value)
    {
        lastNameInput.setValue(value);
        return this;

    }
    public StudentRegistrationPage setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }
    public StudentRegistrationPage setGender(String value){
        genderWrapperInput.$(byText(value)).click();
        return this;
    }
    public StudentRegistrationPage setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public StudentRegistrationPage checkResult (String key, String value){
        tableResponsive.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

    public StudentRegistrationPage clickEnter (){
        buttonSubmit.click();
        return this;
    }

    public StudentRegistrationPage setHobbies(String value){
        hobbiesWrapperInput.$(byText(value)).click();
        return this;
    }

    public StudentRegistrationPage setSubjectsInput(String value) {
        subjectsInput.val(value).pressEnter();
        return this;
    }

    public StudentRegistrationPage setPicture() {
        loadPicture.uploadFromClasspath("QA.jpeg");
        return this;
    }

    public StudentRegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setState(String value) {
        setReact3.val(value).pressEnter();
        return this;
    }

    public StudentRegistrationPage setCity(String value) {
        setReact4.val(value).pressEnter();
        return this;
    }

    public StudentRegistrationPage checkResult() {
        userForm.shouldBe(visible);
        return this;
    }

}
