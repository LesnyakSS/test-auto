package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.junit.Assert;

import java.time.Duration;

public class RadioButton {
    @Getter
    SelenideElement element;
    String description;
    int waitSecond = 15;
    public RadioButton(SelenideElement element, String description) {
        this.element=element;
        this.description=description;
    }

    public RadioButton checkRadioButtonVisibility() {
        element.shouldBe(Condition.visible,Duration.ofSeconds(waitSecond));
        return this;
    }

    public RadioButton selectRadioButton() {
        element.scrollIntoView(true);
        element.shouldBe(Condition.exist, Duration.ofSeconds(waitSecond))
                .click();
        return this;
    }
    public RadioButton checkRedColor(String cssProperty,String expectedRedColor) {
        element.shouldBe(Condition.cssValue(cssProperty, expectedRedColor), Duration.ofSeconds(waitSecond));
        String actualColor = element.getCssValue(cssProperty);
        Assert.assertEquals(expectedRedColor, actualColor);
        return this;
    }


    public RadioButton checkGreenColor(String cssProperty,String expectedGreenColor) {
        element.shouldBe(Condition.cssValue(cssProperty, expectedGreenColor), Duration.ofSeconds(waitSecond));
        String actualColor = element.getCssValue(cssProperty);
        Assert.assertEquals(expectedGreenColor, actualColor);
        return this;
    }

}
