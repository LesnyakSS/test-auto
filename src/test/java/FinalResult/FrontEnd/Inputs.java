package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import lombok.Getter;
import org.junit.Assert;
import java.time.Duration;


public class Inputs {

    @Getter
    SelenideElement element;
    String description;
    int waitSecond = 15;


    public Inputs(SelenideElement element, String description) {
        this.element = element;
        this.description = description;
    }
    public Inputs visibilityInput() {
        element.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond));
        return this;
    }
    public Inputs scrollElement() {
        element.scrollIntoView(true);
        return this;
    }

    public Inputs clearInput() {
        element.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond)).clear();
        return this;
    }

    public Inputs setValues(String text) {
        element.shouldBe(Condition.enabled, Duration.ofSeconds(waitSecond))
                .setValue(text);
        return this;
    }

    public Inputs checkRedColor(String cssProperty,String expectedRedColor) {
        element.shouldBe(Condition.cssValue(cssProperty, expectedRedColor), Duration.ofSeconds(waitSecond));
        String actualColor = element.getCssValue(cssProperty);
        Assert.assertEquals(expectedRedColor, actualColor);
        return this;
    }

    public Inputs checkGreenColor(String cssProperty,String expectedGreenColor) {
        element.shouldBe(Condition.cssValue(cssProperty, expectedGreenColor), Duration.ofSeconds(waitSecond));
        String actualColor = element.getCssValue(cssProperty);
        Assert.assertEquals(expectedGreenColor, actualColor);
        return this;
    }

}
