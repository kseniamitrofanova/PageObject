package tests;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

public class AutomationPracticeForm extends TestBase{

    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    @Test
    void fillFormTest() {
        studentRegistrationPage.openPage()
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


        studentRegistrationPage.checkResult("Student Name", "Ksenia Mitrofanova")
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
        studentRegistrationPage.openPage()
                .removePage()
                .setFirstName("Ksenia")
                .setLastName("Mitrofanova")
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
