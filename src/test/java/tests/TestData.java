package tests;

import com.github.javafaker.Faker;
import static utils.RandomUtils.*;
import static utils.RandomUtils.getRandomCity;

public class TestData {
    static Faker faker = new Faker();
    public static String firstName=faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String userEmail = faker.internet().emailAddress();
    public static String currentAddress = faker.address().streetAddress();
    public static String userNumber = faker.phoneNumber().subscriberNumber(10);
    public static String gender = getRandomGender();
    public static int dayOfBirth=getRandomInt(1,30);
    public static String strDayOfBirth=Integer.toString(dayOfBirth);
    public static String monthOfBirth = getRandomMonth();
    public static int yearOfBirth=getRandomInt(1920,2023);
    public static String strYearOfBirth= Integer.toString(yearOfBirth);
    public static String hobbies=getHobbies();
    public static String subjectsInput=getRandomSubjects();
    public static String state=getRandomState();
    public static String city=getRandomCity(state);
    public static String nameForPicture="QA.jpeg";
}
