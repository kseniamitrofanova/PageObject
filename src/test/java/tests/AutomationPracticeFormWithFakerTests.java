package tests;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

import static tests.TestData.*;


public class AutomationPracticeFormWithFakerTests extends TestBase{

    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    @Test
    void fillFormTest() {
        studentRegistrationPage.openPage()
                .removePage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
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


        studentRegistrationPage.checkResult("Student Name", "Ksenia Mitrofanova")
                .checkResult("Student Email", userEmail)
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
        studentRegistrationPage.openPage()
                .removePage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender("Female")
                .setUserNumber("8999123456")
                .clickEnter();

        studentRegistrationPage.checkResult("Student Name", "Ksenia Mitrofanova")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8999123456");

    }

    @Test
    void negativeScenario()
    {
        studentRegistrationPage.openPage()
                .removePage()
                .clickEnter()
                .checkResult();

    }
}
