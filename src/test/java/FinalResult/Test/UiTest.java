package FinalResult.Test;


import FinalResult.FrontEnd.BaseTest;
import FinalResult.FrontEnd.PracticeFormPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;


public class UiTest extends BaseTest {
    String firstName = "Иван";
    String lastName = "Иванов";
    String email = "test@mail.ru";
    String incorrecEmail  = "test";
    String gender ="Male";
    String mobile ="2323232323";
    String subject ="Maths";
    String hobby ="Sports";
    String picture ="toolsImage.jpg";
    int day =22;
    String month ="November";
    String year ="1996";
    String date = String.format("%d %s,%s", day, month, year);
    String state ="NCR";
    String city ="Delhi";
    String address ="Мой адрес - Не дом и не улица, Мой адрес - Советский Союз.";
    PracticeFormPage practiceFormPage = new PracticeFormPage();

        @Test
        @Description("Проверка заполнения формы и проверка данных модального окна")
        public void test1() {

            practiceFormPage.openSite();

            practiceFormPage.visibilityName();
            practiceFormPage.setName(firstName);


            practiceFormPage.visibilityLastName();
            practiceFormPage.setLastName(lastName);


            practiceFormPage.visibilityEmail();
            practiceFormPage.setEmail(email);


            practiceFormPage.clickMale();

            practiceFormPage.visibilityNumber();
            practiceFormPage.setNumber(mobile);


            practiceFormPage.openCalendar();
            practiceFormPage.selectMonthOfCalendar(month);
            practiceFormPage.selectYearOfCalendar(year);
            practiceFormPage.selectDayOfCalendar(day);

            practiceFormPage.setSubject(subject);
            practiceFormPage.selectSubject();

            practiceFormPage.selectSports();
            practiceFormPage.checkHobbie();

            practiceFormPage.loadFile();

            practiceFormPage.visibilityAddress();
            practiceFormPage.setAddress(address);


            practiceFormPage.openListState();
            practiceFormPage.selectState();
            practiceFormPage.openListCity();
            practiceFormPage.selectCity();

            practiceFormPage.scrolleButton().visibilityData();
            practiceFormPage.sendData();

            practiceFormPage.checkData(
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

            practiceFormPage.scrolleButton().visibilitybuttonClose();
            practiceFormPage.buttonClosePopUp();
    }
    @Test
    @Description("Тест проверка валидации формы")
    public void test2(){

        practiceFormPage.openSite();

        practiceFormPage.scrolleButton().visibilityData();
        practiceFormPage.sendData();

        practiceFormPage.checkRedColorName();
        practiceFormPage.setName(firstName);
        practiceFormPage.checkGreenColorName();

        practiceFormPage.checkRedColorLastName();
        practiceFormPage.setLastName(lastName);
        practiceFormPage.checkGreenColorLastName();

        practiceFormPage.checkGreenColorEmail();
        practiceFormPage.setEmail(incorrecEmail);
        practiceFormPage.checkRedColorEmail();
        practiceFormPage.clearFieldEmail();
        practiceFormPage.setEmail(email);
        practiceFormPage.checkGreenColorEmail();

        practiceFormPage.checkRedColorGender();
        practiceFormPage.clickMale();
        practiceFormPage.checkGreenColorGender();

        practiceFormPage.checkRedColorNumber();
        practiceFormPage.setNumber(mobile);
        practiceFormPage.checkGreenColorNumber();

        practiceFormPage.checkGreenColorDate();
        practiceFormPage.openCalendar();
        practiceFormPage.selectMonthOfCalendar(month);
        practiceFormPage.selectYearOfCalendar(year);
        practiceFormPage.selectDayOfCalendar(day);
        practiceFormPage.checkGreenColorDate();



        practiceFormPage.checkGreenColorHobbie();
        practiceFormPage.selectSports();
        practiceFormPage.checkGreenColorHobbie();

        practiceFormPage.checkGreenColorAddress();
        practiceFormPage.setAddress(address);

        practiceFormPage.scrolleButton().visibilityData();
        practiceFormPage.sendData();

    }
    }

