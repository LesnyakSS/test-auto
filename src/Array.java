import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        String[] arrays  = {"привет", "ПОКА", "гипербола"};
        String r = arrays[0].toUpperCase();
        String b = arrays[1].toLowerCase();
            System.out.println(r);
            System.out.println(b);

        for(int i=0 ; i<arrays.length; i++){ // перебор строк
            String a = arrays[i]; // берем по индексу строку
            StringBuilder builder = new StringBuilder(a); // в переменную вставляем первую строку
            int index = builder.indexOf("О"); // ищем, есть ли в строке вторая буква О
            if (index == 1 ){ // если индекс 1, тогда
                builder.insert(2 , " "); // вставляем в строку пробел ПО КА
                builder.insert(4 , " "); // вставляем в строку пробел ПО К А
            System.out.print(builder);
            }
        }
    }
}

