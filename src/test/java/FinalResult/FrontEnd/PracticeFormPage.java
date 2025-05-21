package FinalResult.FrontEnd;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.lang.Thread.sleep;

public class PracticeFormPage {

    protected final Inputs elementInputName = new Inputs($("#firstName"), "Поле ввода Имени");
    protected final Inputs elementInputLastName = new Inputs($("#lastName"), "Поле ввода Фамилии");
    protected final Inputs elementInputEmail = new Inputs($("#userEmail"), "Поле ввода Email");
    protected final Inputs elementInputNumber = new Inputs($("#userNumber"), "Поле ввода Номера Телефона");
    protected final Inputs elementInputAddress = new Inputs($("#currentAddress"), "Поле ввода Адреса");
    protected final StateCity elementState = new StateCity($(byId("state")), "Кнопка выпадающего списка state");
    protected final StateCity elementCity = new StateCity($(byId("city")), "Кнопка выпадающего списка city");
    protected final Date elementDate = new Date($("#dateOfBirthInput"), "Календарь");
    protected final Subjects elementSubject = new Subjects($x("//input[@id='subjectsInput']"), "Предметы");
    protected final Button elementButton = new Button($(byId("submit")), "Кнопка отправки данных");
    protected final Button elementButtonPopUp = new Button($(byId("closeLargeModal")), "Кнопка закрыть Popup");
    protected final Picture elementPicture = new Picture($x("//label[@for = \"uploadPicture\"]"), "Кнопка загрузки картинки");
    protected final Hobbies elementHobbies = new Hobbies($x("//label[@for = \"hobbies-checkbox-1\"]"), "Кнопка отправки данных");
    protected final RadioButton elementRadioButton = new RadioButton($x("//label[@for = \"gender-radio-1\"]"), "RadioButton - Male");
    protected final PopUp elementPopUp = new PopUp($(".modal-content"), "Форма отображения данных");


    @Step("Открыть сайт DemoQa")
    public void openSite() {
        try{
        open("https://demoqa.com/automation-practice-form");}

        catch (TimeoutException e){
            System.out.println("Обнаружена ошибка, взаимодействия с " + e.getMessage());
        }

}
    @AfterEach
    public void cleanup() {
        Selenide.closeWindow();
    }

       @Test
    @Description("Заполнение полей регистрации, валидными данными.\n" +
                 "Отправка данных на сервер(нажатия на кнопку).\n" +
                 "Проверка заполненных данных в всплывающем окне.\n" +
                 "Закрытия формы всплывающего окна.\n"
                )
     public void testRegistrationForm() {
        step("Вводим данные в формы регистрации.", step -> {
        String firstName = "Иван";
        String lastName = "Иванов";
        String email = "test@mail.ru";
        String gender ="Male";
        String mobile ="2323232323";
        int day =22;
        String month ="November";
        String year ="1996";
        String date = String.format("%d %s,%s", day, month, year);
        String subject ="Maths";
        String hobby ="Sports";
        String picture ="toolsImage.jpg";
        String address ="Мой адрес - Не дом и не улица, Мой адрес - Советский Союз.";
        String state ="NCR";
        String city ="Delhi";

        openSite();
       Configuration.timeout = 1000;
            step("Вводим данные в Name = " + firstName + " Last Name = " + lastName +" Email = " + email);
        elementInputName.visibilityInput();
        elementInputName.clearInput();
        elementInputName.setValues(firstName);

        elementInputLastName.visibilityInput();
        elementInputLastName.clearInput();
        elementInputLastName.setValues(lastName);

        elementInputEmail.visibilityInput();
        elementInputEmail.clearInput();
        elementInputEmail.setValues(email);
            step("Выберем пол Gender = " + gender + " ,  введем Номер телефона = " + mobile);
        elementRadioButton.checkRadioButtonVisibility();
        elementRadioButton.selectRadioButton();

        elementInputNumber.visibilityInput();
        elementInputNumber.clearInput();
        elementInputNumber.setValues(mobile);
            step("Заполним Date of Birth - " + " День = " + day + " Месяц = " + month + " Год = " + year);
        elementDate.openCalendar();
        elementDate.selectMonth(month);
        elementDate.selectYear(year);
        elementDate.selectDay(day);
            step("Выберем предмет - " + subject);
        elementSubject.setValues(subject);
        elementSubject.selectValues();
            step("Выберем Hobbies - " + hobby);
        elementHobbies.selectRadioButton();
        elementHobbies.checkIsSelected();
            step("Загрузим изображение - " + picture);
        elementPicture.selectFile();
            step("Заполним поле Current Address - " + address);
        elementInputAddress.visibilityInput();
        elementInputAddress.clearInput();
        elementInputAddress.setValues(address);
            step("Выберем Штат - " + state + " и Город = " + city);
        elementState.clickButtonState();
        elementState.selectState();
        elementCity.clickButtonCity();
        elementCity.selectCity();

            step("Нажмем на кнопку - Submit");
        elementButton.visibilityButton();
        elementButton.clickButton();
            step("Отображается Popup");
        Configuration.timeout = 1000;
        elementPopUp.verifyData(
                firstName,
                lastName,
                email,
                gender,
                mobile,
                date,
                subject,
                hobby,
                picture,
                address,
                state,
                city);
            step("Нажмем на кнопку Close , для закрытии Popup");
        elementButtonPopUp.visibilityButton();
        elementButtonPopUp.clickButton();
    });
    }

