package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.junit.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Hobbies {
    private final SelenideElement checkHobbies = $x("//input[@id='hobbies-checkbox-1']");

    @Getter
    SelenideElement element;
    String expectedGreenColor = "rgb(40, 167, 69)";

    String description;
    int waitSecond = 10;

    public Hobbies(SelenideElement element, String description) {
        this.element = element;
        this.description = description;
    }
    @Step("Выбрать кнопку чекбокс ")
    public Hobbies selectRadioButton() {
        element.scrollIntoView(true);
        element.shouldBe(Condition.exist, Duration.ofSeconds(waitSecond))
                .click();
        return this;
    }


    @Step("Проверить, что чекбокс выбран")
    public Hobbies checkIsSelected() {
        checkHobbies.shouldBe(Condition.selected);
        return this;
    }
    @Step("Проверка валидации поле Gender")
    public Hobbies checkGreenColor() {
        element.shouldBe(Condition.cssValue("border-color", "rgb(40, 167, 69)"), Duration.ofSeconds(waitSecond));
        String actualColor = element.getCssValue("border-color");
        Assert.assertEquals(expectedGreenColor, actualColor);
        return this;
    }
}
