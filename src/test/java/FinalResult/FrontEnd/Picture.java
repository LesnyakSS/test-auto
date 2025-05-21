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
    protected final SelenideElement fileInput = $x("//input[@id='uploadPicture']");

    @Getter
    SelenideElement element;
    String description;
    int waitSecond = 5;

    public Picture(SelenideElement element, String description) {
        this.element = element;
        this.description = description;
    }
//    @Step("Нажать на кнопку")
//    public Picture clickFileButton() {
//        element.scrollIntoView(true);
//        element.shouldBe(Condition.exist, Duration.ofSeconds(waitSecond))
//                .click();
//        return this;
//    }


    @Step("Загрузим файл")
    public Picture selectFile() {
        fileInput.uploadFromClasspath("toolsImage.jpg");
        return this;

    }

}
