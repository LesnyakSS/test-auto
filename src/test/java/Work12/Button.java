package Work12;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class Button {
    @Getter
    SelenideElement element;
    String description;
    int waitSecond = 5;
    public Button(SelenideElement element, String description) {
        this.element=element;
        this.description=description;
    }

@Step("Проверяем видимости кнопки поиска")
public Button visibilityButton() {
    element.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond));
    return this;
}
    @Step("Нажать на кнопку поиска")
    public Button clickButton() {
       element.shouldBe(Condition.enabled, Duration.ofSeconds(waitSecond))
               .click();
        return this;
    }

}
