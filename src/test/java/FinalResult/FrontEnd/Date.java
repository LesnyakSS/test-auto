package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.junit.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Date {
    private final SelenideElement datePicker = $(byClassName("react-datepicker-popper"));
    private final SelenideElement monthDropdown = $x("//select[@class='react-datepicker__month-select']");
    private final SelenideElement yearDropdown = $x("//select[@class='react-datepicker__year-select']");
    String expectedGreenColor = "rgb(40, 167, 69)";

    @Getter
    SelenideElement element;
    String description;
    int waitSecond = 5;

    public Date(SelenideElement element, String description) {
        this.element = element;
        this.description = description;
    }

    @Step("Открыть календарь выбора даты")
    public void openCalendar() {
        element.click();
        datePicker.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond));
    }

    @Step("Выбрать дату рождения")
    public void selectDay(int day) {
        $(byXpath(String.format("//div[contains(@class, 'react-datepicker__day') and text()='%d']", day)))
                .shouldBe(Condition.visible)
                .click();}

    @Step("Выбрать месяц")
    public Date selectMonth(String month) {
        monthDropdown.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond))
                .selectOption(month);
        return this;
    }

    @Step("Выбрать год")
    public void selectYear(String year) {
        yearDropdown.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond))
                .selectOption(year);
    }
    @Step("Проверка валидации поле Даты рождения")
    public Date checkGreenColor() {
        element.shouldBe(Condition.cssValue("border-color", "rgb(40, 167, 69)"), Duration.ofSeconds(waitSecond));
        String actualColor = element.getCssValue("border-color");
        Assert.assertEquals(expectedGreenColor, actualColor);
        return this;
    }

    @Step("Проверить зеленую галочку в поле ввода")
    public void testGreenImageInField() {
        element.shouldBe(Condition.cssValue("background-image",
                        "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8' viewBox='0 0 8 8'%3e%3cpath fill='%2328a745' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e\")"),
                Duration.ofSeconds(waitSecond));
    }
}


