package FinalResult.FrontEnd;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    private static void setUp(){
         Configuration.pageLoadTimeout = 90000;
         Configuration.browserSize = "1920x1080";
         Configuration.browser = "chrome";
         Configuration.timeout = 60000;

    }
    @BeforeAll
    static void setUpBeforeClass() throws Exception{
        setUp();
    }
}
