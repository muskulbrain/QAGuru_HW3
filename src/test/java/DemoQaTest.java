import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQaTest {

        @BeforeAll
    public static void beforeAllMethod() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillForm() {
        open("/automation-practice-form");

        closedBanners();

        $("[id=\"firstName\"]").setValue("Test1");

        $("[id=\"lastName\"]").setValue("Test2");

        $("[id=\"userEmail\"]").setValue("Test@mail.com");

        $("[id=\"gender-radio-3\"]").parent().click();

        $("[id=\"userNumber\"]").setValue("7955511448");

        fillData();

        $("[id=\"subjectsInput\"]").setValue("Arts").pressEnter();

        $("[id=\"hobbies-checkbox-3\"]").parent().click();

        $("#uploadPicture")
                .uploadFile(new File("src/test/resources/img/1.png"));

        $("#currentAddress").setValue("Far far away");

        fillStateAndCity();

        $("#submit").click();

        checkTable();
    }

    private void closedBanners() {
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
    }

    private void checkTable() {
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $("table").shouldHave(text("Test1"));
        $("table").shouldHave(text("Test2"));
        $("table").shouldHave(text("Test@mail.com"));
        $("table").shouldHave(text("Other"));
        $("table").shouldHave(text("7955511448"));
        $("table").shouldHave(text("17 May,1993"));
        $("table").shouldHave(text("Arts"));
        $("table").shouldHave(text("Music"));
        $("table").shouldHave(text("Far far away"));
        $("table").shouldHave(text("Haryana Karnal"));
    }

    private void fillStateAndCity() {
        $("[id=\"state\"]").click();
        $("[id=\"react-select-3-option-2\"]").click();

        $("[id=\"city\"]").click();
        $("[id=\"react-select-4-option-0\"]").click();
    }

    public void fillData() {
        $("[id=\"dateOfBirthInput\"]").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOptionByValue("1993");
        $(".react-datepicker__day--017:not(.react-datepicker__day--outside-month)").click();
    }

}
