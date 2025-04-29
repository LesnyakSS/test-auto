package work13;

import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

public class FirstException {
//Assertions.assertTrue(false);
    @Test
    public void exception(){
        try {
            System.out.println((char[]) null); // первое задание
        }
        catch (NullPointerException e){
            System.out.println("Обнаружена ошибка, взаимодействия с " + e.getMessage());
        }

        try {
            Assertions.assertTrue(false);// второе задание
        }
        catch (AssertionFailedError e){
            if (e.getExpected() != null) {
                System.out.println("Обнаружена ошибка " + e.getMessage()
                        + "\nОжидаемый результат " +e.getExpected().getValue());
            }
        }
        catch (NullPointerException e){
            System.out.println("Обнаружена ошибка, взаимодействия с " + e.getMessage());
        }
    }
}
