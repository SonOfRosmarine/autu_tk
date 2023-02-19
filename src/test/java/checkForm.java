import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class checkForm {

    @BeforeAll
    static void beforAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }

@Test

    void succedfulTest(){

    open("/automation-practice-form");
    $("[id = firstName]").setValue("Eugen");
    $("[id = lastName]").setValue("Chazam");
    $("[id = userEmail]").setValue("Eugen@Chazam.com");
    $(By.cssSelector("label[for='gender-radio-1']")).click();
    $("[id = userNumber]").setValue("7111111111");
    $("[id = dateOfBirthInput]").click();
    $(".react-datepicker__month-dropdown-container").$(byText("January")).click();
    $(".react-datepicker__year-dropdown-container").$(byText("1990")).click ();
    $(".react-datepicker__month-container").$(byText("18")).click();
    $("[id = subjectsInput]").setValue("E").pressEnter();
    $(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
    //$("#uploadPicture").uploadFromClasspath("C:/Users/roman/Desktop/picture/5.jpg");
    File fileToUpload = new File ("C:/Users/roman/Desktop/picture/5.jpg");
    $("#uploadPicture").uploadFile(fileToUpload);
    $("[id = currentAddress]").setValue("Mosscowww");
    $("[id = state]").click();
    $("[id = stateCity-wrapper]").$(byText("Haryana")).click();
    $("[id = city]").click();
    $("[id = stateCity-wrapper]").$(byText("Karnal")).click();
    $("[id = submit]").click();

    $(".modal-open").shouldHave(text("Thanks for submitting the form"));
    $(".modal-body").shouldHave(text("Eugen Chazam"));
    $(".modal-body").shouldHave(text("Eugen@Chazam.com"));
    $(".modal-body").shouldHave(text("Male"));
    $(".modal-body").shouldHave(text("7111111111"));
    $(".modal-body").shouldHave(text("18 January,1990"));
    $(".modal-body").shouldHave(text("E"));
    $(".modal-body").shouldHave(text("Sport"));
    $(".modal-body").shouldHave(text("Mosscowww"));
    $(".modal-body").shouldHave(text("Haryana"));
    $("#closeLargeModal").click();
}

}
