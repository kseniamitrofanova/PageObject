package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StudentRegistrationPage {
    private SelenideElement firstNameInput =$("#firstName"),
            lastNameInput =$("#lastName"),
            userEmailInput =$("#userEmail"),
            userNumberInput =$("#userNumber"),
            genterWrapperInput = $("#genterWrapper"),
            calendarInput = $("#dateOfBirthInput"),
            buttonSubmit= $("#submit"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            subjectsInput= $("#subjectsInput"),
            loadPicture=$("#uploadPicture"),
            CurrentAddressInput=$("#currentAddress"),
            setreact3=$("#react-select-3-input"),
            setreact4=$("#react-select-4-input");





    CalendarComponent calendarComponent = new CalendarComponent();


    public StudentRegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove");
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
    public StudentRegistrationPage setGenter(String value){
        genterWrapperInput.$(byText(value)).click();
        return this;
    }
    public StudentRegistrationPage setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public StudentRegistrationPage checkResult (String key, String value){
        $(".table-responsive").$(byText(key)).parent()
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
        CurrentAddressInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setReact3(String value) {
        setreact3.val(value).pressEnter();
        return this;
    }

    public StudentRegistrationPage setReact4(String value) {
        setreact4.val(value).pressEnter();
        return this;
    }

    public StudentRegistrationPage checkResult() {
        $("#userForm.was-validated").shouldBe(visible);
        return this;
    }

}
