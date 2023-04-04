package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import static components.TestData.*;

public class RandomUtils {

    static Faker faker = new Faker(new Locale("en"));

    public static String getRandomFirstName() {
        return new Faker().name().firstName();
    }
    public static String getRandomLastName() {
        return new Faker().name().lastName();
    }
    public static String getRandomEmail() {
        return new Faker().internet().emailAddress();
    }
    public static String getRandomPhone() {
        return new Faker().phoneNumber().subscriberNumber(10);
    }
    public static String getRandomGender() {
        return new Faker().options().option("Male", "Female", "Other");
    }
    static Date fakerDate = faker.date().birthday();
    static SimpleDateFormat sdfDay = new SimpleDateFormat("dd", Locale.ENGLISH);
    static SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM", Locale.ENGLISH);
    static SimpleDateFormat sdfYear = new SimpleDateFormat("y", Locale.ENGLISH);

    public static String getRandomDay() {
        return sdfDay.format(fakerDate);
    }

    public static String getRandomMonth() {
        return sdfMonth.format(fakerDate);
    }

    public static String getRandomYear() {
        return sdfYear.format(fakerDate);
    }

    public static String getRandomSubject() {
        return new Faker().options().option("English", "Maths", "Biology");
    }

    public static String getRandomHobbies() {
        return new Faker().options().option("Sports", "Reading", "Music");
    }

    public static String getRandomAddress() {
        return new Faker().address().fullAddress();
    }

    static Map<String, String[]> getRandomStateAndCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );

    public static String getRandomState() {
        return new Faker().options().option(getRandomStateAndCity.keySet().toArray()).toString();
    }

    public static String getRandomCity() {
        return new Faker().options().option(getRandomStateAndCity.get(state));
    }



}
