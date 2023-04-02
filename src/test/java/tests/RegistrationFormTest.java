package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

public class RegistrationFormTest extends TestBase {
    private final File file = new File("src/test/resources/img/1.png");
    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void registrationTest() {

        registrationPage.openPage()
                .killBanner()
                .setFirstName("Test1")
                .setLastName("Test2")
                .setEmail("Test@mail.com")
                .setGender("Male")
                .setPhone("7955511448")
                .setBirthDate("17", "May", "1993")
                .setSubjects("Arts")
                .setHobbies("Sports")
                .uploadPicture(file)
                .setAddress("Far far away")
                .setState("Haryana")
                .setCity("Panipat")
                .clickSubmit();

    registrationPage
        .verifyResult("Student Name","Test1 Test2")
        .verifyResult("Student Email","Test@mail.com")
        .verifyResult("Gender","Male")
        .verifyResult("Mobile","7955511448")
        .verifyResult("Date of Birth","17 May,1993")
        .verifyResult("Subjects","Arts")
        .verifyResult("Hobbies","Sports")
        .verifyResult("Picture","1.png")
        .verifyResult("Address","Far far away")
        .verifyResult("State and City","Haryana Panipat");

}
}
