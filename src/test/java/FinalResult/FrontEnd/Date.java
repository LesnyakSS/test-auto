package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.junit.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class Date {
    @Getter
    SelenideElement element;
    String description;
    int waitSecond = 15;

    public Date(SelenideElement element, String description) {
        this.element = element;
        this.description = description;
    }


    public void openCalendar(SelenideElement datePicker) {
        element.click();
        datePicker.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond));
    }


public Date selectDay(String xpath, int day) {
    $(byXpath(String.format(xpath, day)))
            .shouldBe(Condition.visible)
            .click();
    return this;
}

    public Date selectMonth(SelenideElement monthDropdown,String month) {
        monthDropdown.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond))
                .selectOption(month);
        return this;
    }

    public Date selectYear(SelenideElement yearDropdown,String year) {
        yearDropdown.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond))
                .selectOption(year);
        return this;
    }
    public Date checkGreenColor(String cssProperty,String expectedGreenColor) {
        element.shouldBe(Condition.cssValue(cssProperty, expectedGreenColor), Duration.ofSeconds(waitSecond));
        String actualColor = element.getCssValue(cssProperty);
        Assert.assertEquals(expectedGreenColor, actualColor);
        return this;
    }


}


