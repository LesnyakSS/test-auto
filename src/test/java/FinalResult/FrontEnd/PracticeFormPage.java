package FinalResult.FrontEnd;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;


public class PracticeFormPage {

    private final Inputs elementInputName = new Inputs($("#firstName"), "Поле ввода Имени");
    private final Inputs elementInputLastName = new Inputs($("#lastName"), "Поле ввода Фамилии");
    private final Inputs elementInputEmail = new Inputs($("#userEmail"), "Поле ввода Email");
    private final Inputs elementInputNumber = new Inputs($("#userNumber"), "Поле ввода Номера Телефона");
    private final Inputs elementInputAddress = new Inputs($("#currentAddress"), "Поле ввода Адреса");
    private final StateCity elementState = new StateCity($(byId("state")), "Кнопка выпадающего списка state");
    private final StateCity elementCity = new StateCity($(byId("city")), "Кнопка выпадающего списка city");
    private final Date elementDate = new Date($("#dateOfBirthInput"), "Календарь");
    private final Subjects elementSubject = new Subjects($x("//input[@id='subjectsInput']"), "Предметы");
    private final Button elementButton = new Button($(byId("submit")), "Кнопка отправки данных");
    private final Button elementButtonPopUp = new Button($(byId("closeLargeModal")), "Кнопка закрыть Popup");
    private final Picture elementPicture = new Picture($x("//label[@for = \"uploadPicture\"]"), "Кнопка загрузки картинки");
    private final Hobbies elementHobbies = new Hobbies($x("//label[@for = \"hobbies-checkbox-1\"]"), "Кнопка отправки данных");
    private final RadioButton elementRadioButton = new RadioButton($x("//label[@for = \"gender-radio-1\"]"), "RadioButton - Male");
    private final PopUp elementPopUp = new PopUp($(".modal-content"), "Форма отображения данных");
    private final SelenideElement subjectsMath = $(byId("react-select-2-option-0"));
    private final SelenideElement checkHobbies = $x("//input[@id='hobbies-checkbox-1']");
    private final String file = "toolsImage.jpg";
    private final SelenideElement fileInput = $x("//input[@id='uploadPicture']");
    private final SelenideElement stateNcr = $(byId("react-select-3-option-0"));
    private final SelenideElement cityAgra = $(byId("react-select-4-option-0"));
    private final SelenideElement monthDropdown = $x("//select[@class='react-datepicker__month-select']");
    private final SelenideElement yearDropdown = $x("//select[@class='react-datepicker__year-select']");
    private final SelenideElement datePicker = $(byClassName("react-datepicker-popper"));
    private final String xpath = "//div[contains(@class, 'react-datepicker__day') and text()='%d']";
    private final String expectedRedColor = "rgb(220, 53, 69)";
    private final String expectedGreenColor = "rgb(40, 167, 69)";
    private final String cssProperty = "border-color";
    private final String url = "https://demoqa.com/automation-practice-form";

    public void openSite() {
        open(url);

    }
        @Step("Ввести Имя")
        public PracticeFormPage setName(String name) {
            elementInputName.setValues(name);
        return this;
}
    @Step("Скроллим до элемента до поле ввода")
    public PracticeFormPage scrolleInput() {
        elementInputName.scrollElement();
        return this;
    }
    @Step("Скроллим до элемента кнопки")
    public PracticeFormPage scrolleButton() {
        elementButton.scrollElement();
        return this;
    }
        @Step("Проверка видимости поля Имя")
         public PracticeFormPage visibilityName() {
            elementInputName.visibilityInput();
        return this;
    }
         @Step("Очистка поле ввода Имя")
         public PracticeFormPage clearFieldName() {
            elementInputName.clearInput();
        return this;
    }
    @Step("Проверка красного цвета поле ввода Имя")
    public PracticeFormPage checkRedColorName() {
    elementInputName.checkRedColor(cssProperty,expectedRedColor);
        return this;
    }

