package FinalResult.FrontEnd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

public class PopUp {
    @Getter
    SelenideElement element;
    String description;

    public PopUp(SelenideElement element, String description) {
        this.element = element;
        this.description = description;
    }

    public PopUp verifyData(String firstName,
                            String lastName,
                            String email,
                            String gender,
                            String mobile,
                            String date,
                            String subject,
                            String hobby,
                            String picture,
                            String address,
                            String state,
                            String city) {
        element.shouldBe(Condition.visible);
        checkField("Student Name", firstName + " " + lastName);
        checkField("Student Email", email);
        checkField("Gender", gender);
        checkField("Mobile", mobile);
        checkField("Date of Birth", date);
        checkField("Subjects", subject);
        checkField("Hobbies", hobby);
        checkField("Picture", picture);
        checkField("Address", address);
        checkField("State ", state );
        checkField("City ",  city);
        return this;
    }


    private void checkField(String fieldName, String value) {
            if (value != null && !value.isEmpty()) {
                element.shouldHave(Condition.text(value));
            } else {
                System.out.println("Поле " + fieldName + " пустое");
            }
    }
}