package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.junit.Assert;

import java.time.Duration;

public class RadioButton {
    @Getter
    SelenideElement element;
    String expectedRedColor = "rgb(220, 53, 69)";
    String expectedGreenColor = "rgb(40, 167, 69)";
    String description;
    int waitSecond = 5;
    public RadioButton(SelenideElement element, String description) {
        this.element=element;
        this.description=description;
    }
    @Step("Проверить видимость  радио кнопки")
    public RadioButton checkRadioButtonVisibility() {
        element.scrollIntoView(true);
        element.shouldBe(Condition.visible,Duration.ofSeconds(waitSecond));
        return this;
    }
    @Step("Выбрать радио кнопку")
    public RadioButton selectRadioButton() {
        element.scrollIntoView(true);
        element.shouldBe(Condition.exist, Duration.ofSeconds(waitSecond))
                .click();
        return this;
    }
    @Step("Проверка валидации поле Gender")
    public RadioButton checkRedColor() {
        element.shouldBe(Condition.cssValue("border-color", "rgb(220, 53, 69)"), Duration.ofSeconds(waitSecond));
        String actualColor = element.getCssValue("border-color");
        Assert.assertEquals(expectedRedColor, actualColor);
        return this;
    }
    @Step("Проверка валидации поле Даты рождения")
    public RadioButton checkGreenColor() {
        element.shouldBe(Condition.cssValue("border-color", "rgb(40, 167, 69)"), Duration.ofSeconds(waitSecond));
        String actualColor = element.getCssValue("border-color");
        Assert.assertEquals(expectedGreenColor, actualColor);
        return this;
    }

}
