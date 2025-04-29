package work14;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Box {

    private double width;
    private double height;
    private double depth;

    static void printBox(List<Box> boxes) {
        for (Box box : boxes) {
            System.out.println(box.toString());
        }
    }
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';


   }
}