    @Step("Проверка зеленого цвета поле ввода Имя")
    public PracticeFormPage checkGreenColorName() {
        elementInputName.checkGreenColor(cssProperty,expectedGreenColor);
        return this;
    }

    @Step("Ввести Фамилию")
    public PracticeFormPage setLastName(String lastName) {
        elementInputLastName.setValues(lastName);
        return this;
    }
    @Step("Проверка видимости поля Фамилию")
    public PracticeFormPage visibilityLastName() {
        elementInputLastName.visibilityInput();
        return this;
    }
    @Step("Очистка поле ввода Фамилия")
    public PracticeFormPage clearFieldLastName() {
        elementInputLastName.clearInput();
        return this;
    }

    @Step("Проверка красного цвета поле ввода Фамилия")
    public PracticeFormPage checkRedColorLastName() {
        elementInputLastName.checkRedColor(cssProperty,expectedRedColor);
        return this;
    }

    @Step("Проверка зеленого цвета поле ввода Фамилия")
    public PracticeFormPage checkGreenColorLastName() {
        elementInputLastName.checkGreenColor(cssProperty,expectedGreenColor);
        return this;
    }

    @Step("Ввести Email")
    public PracticeFormPage setEmail(String email) {
        elementInputEmail.setValues(email);
        return this;
    }
    @Step("Проверка видимости поля Email")
    public PracticeFormPage visibilityEmail() {
        elementInputEmail.visibilityInput();
        return this;
    }
    @Step("Очистка поле ввода Email")
    public PracticeFormPage clearFieldEmail() {
        elementInputEmail.clearInput();
        return this;
    }

    @Step("Проверка красного цвета поле ввода Email")
    public PracticeFormPage checkRedColorEmail() {
        elementInputEmail.checkRedColor(cssProperty,expectedRedColor);
        return this;
    }

    @Step("Проверка зеленого цвета поле ввода Email")
    public PracticeFormPage checkGreenColorEmail() {
        elementInputEmail.checkGreenColor(cssProperty,expectedGreenColor);
        return this;
    }

    @Step("Ввести Номер")
    public PracticeFormPage setNumber(String number) {
        elementInputNumber.setValues(number);
        return this;
    }
    @Step("Проверка видимости поля Номер")
    public PracticeFormPage visibilityNumber() {
        elementInputNumber.visibilityInput();
        return this;
    }
    @Step("Очистка поле ввода Номер")
    public PracticeFormPage clearFieldNumber() {
        elementInputNumber.clearInput();
        return this;
    }
    @Step("Проверка красного цвета поле ввода Номер телефона")
    public PracticeFormPage checkRedColorNumber() {
        elementInputNumber.checkRedColor(cssProperty,expectedRedColor);
        return this;
    }

    @Step("Проверка зеленого цвета поле ввода Номер телефона")
    public PracticeFormPage checkGreenColorNumber() {
        elementInputNumber.checkGreenColor(cssProperty,expectedGreenColor);
        return this;
    }
    @Step("Выбрать пол Male")
    public PracticeFormPage clickMale() {
        elementRadioButton.selectRadioButton();
        return this;
    }
    @Step("Проверка красного цвета поле ввода Gender")
    public PracticeFormPage checkRedColorGender() {
        elementRadioButton.checkRedColor(cssProperty,expectedRedColor);
        return this;
    }
    @Step("Проверка зеленого цвета поле ввода Gender")
    public PracticeFormPage checkGreenColorGender() {
        elementRadioButton.checkGreenColor(cssProperty,expectedGreenColor);
        return this;
    }


    @Step("Открыть Календарь")
    public PracticeFormPage openCalendar() {
        elementDate.openCalendar(datePicker);
        return this;
    }

