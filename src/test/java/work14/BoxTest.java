package work14;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static work14.Box.printBox;


public class BoxTest {
    List<Box> bigBox = new ArrayList<>();
    @Test
    void test () {
        Box a = new Box(20, 20, 30);
        Box b = new Box(30, 30, 40);
        Box c = new Box(31, 70, 30);
        Box z = new Box(30.1, 10, 30);
        List<Box> randomBox = new ArrayList<>();
        randomBox.add(a);
        randomBox.add(b);
        randomBox.add(c);
        randomBox.add(z);

        System.out.println("\nСписок всех коробок: ");
        printBox(randomBox);

        Iterator<Box> checkBox = randomBox.iterator();

        while (checkBox.hasNext()) {
            Box currentBox = checkBox.next();
            if (currentBox.getWidth() > 30){
                bigBox.add(currentBox);
                checkBox.remove();
            }
        }
        System.out.println("\nСписок оставшихся коробок после перебора: ");
        printBox(randomBox);
        System.out.println("\nСписок больших коробок: ");
        printBox(bigBox);
    }

}
