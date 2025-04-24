package Work12;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class Input {
    @Getter
    SelenideElement element;
    String description;
    int waitSecond = 5;
    public Input(SelenideElement element, String description) {
        this.element=element;
        this.description=description;
    }

@Step("Проверяем видимости поле ввода")
public Input visibilityInput() {
    element.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond));
    return this;
}
    @Step("Очистка поле ввода")
    public Input clearInput() {
        element.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond)).clear();
        return this;
    }

    @Step("Установить значения в поле ввода")
    public Input setValues(String text) {
        element.shouldBe(Condition.enabled, Duration.ofSeconds(waitSecond))
                .setValue(text);
        return this;
    }

}
