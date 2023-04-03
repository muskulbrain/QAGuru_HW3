package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static components.TestData.*;
import java.io.File;

public class RegistrationWithFakerTests extends TestBase {
    private final File file = new File("src/test/resources/img/1.png");
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void registrationTest() {

        registrationPage.openPage()
                .closeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(mobile)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setUploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", mobile)
                .verifyResults("Date of Birth", dayOfBirthDate + " " +
                        monthOfBirthDate + "," + yearOfBirthDate)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobbies)
                .verifyResults("Picture", picture)
                .verifyResults("Address", address)
                .verifyResults("State and City", state + " " + city);

    }
}
