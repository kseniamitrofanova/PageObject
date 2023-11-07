package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StudentRegistrationForm {
    public static SelenideElement firstNameInput =$("#firstName");
    public static SelenideElement lastNameInput =$("#lastName");
    public static SelenideElement userEmailInput =$("#userEmail");
    public static SelenideElement userNumberInput =$("#userNumber");



    public void openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove");
    }

    public void setFirstName(String value) { firstNameInput.setValue(value);}
    public void setLastName(String value)
    {
        lastNameInput.setValue(value);
    }
    public void setUserEmail(String value){userEmailInput.setValue(value);}
    public void setUserNumber(String value){userNumberInput.setValue(value);}

}
