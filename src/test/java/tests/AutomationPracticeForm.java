package tests;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;


@Tag("examples")
public class AutomationPracticeForm extends TestBase{
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    @Test
    @Tag("demoqa")
    void fillFormTest() {
        step("Form fill",()-> {
                    studentRegistrationPage.openPage()
                            .removePage()
                            .setFirstName("Ksenia")
                            .setLastName("Mitrofanova")
                            .setUserEmail("KMitrofanova@mail.ru")
                            .setUserNumber("8999123456")
                            .setGender("Female")
                            .setDateOfBirth("30", "July", "2008")
                            .setHobbies("Sports")
                            .setHobbies("Reading")
                            .setHobbies("Music")
                            .setSubjectsInput("Computer Science")
                            .setPicture()
                            .setCurrentAddress("Penza, Central street 132")
                            .setState("NCR")
                            .setCity("Noida")
                            .clickEnter();
                });

        step("Check result",()-> {
            studentRegistrationPage.checkResult("Student Name", "Ksenia Mitrofanova")
                    .checkResult("Student Email", "KMitrofanova@mail.ru")
                    .checkResult("Gender", "Female")
                    .checkResult("Mobile", "8999123456")
                    .checkResult("Date of Birth", "30 July,2008")
                    .checkResult("Subjects", "Computer Science")
                    .checkResult("Hobbies", "Sports, Reading, Music")
                    .checkResult("Picture", "QA.jpeg")
                    .checkResult("Address", "Penza, Central street 132")
                    .checkResult("State and City", "NCR Noida");
        });

    }

    @Test
    void inputMinimalData()
    {
        step("Open page",()-> {
                    studentRegistrationPage.openPage()
                            .removePage()
                            .setFirstName("Ksenia")
                            .setLastName("Mitrofanova")
                            .setGender("Female")
                            .setUserNumber("8999123456")
                            .clickEnter();
                });

        step("Check result",()-> {
            studentRegistrationPage.checkResult("Student Name", "Ksenia Mitrofanova")
                    .checkResult("Gender", "Female")
                    .checkResult("Mobile", "8999123456");
        });

    }

    @Test
    void negativeScenario()
    {
        step("Open page",()-> {
            studentRegistrationPage.openPage()
                    .removePage()
                    .clickEnter()
                    .checkResult();
        });

    }
}