    @Step("Выбрать День Рождения")
    public PracticeFormPage selectDayOfCalendar(int day) {
        elementDate.selectDay(xpath,day);
        return this;
    }
    @Step("Выбрать Месяц Рождения")
    public PracticeFormPage selectMonthOfCalendar(String month) {
        elementDate.selectMonth(monthDropdown,month);
        return this;
    }
    @Step("Выбрать Год Рождения")
    public PracticeFormPage selectYearOfCalendar(String year) {
        elementDate.selectYear(yearDropdown,year);
        return this;
    }
    @Step("Проверка зеленого цвета поле Даты рождения")
    public PracticeFormPage checkGreenColorDate() {
        elementDate.checkGreenColor(cssProperty,expectedGreenColor);
        return this;
    }
    @Step("Ввести название Предмет")
    public PracticeFormPage setSubject(String text) {
        elementSubject.setValues(text);
        return this;
    }

    @Step("Выбрать Предмет - Maths")
    public PracticeFormPage selectSubject() {
        elementSubject.clickValues(subjectsMath);
        return this;
    }


    @Step("Выбрать Хобби - Sports")
    public PracticeFormPage selectSports() {
        elementHobbies.clickCheckbox();
        return this;
    }
    @Step("Проверить, что Хобби, Sports, выбран")
    public PracticeFormPage checkHobbie() {
        elementHobbies.checkIsSelected(checkHobbies);
        return this;
    }

    @Step("Проверка зеленого цвета поле ввода Хобби")
    public PracticeFormPage checkGreenColorHobbie() {
        elementHobbies.checkGreenColor(cssProperty,expectedGreenColor);
        return this;
    }
    @Step("Загрузить Изображение")
    public PracticeFormPage loadFile() {
        elementPicture.selectFile(fileInput,file);
        return this;
    }

    @Step("Ввести Адрес")
    public PracticeFormPage setAddress(String name) {
        elementInputAddress.setValues(name);
        return this;
    }
    @Step("Проверка видимости поля Адрес")
    public PracticeFormPage visibilityAddress() {
        elementInputAddress.visibilityInput();
        return this;
    }
    @Step("Очистка поле ввода Адреса")
    public PracticeFormPage clearFieldAddress() {
        elementInputAddress.clearInput();
        return this;
    }
    @Step("Проверка зеленого цвета поле ввода Адреса")
    public PracticeFormPage checkGreenColorAddress() {
        elementInputAddress.checkGreenColor(cssProperty,expectedGreenColor);
        return this;
    }

    @Step("Выбрать Штат - Ncr")
    public PracticeFormPage selectState() {
        elementState.selectState(stateNcr);
        return this;
    }
    @Step("Открыть список Штатов")
    public PracticeFormPage openListState() {
        elementState.clickButtonState();
        return this;
    }
    @Step("Выбрать Город - Agra")
    public PracticeFormPage selectCity() {
        elementCity.selectCity(cityAgra);
        return this;
    }
    @Step("Открыть список Городов")
    public PracticeFormPage openListCity() {
        elementCity.clickButtonCity();
        return this;
    }

    @Step("Отправляем введенные данные ")
    public PracticeFormPage sendData() {
       elementButton.clickButton();
        return this;
    }
    @Step("Проверка видимости кнопки Отправить")
    public PracticeFormPage visibilityData() {
        elementButton.visibilityButton();
        return this;
    }

    @Step("Проверить, что данные в Popup соответствуют заданным")
    public PracticeFormPage checkData(String firstName,
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
        elementPopUp.verifyData(firstName,
                lastName,
                email,
                gender,
                mobile,
                date,
                subject, hobby,
                picture,
                address,
                state,
                city);
        return this;
    }
    @Step("Закрываем всплывающее окно")
    public PracticeFormPage buttonClosePopUp() {
        elementButtonPopUp.clickButton();
        return this;
    }
    @Step("Проверка видимости кнопки Закрыть")
    public PracticeFormPage visibilitybuttonClose() {
        elementButton.visibilityButton();
        return this;
    }


}
