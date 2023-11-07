package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationForm;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm extends TestBase{

    StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();

    @Test

    void fillFormTest() {
        studentRegistrationForm.openPage()
                .setFirstName("Ksenia")
                .setLastName("Mitrofanova")
                .setUserEmail("KMitrofanova@mail.ru")
                .setUserNumber("8999123456")
                .setGenter("Female")
                .setDateOfBirth("30", "July", "2008")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setHobbies("Music")
                .setSubjectsInput("Computer Science")
                .setPicture()
                .setCurrentAddress("Penza, Central street 132")
                .setReact3("NCR")
                .setReact4("Noida")
                .clickEnter();


        studentRegistrationForm.checkResult("Student Name", "Ksenia Mitrofanova")
                .checkResult("Student Email", "KMitrofanova@mail.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8999123456")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "Computer Science")
                .checkResult("Hobbies","Sports, Reading, Music")
                .checkResult("Picture","QA.jpeg")
                .checkResult("Address","Penza, Central street 132")
                .checkResult("State and City","NCR Noida");
    }

    @Test
    void inputMinimalData()
    {
        studentRegistrationForm.openPage()
                .setFirstName("Ksenia")
                .setLastName("Mitrofanova")
                .setGenter("Female")
                .setUserNumber("8999123456")
                .clickEnter();

        studentRegistrationForm.checkResult("Student Name", "Ksenia Mitrofanova")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8999123456");

    }

    @Test
    void negativeScenario()
    {
        studentRegistrationForm.openPage()
                .clickEnter();

        $("firstName").shouldHave(cssClass("error"));
    }
}
