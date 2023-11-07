package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import static com.codeborne.selenide.Condition.text;



import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StudentRegistrationForm {
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


    public StudentRegistrationForm openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove");
        return this;
    }
    public StudentRegistrationForm setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
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
        genterWrapperInput.$(byText(value)).click();
        return this;
    }
    public StudentRegistrationForm setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public  StudentRegistrationForm checkResult (String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

    public  StudentRegistrationForm clickEnter (){
        buttonSubmit.click();
        return this;
    }

    public StudentRegistrationForm setHobbies(String value){
        hobbiesWrapperInput.$(byText(value)).click();
        return this;
    }

    public StudentRegistrationForm setSubjectsInput(String value) {
        subjectsInput.val(value).pressEnter();
        return this;
    }

    public StudentRegistrationForm setPicture() {
        loadPicture.uploadFromClasspath("QA.jpeg");
        return this;
    }

    public StudentRegistrationForm setCurrentAddress(String value) {
        CurrentAddressInput.setValue(value);
        return this;
    }

    public StudentRegistrationForm setReact3(String value) {
        setreact3.val(value).pressEnter();
        return this;
    }

    public StudentRegistrationForm setReact4(String value) {
        setreact4.val(value).pressEnter();
        return this;
    }

}
