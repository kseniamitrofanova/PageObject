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
                .setUserNumber(userNumber)
                .setGender(gender)
                .setDateOfBirth(strDayOfBirth, monthOfBirth, strYearOfBirth)
                .setHobbies(hobbies)
                .setSubjectsInput(subjectsInput)
                .setPicture()
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickEnter();

        studentRegistrationPage.checkResult("Student Name", firstName + "\n" + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", strDayOfBirth + "\n" +
                        monthOfBirth + "," +
                        strYearOfBirth)
                .checkResult("Subjects", subjectsInput)
                .checkResult("Hobbies",hobbies)
                .checkResult("Picture",nameForPicture)
                .checkResult("Address",currentAddress)
                .checkResult("State and City",state + "\n" + city);
    }

    @Test
    void inputMinimalData()
    {
        studentRegistrationPage.openPage()
                .removePage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .clickEnter();

        studentRegistrationPage.checkResult("Student Name", firstName + "\n" + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);

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
