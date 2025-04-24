package Work13;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import java.time.Duration;

public class Logo {
    @Getter
    SelenideElement element;
    String description;
    int waitSecond = 5;
    public Logo(SelenideElement element, String description) {
        this.element=element;
        this.description=description;
    }
    @Step("Проверяем видимости логотипа")
    public Logo visibilityLogo() {
        element.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond));
        return this;
    }
}
