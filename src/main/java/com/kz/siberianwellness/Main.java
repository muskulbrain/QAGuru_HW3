package com.kz.siberianwellness;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.openqa.selenium.*;

import java.io.*;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Main {

@BeforeAll
public static void beforeAllMethod() {
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
}

    @Test
    void fillForm() {
        open("/automation-practice-form");

        $("[id=\"firstName\"]").setValue("Test1");

        $("[id=\"lastName\"]").setValue("Test2");

        $("[id=\"userEmail\"]").setValue("Test@mail.com");

        $("[id=\"gender-radio-3\"]").parent().click();

        $("[id=\"userNumber\"]").setValue("7955511448");

        Main.fillData();

        $("[id=\"subjectsInput\"]").setValue("Arts").pressEnter();

        $("[id=\"hobbies-checkbox-3\"]").parent().click();

        $("#uploadPicture")
                .uploadFile(new File("src/main/resources/img/1.png"));

        $("#currentAddress").setValue("Far far away");

        fillStateAndCity();

        $("#submit").click();

        checkTable();
    }

    private static void checkTable() {
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $("table").shouldHave(
                text("Test1"),
                text("Test2"),
                text("Test@mail.com"),
                text("Other"),
                text("7955511448"),
                text("17 May,1993"),
                text("Arts"),
                text("Music"),
                text("Far far away"),
                text("Haryana Karnal"));
    }

    private static void fillStateAndCity() {
        $("[id=\"state\"]").click();
        $("[id=\"react-select-3-option-2\"]").click();

        $("[id=\"city\"]").click();
        $("[id=\"react-select-4-option-0\"]").click();
    }


    public static void fillData() {
        $("[id=\"dateOfBirthInput\"]").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOptionByValue("1993");
        $(".react-datepicker__day--017:not(.react-datepicker__day--outside-month)").click();
    }


}
