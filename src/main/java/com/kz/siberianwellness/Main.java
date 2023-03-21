package com.kz.siberianwellness;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.io.*;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Main {
    @Test

    void fillForm() {
        open("https://demoqa.com/automation-practice-form");

        $("[id=\"firstName\"]").setValue("Test1");
        $("[id=\"lastName\"]").setValue("Test2");
        $("[id=\"userEmail\"]").setValue("Test@mail.com");
        //$("[id=\"gender-radio-3\"]").click();
        $("[id=\"userNumber\"]").setValue("+795551144");
        $("[id=\"hobbies-checkbox-3\"]").click();

    }



}
