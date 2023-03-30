package components;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponents {
    public void setDate(String day, String month, String year){
        $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
        $("#dateOfBirthInput").sendKeys(day + " " + month + " " + year);
        $("#dateOfBirthInput").pressEnter();
    }
}
