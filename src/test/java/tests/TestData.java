package tests;

import com.github.javafaker.Faker;

import static utils.RandomUtils.*;

public class TestData {
    Faker faker = new Faker();
    public String firstName=faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String currentAddress = faker.address().streetAddress();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String gender = getRandomGender();
    public int dayOfBirth=getRandomInt(1,30);
    public String strDayOfBirth=Integer.toString(dayOfBirth);
    public String monthOfBirth = getRandomMonth();
    public int yearOfBirth=getRandomInt(1920,2023);
    public String strYearOfBirth= Integer.toString(yearOfBirth);
    public String hobbies=getHobbies();
    public String subjectsInput=getRandomSubjects();
    public String state=getRandomState();
    public String city=getRandomCity(state);
    public String nameForPicture="QA.jpeg";
}
