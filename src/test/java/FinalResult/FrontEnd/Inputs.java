package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;

public class Inputs {

    @Getter
    SelenideElement element;
    String description;
    String expectedRedColor = "rgb(220, 53, 69)";
    String expectedGreenColor = "rgb(40, 167, 69)";
    private final String EXPECTED_SVG_IMAGE = "data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e";

    int waitSecond = 5;

    public Inputs(SelenideElement element, String description) {
        this.element = element;
        this.description = description;
    }

    @Step("Проверяем видимости поле ввода")
    public Inputs visibilityInput() {
        element.scrollIntoView(true);
        element.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond));
        return this;
    }

    @Step("Очистка поле ввода")
    public Inputs clearInput() {
        element.scrollIntoView(true);
        element.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond)).clear();
        return this;
    }

    @Step("Установить значения в поле ввода")
    public Inputs setValues(String text) {
        element.scrollIntoView(true);
        element.shouldBe(Condition.enabled, Duration.ofSeconds(waitSecond))
                .setValue(text);
        return this;
    }

    @Step("Проверка валидации поля ")
    public Inputs checkRedColor() {
        element.shouldBe(Condition.cssValue("border-color", "rgb(220, 53, 69)"), Duration.ofSeconds(waitSecond));
        String actualColor = element.getCssValue("border-color");
        Assert.assertEquals(expectedRedColor, actualColor);
        return this;
    }

    @Step("Проверка валидации поля ")
    public Inputs checkGreenColor() {
        element.shouldBe(Condition.cssValue("border-color", "rgb(40, 167, 69)"), Duration.ofSeconds(waitSecond));
        String actualColor = element.getCssValue("border-color");
        Assert.assertEquals(expectedGreenColor, actualColor);
        return this;
    }

    @Step("Проверить красный крестик в поле ввода")
    public void testRedImageInField() {
        element.shouldBe(Condition.cssValue("background-image",
                        "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")"),
                Duration.ofSeconds(waitSecond));
    }
    @Step("Проверить зеленую галочку в поле ввода")
    public void testGreenImageInField() {
        element.shouldBe(Condition.cssValue("background-image",
                        "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8' viewBox='0 0 8 8'%3e%3cpath fill='%2328a745' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e\")"),
                Duration.ofSeconds(waitSecond));
    }

}
