package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class StateCity {

    private final SelenideElement stateNcr = $(byId("react-select-3-option-0"));
    private final SelenideElement stateUttarPradesh = $(byId("react-select-3-option-1"));
    private final SelenideElement stateHaryana = $(byId("react-select-3-option-2"));
    private final SelenideElement cityAgra = $(byId("react-select-4-option-0"));
    private final SelenideElement cityLucknow = $(byId("react-select-4-option-1"));
    private final SelenideElement cityMerrut = $(byId("react-select-4-option-2"));


    @Getter
    SelenideElement element;
    String description;
    int waitSecond = 5;
    public StateCity(SelenideElement element, String description) {
        this.element=element;
        this.description=description;
    }
    @Step("Нажать на выпадающий список Штата")
    public StateCity clickButtonState() {
        element.scrollIntoView(true);
        element.shouldBe(Condition.exist, Duration.ofSeconds(waitSecond))
                .click();
        return this;
    }
    @Step("Нажать на выпадающий список Города")
    public StateCity clickButtonCity() {
        element.scrollIntoView(true);
        element.shouldBe(Condition.exist, Duration.ofSeconds(waitSecond))
                .click();
        return this;
    }
    @Step("Выбрать Штат")
    public StateCity selectState() {
        stateNcr.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond))
                .click();
        return this;
    }
    @Step("Выбрать Город")
    public StateCity selectCity() {
        cityAgra.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond))
                .click();
        return this;
    }

}
