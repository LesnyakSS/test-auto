package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.junit.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class Subjects {

    @Getter
    SelenideElement element;
    String description;
    int waitSecond = 15;

    public Subjects(SelenideElement element, String description) {
        this.element = element;
        this.description = description;
    }


    public Subjects setValues(String text) {
        element.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond))
                .setValue(text);
        return this;
    }

    public Subjects clickValues(SelenideElement subjectsMath) {
        subjectsMath.shouldBe(Condition.visible, Duration.ofSeconds(waitSecond)).click();
        return this;
    }

}
