import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
//@SpringBootTest
public class WikipediaTest {

    @AfterEach
    public void cleanup() {
        Selenide.closeWindow();
    }
    @Test
    @Description("Задания по UI")
    public void testSearch() {
        openWiki();
        performSearch("Гильгамеш");
        checkLogo();
    }


    @Step("Открыть Википедию")
    public void openWiki() {
        open("https://ru.wikipedia.org/"); // Открывает главную страницу Википедии
    }

    // Производит поиск по указанному запросу
    @Step("Выполнить поиск поле ввода и ввести текст, и нажать на иконку Лупа(искать)")
    public void performSearch(String text) {
        SelenideElement input = $(byId("searchInput"));
        input.setValue(text);
        SelenideElement button = $(byId("searchButton"));
        button.click();
    }

    @Step("Выполнить проверку логотипа и убедится что он отображается")
    public void checkLogo() {
        SelenideElement logo = $("#p-logo");
        logo.shouldBe(visible);
    }

}