package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

public class AutomationPracticeFormWithFakerTests extends TestBase{

    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();
    TestData testData = new TestData();

    @Test
    void fillFormTest() {

        studentRegistrationPage.openPage()
                .removePage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setUserNumber(testData.userNumber)
                .setGender(testData.gender)
                .setDateOfBirth(testData.strDayOfBirth, testData.monthOfBirth, testData.strYearOfBirth)
                .setHobbies(testData.hobbies)
                .setSubjectsInput(testData.subjectsInput)
                .setPicture()
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .clickEnter();

        studentRegistrationPage.checkResult("Student Name", testData.firstName + "\n" + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.strDayOfBirth + "\n" +
                        testData.monthOfBirth + "," +
                        testData.strYearOfBirth)
                .checkResult("Subjects", testData.subjectsInput)
                .checkResult("Hobbies",testData.hobbies)
                .checkResult("Picture",testData.nameForPicture)
                .checkResult("Address",testData.currentAddress)
                .checkResult("State and City",testData.state + "\n" + testData.city);
    }

    @Test
    void inputMinimalData()
    {
        studentRegistrationPage.openPage()
                .removePage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .clickEnter();

        studentRegistrationPage.checkResult("Student Name", testData.firstName + "\n" + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber);

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
