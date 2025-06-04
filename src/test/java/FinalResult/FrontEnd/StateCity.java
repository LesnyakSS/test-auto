package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import java.time.Duration;


public class StateCity {
    @Getter
    SelenideElement element;
    String description;
    int waitSecond = 15;
    public StateCity(SelenideElement element, String description) {
        this.element=element;
        this.description=description;
    }

    public StateCity clickButtonState() {
        element.shouldBe(Condition.exist, Duration.ofSeconds(waitSecond))
                .click();
        return this;
    }

    public StateCity clickButtonCity() {
        element.shouldBe(Condition.exist, Duration.ofSeconds(waitSecond))
                .click();
        return this;
    }

    public StateCity selectState(SelenideElement stateNcr) {
        stateNcr.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond))
                .click();
        return this;
    }

    public StateCity selectCity(SelenideElement cityAgra) {
        cityAgra.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond))
                .click();
        return this;
    }

}
