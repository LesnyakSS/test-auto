package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Picture {

    @Getter
    SelenideElement element;
    String description;

    public Picture(SelenideElement element, String description) {
        this.element = element;
        this.description = description;
    }

    public Picture selectFile(SelenideElement fileInput, String textFile) {
        fileInput.uploadFromClasspath(textFile);
        return this;

    }

}
