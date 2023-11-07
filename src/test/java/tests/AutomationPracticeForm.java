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
                .setDateOfBirth("3", "June", "1997");

        $("#subjectsInput").val("Computer Science").pressEnter();
        $ ("#hobbiesWrapper").$(byText("Sports")).click();
        $ ("#hobbiesWrapper").$(byText("Reading")).click();
        $ ("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("QA.jpeg");
        $("#currentAddress").setValue("Penza, Central street 132");
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#react-select-4-input").val("Noida").pressEnter();
        $("#submit").pressEnter();

        $(".table-responsive").shouldHave(text("Ksenia Mitrofanova"));
        $(".table-responsive").shouldHave(text("KMitrofanova@mail.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8999123456"));
        $(".table-responsive").shouldHave(text("3 June,1997"));
        $(".table-responsive").shouldHave(text("Computer Science"));
        $(".table-responsive").shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").shouldHave(text("QA.jpeg"));
        $(".table-responsive").shouldHave(text("Penza, Central street 132"));
        $(".table-responsive").shouldHave(text("NCR Noida"));
    }

    @Test
    void inputMinimalData()
    {
        studentRegistrationForm.openPage()
                .setFirstName("Ksenia")
                .setLastName("Mitrofanova")
                .setGenter("Female")
                .setUserNumber("8999123456");
        $("#submit").pressEnter();

        $(".table-responsive").shouldHave(text("Ksenia Mitrofanova"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8999123456"));
    }

 /*   @Test
    void negativeScenario()
    {

    }*/
}
