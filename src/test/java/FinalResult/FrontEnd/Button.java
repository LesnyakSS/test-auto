package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.time.Duration;

public class Button {
    @Getter
    SelenideElement element;
    String description;
    int waitSecond = 15;
    public Button(SelenideElement element, String description) {
        this.element=element;
        this.description=description;
    }

    public Button visibilityButton() {
        element.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond));
        return this;
    }
    public Button scrollElement() {
        element.scrollIntoView(true);
        return this;
    }

    public Button clickButton() {
        element.shouldBe(Condition.enabled, Duration.ofSeconds(waitSecond))
                .click();
        return this;
    }

}