    @Test
    @Description("Нажать на кнопку Submit.\n" +
            "Проверить цвет форм валидации.\n" +
            "Заполнить поля.\n" +
            "Нажать на кнопку Submit.\n"
    )
    public void testvalidationForm() {
        step("Проверка валидации в форме регистрации", step -> {
                    String firstName = "Иван";
                    String lastName = "Иванов";
                    String email = "test@mail.ru";
                    String falseEmail = "tsd";
                    String gender ="Male";
                    String mobile ="2323232323";
                    int day =22;
                    String month ="May";
                    String year ="2025";
                    String date = String.format("%d %s,%s", day, month, year);
                    String subject =null;
                    String hobby ="Sports";
                    String picture =null;
                    String address ="Мой адрес - Не дом и не улица, Мой адрес - Советский Союз.";
                    String state ="";
                    String city =null;
        openSite();
        step("Нажмем на кнопку - Submit");
        elementButton.visibilityButton();
        elementButton.clickButton();
        step("Вводим данные в Name = " + firstName);
        elementInputName.checkRedColor();
        elementInputName.testRedImageInField();
        elementInputName.setValues(firstName);
        elementInputName.checkGreenColor();
        elementInputName.testGreenImageInField();
        step("Вводим данные в Last Name = " + lastName);
        elementInputLastName.checkRedColor();
        elementInputLastName.testRedImageInField();
        elementInputLastName.setValues(lastName);
        elementInputLastName.checkGreenColor();
        elementInputLastName.testGreenImageInField();
        step("Вводим данные в Email = " + email);
        elementInputEmail.checkGreenColor();
        elementInputEmail.testGreenImageInField();
        elementInputEmail.setValues(falseEmail);
        elementInputEmail.checkRedColor();
        elementInputEmail.testRedImageInField();
        elementInputEmail.clearInput();
        elementInputEmail.checkGreenColor();
        elementInputEmail.testGreenImageInField();
        elementInputEmail.setValues(email);
        step("Выберем пол Gender = " + gender);
        elementRadioButton.checkRedColor();
        elementRadioButton.selectRadioButton();
        elementRadioButton.checkGreenColor();
        step("Введем номер телефона = " + mobile);
        elementInputNumber.checkRedColor();
        elementInputNumber.testRedImageInField();
        elementInputNumber.setValues(mobile);
        elementInputNumber.checkGreenColor();
        elementInputNumber.testGreenImageInField();
        step("Выберем дату рождения = " + day);
        elementDate.checkGreenColor();
        elementDate.testGreenImageInField();
        elementDate.openCalendar();
        elementDate.selectDay(day);
        elementDate.checkGreenColor();
        elementDate.testGreenImageInField();
        step("Выберем Hobbies - " + hobby);
        elementHobbies.checkGreenColor();
        elementHobbies.selectRadioButton();
        elementHobbies.checkGreenColor();
        step("Заполним поле Current Address - " + address);
        elementInputAddress.checkGreenColor();
        elementInputAddress.testGreenImageInField();
        elementInputAddress.setValues(address);
        elementInputAddress.checkGreenColor();
        elementInputAddress.testGreenImageInField();
        step("Нажмем на кнопку - Submit");
        elementButton.visibilityButton();
        elementButton.clickButton();
                    step("Отображается Popup");
                    Configuration.timeout = 1000;
                    elementPopUp.verifyData(
                            firstName,
                            lastName,
                            email,
                            gender,
                            mobile,
                            date,
                            subject,
                            hobby,
                            picture,
                            address,
                            state,
                            city);
                    step("Нажмем на кнопку Close , для закрытии Popup");
                    elementButtonPopUp.visibilityButton();
                    elementButtonPopUp.clickButton();
    }
    );}
}
