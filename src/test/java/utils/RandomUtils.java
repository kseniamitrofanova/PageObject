package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String getRandomString(int len){
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public static String getRandomMonth() {
        String[] genders = {"January", "February", "March", "April","May", "June", "July", "August", "September", "October", "November", "December"};

        return getRandomItemFromArray(genders);
    }

    public static String getHobbies() {
        String[] hobbies =  {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomSubjects() {
        String[] genders = {"Maths", "Accounting", "Arts", "Social Studies","Biology", "Physics", "Chemistry",
                "Computer Science", "Economics", "Civics", "Hindi", "English","History"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return getRandomItemFromArray(states);
    }
    public static String getRandomCity(String city) {
        String[] cityForNCR = {"Delhi", "Gurgaon", "Noida"};
        String[] cityForUttarPradesh = {"Agra", "Lucknow", "Merrut"};
        String[] cityForUttarHaryana = {"Karnal", "Panipat"};
        String[] cityForUttarRajasthan = {"Jaipur", "Jaiselmer"};

        String res;

        if (city=="NCR")
            return getRandomItemFromArray(cityForNCR);
        else
            if (city=="Uttar Pradesh")
                return getRandomItemFromArray(cityForUttarPradesh);
        else
            if (city=="Haryana")
                return getRandomItemFromArray(cityForUttarHaryana);
            else
                return getRandomItemFromArray(cityForUttarRajasthan);
    }

}
