package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.junit.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Hobbies {
    @Getter
    SelenideElement element;
    String description;
    int waitSecond = 15;
    public Hobbies(SelenideElement element, String description) {
        this.element = element;
        this.description = description;
    }

    public Hobbies clickCheckbox() {
        element.shouldBe(Condition.exist, Duration.ofSeconds(waitSecond))
                .click();
        return this;
    }

    public Hobbies checkIsSelected(SelenideElement checkHobbies) {
        checkHobbies.shouldBe(Condition.selected);
        return this;
    }
    public Hobbies checkGreenColor(String cssProperty,String expectedGreenColor) {
        element.shouldBe(Condition.cssValue(cssProperty, expectedGreenColor), Duration.ofSeconds(waitSecond));
        String actualColor = element.getCssValue(cssProperty);
        Assert.assertEquals(expectedGreenColor, actualColor);
        return this;
    }
}
