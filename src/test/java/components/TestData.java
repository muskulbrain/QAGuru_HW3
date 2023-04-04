package components;

import java.io.File;

import static utils.RandomUtils.*;
import static utils.RandomUtils.getRandomYear;

public class TestData {
    public final File file = new File("src/test/resources/img/1.png");
    public static String firstName = getRandomFirstName();
    public static String lastName = getRandomLastName();
    public static String email = getRandomEmail();
    public static String gender = getRandomGender();
    public static String mobile = getRandomPhone();
    public static String dayOfBirthDate = getRandomDay();
    public static String monthOfBirthDate = getRandomMonth();
    public static String yearOfBirthDate = getRandomYear();
    public static String subject = getRandomSubject();
    public static String hobbies = getRandomHobbies();
    public static String picture = "1.png";
    public static String address = getRandomAddress();
    public static String state = getRandomState();
    public static String city = getRandomCity();

}

