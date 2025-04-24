package Work12;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Wikipage {
    protected final Input elementInput = new Input($(byId("searchInput")), "Поле ввода");
    protected final Button elemenButtom = new Button($(byId("searchButton")), "Кнопка поиска");
    protected final Logo elemenlogo = new Logo($("#p-logo"),"Логотип Wikipedia");

    @Step("Открыть Википедию")
    public void openWiki() {
        open("https://ru.wikipedia.org/");
    }
    @AfterEach
    public void cleanup() {
        Selenide.closeWindow();
    }
    @Test
    @Description("Использовать PageObject и PageElements в Тесте")
    public void testSearch() {
       openWiki();
       elementInput.visibilityInput();
       elementInput.clearInput();
       elementInput.setValues("Гамилькар Барка");
       elemenButtom.visibilityButton();
       elemenButtom.clickButton();
       elemenlogo.visibilityLogo();
    }
}