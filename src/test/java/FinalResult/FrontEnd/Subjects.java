package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class Subjects {
    private final SelenideElement subjectsMath = $(byId("react-select-2-option-0"));
    @Getter
    SelenideElement element;
    String description;
    int waitSecond = 5;

    public Subjects(SelenideElement element, String description) {
        this.element = element;
        this.description = description;
    }

    @Step("Установить значения в поле ввода")
    public Subjects setValues(String text) {
        element.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond))
                .setValue(text);
        return this;
    }
    @Step("Установить значения в поле ввода")
    public Subjects selectValues() {
        subjectsMath.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond)).click();
        return this;
    }
}
